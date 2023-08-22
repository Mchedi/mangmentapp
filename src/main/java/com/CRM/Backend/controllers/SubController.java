package com.CRM.Backend.controllers;

import com.CRM.Backend.entities.Sub;
import com.CRM.Backend.services.serviceImpl.SubServices;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/sub")

public class SubController {
      private final SubServices subServices;

      @GetMapping("/getall")
      public List<Sub> getAllSubs() {
            return subServices.RetrieveAllSubs();
      }

      @PostMapping("/addsub")
      @ResponseBody
      public String addsub(@RequestBody Sub sub) {
            return subServices.addSub(sub);
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