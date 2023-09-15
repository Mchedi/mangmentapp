package com.CRM.Backend.services.serviceImpl;

import com.CRM.Backend.entities.*;
import com.CRM.Backend.repositories.*;
import com.CRM.Backend.services.SubInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

@Service
public class SubServices implements SubInterface {

    @Autowired
    UserRepository ur;
    @Autowired
    societeRepository sor;
    @Autowired
    SubRepository sur;
    @Autowired
    limitRepository limitRepository;
    @Autowired
    SubServices subscriptionService;

    @Autowired
    dashboarRepository dr;

    @Override
    public List<Sub> RetrieveAllSubs() {

        return sur.findAll();

    }

    @Override
    public void DeleteSub(Long id) {


        ur.deleteById(id);


    }

    @Override
    public Sub RetrieveSubById(Long id) {
        return sur.findById(id).get();
    }

    @Override
    public String addSub(Sub sub) {
        return null;
    }

    @Override
    public String addSub(Sub sub, Societe societe, Long userId) {
        return null;
    }


    @Override
        public String addSubadign(Sub sub, Long userId) {
            Optional<MyUser> user = ur.findById(userId);
            Societe societe = sor.findSocieteByCreator_Id(userId);

            // Calculate the price based on Durationinmonths
            int durationInMonths = sub.getDurationinmonths(); // Assuming the field name is "durationinmonths"
            int price = durationInMonths * 200;

            // Set the calculated price and purchase_date
            sub.setPrice(price);
            sub.setPurchase_date(new Date());
            LocalDate purchaseLocalDate = sub.getPurchase_date().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            LocalDate expirationLocalDate = purchaseLocalDate.plusMonths(durationInMonths);
            Date expirationDate = Date.from(expirationLocalDate.atStartOfDay(ZoneId.systemDefault()).toInstant());

            sub.setExpiration_sub_date(expirationDate); // Set the calculated expiration date

            // Save the Sub entity
            sub = sur.save(sub);
            Dashboard d =  dr.findById(1).get();
                d.setCA( d.getCA()+ sub.getPrice());
                d.setNbsc( d.getNbsc() +1);
            // Link the Sub entity to the Societe
            societe.setSubs(sub);
            societe.setChiffre_affaire( societe.getChiffre_affaire()- sub.getPrice());
            sor.save(societe);


            return "sub created";
        }





    @Override
    public Sub UpdateSub(Sub sub, Long id) {
        return null;
    }

    @Override
    public void assignSublimToSub(Long subId, Long sublimId) {
        Sub sub = sur.findById(subId).orElse(null);
        Sublim sublim = limitRepository.findById(sublimId).orElse(null);

            sub.getSublims().add(sublim); // Assign the Sublim to Sub
            sur.save(sub);
    }


        @Override
        @Scheduled(fixedRate = 1000)
        public void checkAndLogExgetSubpiredSubscriptionsForAllSocietes() {
            List<Societe> societes = new ArrayList<>();
            societes.forEach(societe -> {
            Sub sub = societe.getSubs() ; // Assuming a getter method for the subscription in Societe class
                int durationInMonths = sub.getDurationinmonths();
                Date purchaseDate = sub.getPurchase_date();
                long currentTimeMillis = System.currentTimeMillis();
                long purchaseTimeMillis = purchaseDate.getTime();
                long timeDifference = currentTimeMillis - purchaseTimeMillis;
                long differenceInDays = timeDifference / (1000 * 60 * 60 * 24);

                if (differenceInDays > (durationInMonths * 30)) {


                logExpiredSubscription(sub.getId(), societe.getName());
            }
        });}
        @Override
        public void logExpiredSubscription(Long subscriptionId, String societeName) {
            org.slf4j.LoggerFactory.getLogger(SubServices.class)
                    .info("Subscription with ID {} for Societe '{}' is expired.", subscriptionId, societeName);        }
    }






