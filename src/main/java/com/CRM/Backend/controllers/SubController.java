package com.CRM.Backend.controllers;

import com.CRM.Backend.entities.Dto.SubDTO;
import com.CRM.Backend.entities.MyUser;
import com.CRM.Backend.entities.Societe;
import com.CRM.Backend.entities.Sub;
import com.CRM.Backend.repositories.UserRepository;
import com.CRM.Backend.services.serviceImpl.SubServices;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/sub")

public class SubController {
      private final SubServices subServices;
      private final UserRepository userRepository;


      @GetMapping("/getall")
      public List<Sub> getAllSubs() {
            return subServices.RetrieveAllSubs();
      }
      @GetMapping("/alldtos")
      public ResponseEntity<List<SubDTO>> getAllSubDTOs() {
            List<SubDTO> subDTOs = subServices.getAllSubDTOs();
            return ResponseEntity.ok(subDTOs);
      }
      @PostMapping("/add")
      public ResponseEntity<String> addSubscription(@RequestBody Sub sub) {
            try {
                  // Get the logged-in user
                  String loggedInUserMail = SecurityContextHolder.getContext().getAuthentication().getName();
                  MyUser loggedInUser = userRepository.findByMail(loggedInUserMail)
                          .orElseThrow(() -> new UsernameNotFoundException("Logged-in user not found"));
                  // Call the service method to add the subscription
                  String result = subServices.addSubadign(sub, loggedInUser.getId() );

                  return ResponseEntity.ok(result);
            } catch (Exception e) {
                  return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error adding subscription: " + e.getMessage());
            }
      }


      @DeleteMapping("/delete/{id}")
      public ResponseEntity<String> deleteSUb(@PathVariable("id") Long id) {
            try {
                  subServices.DeleteSub(id);
                  return ResponseEntity.ok("User deleted successfully.");
            } catch (Exception e) {
                  return ResponseEntity.status(HttpStatus.valueOf("209")).body("ma famech l user hadhah       ");
            }
      }

      @GetMapping("/get/{id}")
      @ResponseBody
      public Sub getUserById(@PathVariable("id") Long id) {
            return subServices.RetrieveSubById(id);
      }

      @PostMapping("/{subId}/assign-sublim/{sublimId}")
      public void assignSublimToSub(@PathVariable Long subId, @PathVariable Long sublimId) {
            subServices.assignSublimToSub(subId, sublimId);
      }

}