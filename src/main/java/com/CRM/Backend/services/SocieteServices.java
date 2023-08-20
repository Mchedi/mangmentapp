package com.CRM.Backend.services;

import com.CRM.Backend.entities.MyUser;
import com.CRM.Backend.entities.Societe;
import com.CRM.Backend.repositories.UserRepository;
import com.CRM.Backend.repositories.societeRepository;
import com.CRM.Backend.servicesInterfaces.SocieteInterface;
import com.CRM.Backend.servicesInterfaces.UserInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SocieteServices implements SocieteInterface {

    @Autowired
    UserRepository ur;
    @Autowired
    societeRepository sr;
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
        return  sr.save(soc);
    }

    @Override
    public Societe UpdateSociete(Societe societe, Long id) {
        return null;
    }

    @Override
    public Societe addAndAssignUserToSociete(Societe societe, Long userId) {
        MyUser user = ur.findById(userId).orElse(null);
        societe.setU(user);
        return sr.save(societe);
    }
}