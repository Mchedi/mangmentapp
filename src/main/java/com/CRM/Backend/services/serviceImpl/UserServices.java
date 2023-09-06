package com.CRM.Backend.services.serviceImpl;

import com.CRM.Backend.entities.Dto.UserDTO;
import com.CRM.Backend.entities.MyUser;
import com.CRM.Backend.entities.Societe;
import com.CRM.Backend.repositories.*;
import com.CRM.Backend.services.UserInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    /*@Override
    public List<MyUser> getmyusers(Long id) {
        List<MyUser> workers = new ArrayList<>();
        MyUser dirct = ur.findById(id).get();
        Societe sc = sr.findById(dirct.getSocieteWork().getId()).get();
        Long scid= sc.getId();
        workers.add(ur.findAllBySocieteWorkId(scid).get());
        return workers;

    }*/
    @Override
    public List<MyUser> getmyusers(Long id) {
        return ur.findAllBySocieteWorkId(id);
    }

    @Override
    public List<UserDTO> getMyUsersInfo(Long id) {
        List<MyUser> users = ur.findAllBySocieteWorkId(id);

        // Create a list of UserDTO objects
        List<UserDTO> userDTOs = new ArrayList<>();
        for (MyUser user : users) {
            UserDTO userDTO = new UserDTO();
            userDTO.setName(user.getName());
            userDTO.setMail(user.getMail());
            userDTO.setRole(user.getRole());

            // Check if the user has an associated Societe and set its name
            if (user.getSocieteWork() != null) {
                userDTO.setSocieteName(user.getSocieteWork().getName());
            }

            userDTOs.add(userDTO);
        }

        return userDTOs;
    }


}
