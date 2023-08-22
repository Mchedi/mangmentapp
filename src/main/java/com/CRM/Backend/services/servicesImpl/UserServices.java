package com.CRM.Backend.services.servicesImpl;

import com.CRM.Backend.entities.MyUser;
import com.CRM.Backend.entities.societe;
import com.CRM.Backend.repositories.*;
import com.CRM.Backend.services.UserInterface;
import org.springframework.beans.factory.annotation.Autowired;
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
        societe s1 = sr.findById(socid).get();
       u1.setSc(s1);
        ur.save(u1);

    }

}

