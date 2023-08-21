package com.CRM.Backend.controllers;

import com.CRM.Backend.entities.Sub;
import com.CRM.Backend.entities.Sublim;
import com.CRM.Backend.services.SubServices;
import com.CRM.Backend.services.SublimitServices;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/sublimit")

public class SublimitController {
      private final SublimitServices sublimitServices;

      @GetMapping("/getall")
      public List<Sublim>  getAllsublimit(){
            return sublimitServices.RetrieveALLSublim();
      }

      @PostMapping("/addsublimit")
      @ResponseBody
      public Sublim addUser(@RequestBody Sublim sublim) { return sublimitServices.AddSublim(sublim);
      }

      @DeleteMapping("/delete/{id}")
      public ResponseEntity<String> deleteSUb(@PathVariable("id") Long id) {
            try {
                  sublimitServices.DeleteSublim (id);
                  return ResponseEntity.ok("User deleted successfully.");
            } catch (Exception e) {
                  return ResponseEntity.status(HttpStatus.valueOf("209")).body("ma famech l limit hadhah       ");
            }
      }

      @GetMapping("/get/{id}")
      @ResponseBody
      public Sublim getUserById(@PathVariable("id") Long id){
            return sublimitServices.RetrieveSublimById(id);
      }

}

