package com.CRM.Backend.controllers;

import com.CRM.Backend.entities.MyUser;
import com.CRM.Backend.entities.Societe;
import com.CRM.Backend.services.UserServices;
import lombok.AllArgsConstructor;
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
      @ResponseBody
      public void deleteAppEvent(@PathVariable("id") Long id){
            userServices.DeleteUser(id);
      }
      @PutMapping(value = "/affectsoc/{userid}/{socid}")
      @ResponseBody
      public void affecteretudtodepart(@PathVariable("userid") Long etudiantId ,@PathVariable("socid") Long departmentId ) {
            userServices.assignsostouser(etudiantId,departmentId);
      }  @PostMapping("/addAndAssignUser/{userId}")
      public ResponseEntity<Societe> addAndAssignUserToSociete(@RequestBody Societe societe, @PathVariable Long userId) {
            Societe addedSociete = userServices.addAndAssignUserToSociete(societe, userId);

            if (addedSociete != null) {
                  return ResponseEntity.ok(addedSociete);
            } else {
                  // Handle case where user with the specified ID was not found.
                  // You might want to return an appropriate error response or handle it based on your application's logic.
                  return ResponseEntity.notFound().build();
            }
      }
}

