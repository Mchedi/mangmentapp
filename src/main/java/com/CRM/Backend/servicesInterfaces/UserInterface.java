package com.CRM.Backend.servicesInterfaces;

import com.CRM.Backend.entities.MyUser;
import com.CRM.Backend.entities.Societe;

import java.util.List;

public interface UserInterface {

    public List<MyUser> RetrieveAllUsers();
    public void DeleteUser(Long id);
    public MyUser RetrieveUserById(Long id);
    public MyUser AddUser(MyUser myUser);
    public MyUser UpdateUser(MyUser myUser, Long id);
    public void assignsostouser(Long userid ,Long socid) ;

    public Societe addAndAssignSocToUser(Societe sc, Long userid);

    Societe addAndAssignUserToSociete(Societe societe, Long userId);
}
