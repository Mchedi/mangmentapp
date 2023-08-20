package com.CRM.Backend.services;

import com.CRM.Backend.entities.Sub;
import com.CRM.Backend.repositories.SubRepository;
import com.CRM.Backend.repositories.UserRepository;
import com.CRM.Backend.repositories.societeRepository;
import com.CRM.Backend.servicesInterfaces.SubInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubServices implements SubInterface {

    @Autowired
    UserRepository ur;
    @Autowired
    societeRepository sr;
    @Autowired
    SubRepository sur;

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
    public Sub AddSub(Sub sub) {
        return sur.save(sub);

    }

    @Override
    public Sub UpdateSub(Sub sub, Long id) {
        return null;
    }}






