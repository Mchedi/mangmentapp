package com.CRM.Backend.servicesInterfaces;

import com.CRM.Backend.entities.MyUser;
import com.CRM.Backend.entities.Societe;
import com.CRM.Backend.entities.Sublim;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface SublimInterface {

    public List<Sublim> RetrieveAllUsers();
    public ResponseEntity<String> DeleteUser(Long id);
    public Sublim RetrieveUserById(Long id);
    public Sublim AddUser(Sublim sublim);
    public Sublim UpdateUser(Sublim sublim, Long id);
    public void assignsostouser(Long userid ,Long socid) ;



    }
