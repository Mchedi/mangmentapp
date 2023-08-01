package com.CRM.Backend.controllers;

import com.CRM.Backend.entities.MyUser;
import com.CRM.Backend.services.UserServices;
import lombok.AllArgsConstructor;
import org.apache.catalina.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/User")

public class UserController {
      private final UserServices userServices;

      @GetMapping("/getall")
      public List<MyUser>  getAllAppEvent(){
            return userServices.RetrieveAllUsers();
      }

      @PostMapping("/adduser")
      @ResponseBody
      public MyUser addUser(@RequestBody MyUser myUser) {
            return userServices.AddUser(myUser);
      }
}
