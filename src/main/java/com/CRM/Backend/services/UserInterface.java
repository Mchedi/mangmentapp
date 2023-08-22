package com.CRM.Backend.services;

import com.CRM.Backend.entities.MyUser;
import com.CRM.Backend.entities.Societe;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserInterface {

    public List<MyUser> RetrieveAllUsers();
    public ResponseEntity<String> DeleteUser(Long id);

    public MyUser RetrieveUserById(Long id);
    public MyUser AddUser(MyUser myUser);
    public MyUser UpdateUser(MyUser myUser, Long id);
    public void assignsostouser(Long userid ,Long socid) ;

    public Societe addAndAssignSocToUser(Societe sc, Long userid);
    public MyUser login(String mail, String password) ;


    }
