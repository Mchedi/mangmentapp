package com.CRM.Backend.controllers;

import com.CRM.Backend.entities.MyUser;
import com.CRM.Backend.services.UserServices;
import lombok.AllArgsConstructor;
import org.apache.catalina.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/User")

public class UserController {
      private final UserServices userServices;

      @GetMapping("/getall")
      @ResponseBody
      public List<MyUser>  getAllAppEvent(){
            return userServices.RetrieveAllUsers();
      }
}
