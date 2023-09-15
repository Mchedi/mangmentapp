package com.CRM.Backend.controllers;

import com.CRM.Backend.entities.Dto.InviteComptableRequest;
import com.CRM.Backend.entities.Dto.SocieteDTO;
import com.CRM.Backend.entities.Dto.SocieteDTO2;
import com.CRM.Backend.entities.MyUser;
import com.CRM.Backend.entities.Role;
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
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:3000/")

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


    @GetMapping("/verifsoc")
    public boolean existsoc(){
        String loggedInUserMail = SecurityContextHolder.getContext().getAuthentication().getName();

        MyUser loggedInUser = userRepository.findByMail(loggedInUserMail)
                .orElseThrow(() -> new UsernameNotFoundException("Logged-in user not found"));

        return societeService.verifsociete(loggedInUser.getMail());
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
    @PostMapping("/inviteComptable")
    public ResponseEntity<String> inviteComptable(
            @RequestBody InviteComptableRequest request
    ) {
        try {
            // Get the logged user's email
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            String directorEmail = authentication.getName();

            // Call the service function with the necessary parameters
            societeService.inviteComptable(directorEmail, request.getWorkerEmail() , request.getName(), request.getRole());

            return ResponseEntity.ok("Comptable invited and associated with the director's societe.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error inviting comptable: " + e.getMessage());
        }
    }
    @GetMapping("/details")
    public ResponseEntity<SocieteDTO> getSocieteDetails(Authentication authentication) {
        // Get the currently logged-in user from the authentication object
        String loggedInUserMail = SecurityContextHolder.getContext().getAuthentication().getName();

        MyUser loggedInUser = userRepository.findByMail(loggedInUserMail)
                .orElseThrow(() -> new UsernameNotFoundException("Logged-in user not found"));

        SocieteDTO societeDTO = societeService.getSocieteDTOByCreator(loggedInUser.getId());

        if (societeDTO != null) {
            return new ResponseEntity<>(societeDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Handle the case where the creator has no associated societe
        }
    }
        @PostMapping("/deleteComptable/{comptableEmail}")
        public ResponseEntity<String> deleteComptable(@PathVariable String comptableEmail) {

            // Get the logged user's email
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            String directorEmail = authentication.getName();

            try {
                societeService.deleteComptable(directorEmail, comptableEmail);
                return ResponseEntity.ok("Comptable has been sacked from the societe");
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error inviting comptable: " + e.getMessage());
            }
        }
    @GetMapping("/getall2")
    public List<SocieteDTO2> getAllSociete2s    () {
        List<Societe> societes = societeService.RetrieveAllSociete();

        List<SocieteDTO2> dtos = societes.stream()
                .map(societe -> {
                    SocieteDTO2 dto = new SocieteDTO2();
                    dto.setName(societe.getName());
                    dto.setChiffre_affaire(societe.getChiffre_affaire());
                    dto.setMaricule_fiscale(societe.getMaricule_fiscale());
                    dto.setAdress(societe.getAdress());
                    dto.setCreatorName(societe.getCreator() != null ? societe.getCreator().getName() : null);
                    return dto;
                })
                .collect(Collectors.toList());

        return dtos;
    }


}



