package com.CRM.Backend.controllers;

import com.CRM.Backend.entities.Commande;
import com.CRM.Backend.entities.dto.CommandeDto;
import com.CRM.Backend.services.serviceImpl.CommandeServices;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/Commande")

public class CommandeController {
      private final CommandeServices commandeServices;

      @GetMapping("/getall")
      public List<Commande> getAllCommandes() {
            return commandeServices.RetrieveAllCommandes();
      }
      @GetMapping("/getall/{id}")
      public Commande getAllCommnadesbyId(@PathVariable Integer id) {return commandeServices.RetrieveCommandeById(id);
      }


      @PostMapping("/addCommande")
      @ResponseBody
      public Commande addcommande(@RequestBody CommandeDto commande) {
            return commandeServices.AddCommande(commande);
      }

      @PutMapping("/updateproduct/{id}")
      @ResponseBody
      public Commande updatecommande(@RequestBody Commande commande,@PathVariable Integer id) {
            return commande;
      }
      @DeleteMapping("/{id}")
      public void Deletecommande(@PathVariable Integer id){
             commandeServices.DeleteCommande(id);
      }
}


