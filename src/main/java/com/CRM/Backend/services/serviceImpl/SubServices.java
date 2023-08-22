package com.CRM.Backend.services.serviceImpl;

import com.CRM.Backend.entities.Sub;
import com.CRM.Backend.entities.Sublim;
import com.CRM.Backend.repositories.SubRepository;
import com.CRM.Backend.repositories.UserRepository;
import com.CRM.Backend.repositories.limitRepository;
import com.CRM.Backend.repositories.societeRepository;
import com.CRM.Backend.services.SubInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        Sub addedSub = sur.save(sub);

        if (addedSub != null) {
            return "Sub added successfully";
        } else {
            return "You're not allowed to add a sub";
        }}

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


}





