package com.CRM.Backend.servicesInterfaces;

import com.CRM.Backend.entities.User;

import java.util.List;

public interface UserInterface {

    public List<User> RetrieveAllUsers();
    public void DeleteUser(Long id);
    public User RetrieveUserById(Long id);
    public User AddUser(User user);
    public User UpdateUser(User user,Long id);
}
