package com.CRM.Backend.servicesInterfaces;

import com.CRM.Backend.entities.MyUser;
import org.apache.catalina.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserInterface {

    public List<MyUser> RetrieveAllUsers();
    public void DeleteUser(Long id);
    public MyUser RetrieveUserById(Long id);
    public MyUser AddUser(MyUser myUser);
    public MyUser UpdateUser(MyUser myUser, Long id);
    public void assignsostouser(Long userid ,Long socid) ;

}
