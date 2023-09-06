package com.CRM.Backend.controllers;

import com.CRM.Backend.entities.MyUser;
import com.CRM.Backend.entities.Societe;
import com.CRM.Backend.repositories.UserRepository;
import com.CRM.Backend.security.CustomUserDetailsService;
import com.CRM.Backend.services.serviceImpl.SocieteServices;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import org.springframework.security.core.context.SecurityContextHolder;


import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/Societe")

public class SocieteController {
      private final SocieteServices societeService;
    private final UserRepository userRepository;

    private final CustomUserDetailsService customUserDetailsService;


    @CrossOrigin(origins = "http://localhost:3000/")

    @GetMapping("/getall")
      public List<Societe>  getAllSociete(){

            return societeService.RetrieveAllSociete();
      }

// ...

    @CrossOrigin(origins = "http://localhost:3000/")
    @PostMapping("/addAndAssignUser")
    public ResponseEntity<Societe> addAndAssignUserToSociete(@RequestBody Societe societe) {
        String loggedInUserMail = SecurityContextHolder.getContext().getAuthentication().getName();

        MyUser loggedInUser = userRepository.findByMail(loggedInUserMail)
                .orElseThrow(() -> new UsernameNotFoundException("Logged-in user not found"));

        Societe addedSociete = societeService.addAndAssignUserToSociete(societe, loggedInUser.getId());

        if (addedSociete != null) {
            return ResponseEntity.ok(addedSociete);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }



      @DeleteMapping("/delete/{id}")
      public ResponseEntity<String> deleteAppEvent(@PathVariable("id") Long id) {
            try {
                  societeService.DeletSociete(id);
                  return ResponseEntity.ok("User deleted successfully.");
            } catch (Exception e) {
                  return ResponseEntity.status(HttpStatus.valueOf("209")).body("ma famech l user hadhah       ");
            }
      }

      @GetMapping("/get/{id}")
      @ResponseBody
      public Societe getUserById(@PathVariable("id") Long id){
            return societeService.RetrieveSocieteById(id);
      }

    @PostMapping("/{societeId}/purchase_sub/{subId}")
    public ResponseEntity<String> assignSubToSociete(
            @PathVariable Long societeId,
            @PathVariable Long subId) {

        String result = societeService.assignSocieteToSub(societeId, subId);
        return ResponseEntity.ok(result);
    }
    @PostMapping("/inviteComptable/{comptableEmail}")
    public ResponseEntity<String> inviteComptable(@PathVariable String comptableEmail) {

        // Get the logged user's email
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String directorEmail = authentication.getName();

        try {
            societeService.inviteComptable(directorEmail, comptableEmail);
            return ResponseEntity.ok("Comptable invited and associated with the director's societe.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error inviting comptable: " + e.getMessage());
        }
    }
}



