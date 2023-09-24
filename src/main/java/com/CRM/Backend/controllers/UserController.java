package com.CRM.Backend.controllers;

import com.CRM.Backend.entities.Dashboard;
import com.CRM.Backend.entities.Dto.UserDTO;
import com.CRM.Backend.entities.Dto.updateUserDto;
import com.CRM.Backend.entities.EmailRequest;
import com.CRM.Backend.entities.MyUser;
import com.CRM.Backend.entities.Societe;
import com.CRM.Backend.repositories.DashboarRepository;
import com.CRM.Backend.repositories.UserRepository;
import com.CRM.Backend.services.serviceImpl.UserServices;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;


@RestController
@AllArgsConstructor
      @RequestMapping("/User")

public class UserController {
      private final UserServices userServices;
      private final UserRepository userRepository;
      private final DashboarRepository dashboarRepository;


      @CrossOrigin(origins = "http://localhost:3000/")

      @GetMapping("/getall")
      public List<MyUser>  getAllUsers(){
            return userServices.RetrieveAllUsers();
      }
      @GetMapping("/alldtos")
      public ResponseEntity<List<UserDTO>> getAllUserDTOs() {
            List<UserDTO> userDTOs = userServices.getAllUserDTOs();
            return ResponseEntity.ok(userDTOs);
      }
      @GetMapping("/dashborad")
      public Optional<Dashboard> getadshbord(){
            return dashboarRepository.findById(1);
      }
      @PostMapping("/adduser")
      @ResponseBody
      public MyUser addUser(@RequestBody MyUser myUser) {
            return userServices.AddUser(myUser);
      }

      @DeleteMapping("/delete/{id}")
      public ResponseEntity<String> deleteAppEvent(@PathVariable("id") Long id) {
            try {
                  userServices.DeleteUser(id);
                  return ResponseEntity.ok("User deleted successfully.");
            } catch (Exception e) {
                  return ResponseEntity.status(HttpStatus.valueOf("209")).body("ma famech l user hadhah       ");
            }
      }

      @GetMapping("/getbyid")
      @ResponseBody
      public updateUserDto getUserById(Long id){
            String loggedInUserMail = SecurityContextHolder.getContext().getAuthentication().getName();
            MyUser loggedInUser = userRepository.findByMail(loggedInUserMail)
                    .orElseThrow(() -> new UsernameNotFoundException("Logged-in user not found"));
            id = loggedInUser.getId();
            return userServices.RetrieveUserById(id);
      }

      @GetMapping("/getmyusers")
      public List<Object> getMyUsersForLoggedInUser() {
            String loggedInUserMail = SecurityContextHolder.getContext().getAuthentication().getName();
            MyUser loggedInUser = userRepository.findByMail(loggedInUserMail)
                    .orElseThrow(() -> new UsernameNotFoundException("Logged-in user not found"));

            Societe societe = loggedInUser.getSocieteWork();
            if (societe != null) {
                  Long societeId = societe.getId();
                  return Collections.singletonList(userServices.getmyusers(societeId));
            } else {
                  return Collections.emptyList(); // Return an empty list if no Societe is associated with the user
            }
      }
            @GetMapping("/getmyusersinfo")
      public List<UserDTO> getMyUsersInfoForLoggedInUser() {
            String loggedInUserMail = SecurityContextHolder.getContext().getAuthentication().getName();
            MyUser loggedInUser = userRepository.findByMail(loggedInUserMail)
                    .orElseThrow(() -> new UsernameNotFoundException("Logged-in user not found"));

            Societe societe = loggedInUser.getSocieteWork();
            if (societe != null) {
                  Long societeId = societe.getId();
                  return userServices.getMyUsersInfo(societeId);
            } else {
                  return Collections.emptyList(); // Return an empty list if no Societe is associated with the user
            }
      }

      @PostMapping("/send-email")
      public void sendEmail(@RequestBody EmailRequest emailRequest) {
            try {
                  userServices.sendEmail(emailRequest.getTo(), emailRequest.getSubject(), emailRequest.getText());
            } catch (MessagingException e) {
                  // Handle exception
            }
      }
      @PutMapping("updateMyInfo")
      public ResponseEntity<String> updateMyInfo(@RequestBody MyUser updatedUser) {
            try {
                  String loggedInUserMail = SecurityContextHolder.getContext().getAuthentication().getName();

                  MyUser loggedInUser = userRepository.findByMail(loggedInUserMail)
                          .orElseThrow(() -> new UsernameNotFoundException("Logged-in user not found"));

                  userServices.updateMyInfo(loggedInUserMail, updatedUser);

                  return ResponseEntity.ok("User information updated successfully.");
            } catch (Exception e) {
                  return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating user information: " + e.getMessage());
            }
      }



}



