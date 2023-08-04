package com.CRM.Backend.services;

import com.CRM.Backend.entities.MyUser;
import com.CRM.Backend.entities.Societe;
import com.CRM.Backend.repositories.UserRepository;
import com.CRM.Backend.repositories.societeRepository;
import com.CRM.Backend.servicesInterfaces.UserInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SocieteServices implements UserInterface {

    @Autowired
    UserRepository ur;
    @Autowired
    societeRepository sr;


    /*@Override
    public List<Societe> RetrieveAllUsers() {

        return srr.findAll();

    }*/


    @Override
    public List<MyUser> RetrieveAllUsers() {
        return null;
    }

    @Override
    public void DeleteUser(Long id) {
        ur.deleteById(id);

    }

    @Override
    public MyUser RetrieveUserById(Long id) {
        return ur.findById(id).get();
    }


    @Override
    public MyUser AddUser(MyUser myUser) {
        return ur.save(myUser);

    }

    @Override
    public MyUser UpdateUser(MyUser myUser, Long id) {
        return null;
    }

    @Override
    public void assignsostouser(Long userid, Long socid) {
        MyUser u1 = ur.findById(userid).get();
        Societe s1 = sr.findById(socid).get();
        u1.setSc(s1);
        ur.save(u1);
    }

    @Override
    public Societe addAndAssignSocToUser(Societe sc, Long userid) {
        return null;
    }

    @Override
    public Societe addAndAssignUserToSociete(Societe societe, Long userId) {
        MyUser user = ur.findById(userId).orElse(null);
         societe.setU(user);
            return sr.save(societe);

        }}