package com.CRM.Backend.controllers;

import com.CRM.Backend.entities.MyUser;
import com.CRM.Backend.services.servicesImpl.UserServices;
import lombok.AllArgsConstructor;
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

      @PutMapping(value = "/affectsoc/{userid}/{socid}")
      @ResponseBody
      public void affecteretudtodepart(@PathVariable("userid") Long etudiantId ,@PathVariable("socid") Long departmentId ) {
            userServices.assignsostouser(etudiantId,departmentId);
      }
}
