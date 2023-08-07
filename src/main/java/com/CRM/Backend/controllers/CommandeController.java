package com.CRM.Backend.controllers;

import com.CRM.Backend.entities.Commande;
import com.CRM.Backend.entities.Product;
import com.CRM.Backend.services.CommandeServices;
import com.CRM.Backend.services.ProductServices;
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
      public Commande addcommande(@RequestBody Commande commande) {
            return commandeServices.AddCommande(commande);
      }

      @PutMapping("/updateproduct")
      @ResponseBody
      public Commande updatecommande(@RequestBody Commande commande,Integer id) {
            return commandeServices.UpdateCommande(commande, id);
      }
      @DeleteMapping("/{id}")
      public void Deletecommande(@PathVariable Integer id){
             commandeServices.DeleteCommande(id);
      }
}

