package com.CRM.Backend.controllers;

import com.CRM.Backend.entities.MyUser;
import com.CRM.Backend.entities.Societe;
import com.CRM.Backend.services.UserServices;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
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

      @DeleteMapping("/delete/{id}")
      public ResponseEntity<String> deleteAppEvent(@PathVariable("id") Long id) {
            try {
                  userServices.DeleteUser(id);
                  return ResponseEntity.ok("User deleted successfully.");
            } catch (Exception e) {
                  return ResponseEntity.status(HttpStatus.valueOf("209")).body("ma famech l user hadhah       ");
            }
      }
      @PutMapping(value = "/affectsoc/{userid}/{socid}")
      @ResponseBody
      public void affecteretudtodepart(@PathVariable("userid") Long etudiantId ,@PathVariable("socid") Long departmentId ) {
            userServices.assignsostouser(etudiantId,departmentId);
      }
      @GetMapping("/get/{id}")
      @ResponseBody
      public MyUser getUserById(@PathVariable("id") Long id){
            return userServices.RetrieveUserById(id);
      }
}

