package com.CRM.Backend.services;

import com.CRM.Backend.entities.Dto.UserDTO;
import com.CRM.Backend.entities.Dto.updateUserDto;
import com.CRM.Backend.entities.MyUser;
import com.CRM.Backend.entities.Societe;
import org.springframework.http.ResponseEntity;

import javax.mail.MessagingException;
import java.util.List;

public interface UserInterface {

    public List<MyUser> RetrieveAllUsers();
    public ResponseEntity<String> DeleteUser(Long id);

    public updateUserDto RetrieveUserById(Long id);
    public MyUser AddUser(MyUser myUser);
    public MyUser UpdateUser(MyUser myUser, Long id);

    void updateMyInfo(String loggedInUserMail, MyUser updatedUser);

    public Societe addAndAssignSocToUser(Societe sc, Long userid);
    public MyUser login(String mail, String password) ;

    public List<MyUser> getmyusers(Long id);


    List<UserDTO> getMyUsersInfo(Long id);
    void sendEmail(String to, String subject, String text) throws MessagingException;
}
