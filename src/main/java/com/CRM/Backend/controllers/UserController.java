package com.CRM.Backend.controllers;

import com.CRM.Backend.entities.Dto.UserDTO;
import com.CRM.Backend.entities.MyUser;
import com.CRM.Backend.entities.Societe;
import com.CRM.Backend.repositories.UserRepository;
import com.CRM.Backend.services.serviceImpl.UserServices;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@AllArgsConstructor
      @RequestMapping("/User")

public class UserController {
      private final UserServices userServices;
      private final UserRepository userRepository;

      @CrossOrigin(origins = "http://localhost:3000/")

      @GetMapping("/getall")
      public List<MyUser>  getAllAppEvent(){
            return userServices.RetrieveAllUsers();
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

      @GetMapping("/get/{id}")
      @ResponseBody
      public MyUser getUserById(@PathVariable("id") Long id){
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



}



