package com.CRM.Backend.services;

import com.CRM.Backend.entities.User;
import com.CRM.Backend.repositories.UserRepository;
import com.CRM.Backend.servicesInterfaces.UserInterface;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserServices implements UserInterface {

    @Autowired
    UserRepository ur;

    @Override
    public List<User> RetrieveAllUsers() {
        try {
            return ur.findAll();
        } catch (Exception e) {
            String customMessage = "An error occurred while retrieving all users.";
            throw new RuntimeException(customMessage, e);  }
    }

    @Override
    public void DeleteUser(Long id) {

    }

    @Override
    public User RetrieveUserById(Long id) {
        return null;
    }

    @Override
    public User AddUser(User user) {
        return null;
    }

    @Override
    public User UpdateUser(User user, Long id) {
        return null;
    }
}
