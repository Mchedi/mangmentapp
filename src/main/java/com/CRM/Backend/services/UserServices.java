package com.CRM.Backend.services;

import com.CRM.Backend.entities.MyUser;
import com.CRM.Backend.repositories.UserRepository;
import com.CRM.Backend.servicesInterfaces.UserInterface;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServices implements UserInterface {

    @Autowired
    UserRepository ur;


    @Override
    public List<MyUser> RetrieveAllUsers() {

        return ur.findAll();

    }


    @Override
    public void DeleteUser(Long id) {

    }

    @Override
    public MyUser RetrieveUserById(Long id) {
        return null;
    }

    @Override
    public MyUser AddUser(MyUser myUser) {
        return null;
    }

    @Override
    public MyUser UpdateUser(MyUser myUser, Long id) {
        return null;
    }
}
