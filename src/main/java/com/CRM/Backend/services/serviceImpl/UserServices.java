package com.CRM.Backend.services.serviceImpl;

import com.CRM.Backend.entities.MyUser;
import com.CRM.Backend.entities.Societe;
import com.CRM.Backend.repositories.*;
import com.CRM.Backend.services.UserInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServices implements UserInterface {

    @Autowired
    UserRepository ur;
    @Autowired
    societeRepository sr;


    @Override
    public List<MyUser> RetrieveAllUsers() {

        return ur.findAll();

    }


    @Override
    public ResponseEntity<String> DeleteUser(Long id) {
        try {
            ur.deleteById(id);
            return ResponseEntity.ok("User deleted successfully.");
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Unable to delete user due to data integrity violation.");
        }
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
    public Societe addAndAssignSocToUser(Societe sc, Long userid) {
        return null;
    }

    @Override
    public MyUser login(String mail, String password) {
        return null;
    }


}
