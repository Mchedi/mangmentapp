package com.CRM.Backend.services.serviceImpl;

import com.CRM.Backend.entities.*;
import com.CRM.Backend.entities.Dto.SocieteDTO;
import com.CRM.Backend.entities.Dto.SocieteDTO2;
import com.CRM.Backend.repositories.SubOptionRepository;
import com.CRM.Backend.repositories.UserRepository;
import com.CRM.Backend.repositories.DashboarRepository;
import com.CRM.Backend.repositories.societeRepository;
import com.CRM.Backend.services.SocieteInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SocieteServices implements SocieteInterface {

    @Autowired
    UserRepository ur;
    @Autowired
    societeRepository sr;
    @Autowired
    SubOptionRepository subOptionRepository;


    @Autowired
    UserServices us;
    @Autowired
    DashboarRepository dr;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public List<Societe> RetrieveAllSociete() {
        return sr.findAll();
    }


    @Override
    public void DeletSociete(Long id) {
        sr.deleteById(id);
    }

    @Override
    public Societe RetrieveSocieteById(Long id) {
        return sr.findById(id).get();
    }

    @Override
    public Societe AddSociete(Societe soc) {
        return sr.save(soc);
    }

    @Override
    public Societe UpdateSociete(Societe societe, Long id) {
        return null;
    }

    @Override
    public Societe addAndAssignUserToSociete(Societe societe, Long userId) {
        MyUser user = ur.findById(userId).orElse(null);
        societe.setCreator(user);
        sr.save(societe);

        user.setSocieteWork(societe);
        ur.save(user);


        return societe;
    }

    @Override

    public String purchasesub(Long userid, Long Subid) {
        Optional<MyUser> user = ur.findById(userid);
        SubOption sub = subOptionRepository.findById(Subid).get();
        Societe societe = sr.findSocieteByCreator_Id(userid);       // Sub sub = sur.findById(subId).orElse(null);

            societe.setSubs(sub);
            societe.setChiffre_affaire( societe.getChiffre_affaire() - sub.getPrice());
            societe.setSub_purchase_date(new Date());

        Date expirationDate = new Date();
                     expirationDate.setMonth(expirationDate.getMonth() + 1);
            societe.setSub_expiration_date(expirationDate);
        Dashboard d =  dr.findById(1).get();
        d.setCA( d.getCA()+ sub.getPrice());
        d.setNbsc( d.getNbsc() +1);
        societe.setChiffre_affaire(societe.getChiffre_affaire()-sub.getPrice());
            sr.save(societe);
            return "Sub purchased ";


    }
    @Override

    public void inviteComptable(String directorEmail, String WorkerEmail, String name, Role role) throws MessagingException {
        MyUser director = ur.findByMail(directorEmail).get();
        MyUser woerker = new MyUser();
        Societe directorSociete = director.getSocieteWork();
     //   MyUser comptable = ur .findByMailAndRole(comptableEmail, Role.comptable).get();
        woerker.setSocieteWork(directorSociete);
        woerker.setName(name);
        woerker.setRole(role);
        woerker.setMail(WorkerEmail);
        String plainPassword = "12345";
        String hashedPassword = passwordEncoder.encode(plainPassword);
        woerker.setPassword(hashedPassword);
        ur.save(woerker);
        us.sendEmail( woerker.getMail(),  "password" ,  "welcome to my societe,  here is your password 12345, you can change it later, plz visit localhost/3000/login");
    }
    @Override

    public SocieteDTO getSocieteDTOByCreator(Long id) {
        Societe societe = sr.findByCreatorId(id).get()  ;
        /*List<MyUser> workers = ur.findAllBySocieteWorkId(societe.getId());
        List<String> workerNames = workers.stream()
                .map(MyUser::getName)
                .collect(Collectors.toList());
        List<String> workersMail = workers.stream()
                .map(MyUser::getMail)
                .collect(Collectors.toList());
        List<Role> workerRoles = workers.stream()
                .map(MyUser::getRole)
                .collect(Collectors.toList());*/

        return new SocieteDTO(
                societe.getName(),
                societe.getChiffre_affaire(),
                societe.getMaricule_fiscale(),
                societe.getAdress(),

                societe.getSub_expiration_date ()
        );

    }
    @Override

    public void deleteComptable(String directorEmail, String comptableEmail) {
        MyUser director = ur.findByMail(directorEmail).get();
        Societe directorSociete = director.getSocieteWork();
        MyUser comptable = ur.findByMailAndRole(comptableEmail, Role.comptable).get();
        comptable.setSocieteWork(null);
        ur.save(comptable);

    }

        @Override
        public boolean verifsociete(String directorEmail) {
            MyUser director = ur.findByMail(directorEmail).get();
            Societe sc =  (sr.findSocieteByCreator_Id(director.getId()) )  ;

            if (sc == null) {
                return false;
            }else
                return true ;

        }
    @Override
    public boolean verifsub(String directorEmail) {
        MyUser director = ur.findByMail(directorEmail).get();
        Societe sc =  (sr.findSocieteByCreator_Id(director.getId()) )  ;

        if (sc.getSub_expiration_date ().before(new Date()) || sc.getSubs().equals(null) )  {
            return false;
        }else
            return true ;
    }

    public SocieteDTO2 mapSocieteToDTO(Societe societe) {
        SocieteDTO2 dto =   new SocieteDTO2();
        dto.setName(societe.getName());
        dto.setChiffre_affaire(societe.getChiffre_affaire());
        dto.setMaricule_fiscale(societe.getMaricule_fiscale());
        dto.setAdress(societe.getAdress());
        dto.setCreatorName(societe.getCreator() != null ? societe.getCreator().getName() : null);
        return dto;
    }

}