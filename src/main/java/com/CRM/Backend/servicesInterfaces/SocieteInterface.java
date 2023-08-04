package com.CRM.Backend.servicesInterfaces;

import com.CRM.Backend.entities.MyUser;
import com.CRM.Backend.entities.Societe;

import java.util.List;

public interface SocieteInterface {

    public List<Societe> RetrieveAllUsers();
    public void DeleteUser(Long id);
    public Societe RetrieveUserById(Long id);
    public Societe AddUser(Societe myUser);
    public Societe UpdateUser(Societe myUser, Long id);
    public void assignsostouser(Long userid ,Long socid) ;


}
