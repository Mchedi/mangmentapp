package com.CRM.Backend.services;

import com.CRM.Backend.entities.Dto.UserDTO;
import com.CRM.Backend.entities.MyUser;
import com.CRM.Backend.entities.Societe;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserInterface {

    public List<MyUser> RetrieveAllUsers();

    //List<MyUser> RetrieveAlldrector();

    public ResponseEntity<String> DeleteUser(Long id);

    public MyUser RetrieveUserById(Long id);
    public MyUser AddUser(MyUser myUser);
    public MyUser UpdateUser(MyUser myUser, Long id);

    public Societe addAndAssignSocToUser(Societe sc, Long userid);
    public MyUser login(String mail, String password) ;


    /*@Override
    public List<MyUser> getmyusers(Long id) {
        List<MyUser> workers = new ArrayList<>();
        MyUser dirct = ur.findById(id).get();
        Societe sc = sr.findById(dirct.getSocieteWork().getId()).get();
        Long scid= sc.getId();
        workers.add(ur.findAllBySocieteWorkId(scid).get());
        return workers;

    }*/
    List<MyUser> getmyusers(Long id);

    List<UserDTO> getMyUsersInfo(Long id);
}
