package com.CRM.Backend.controllers;

import com.CRM.Backend.entities.Commande;
import com.CRM.Backend.entities.Panier;
import com.CRM.Backend.services.CommandeServices;
import com.CRM.Backend.services.PanierServices;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/Panier")

public class PanierController {
      private final PanierServices panierServices;

      @GetMapping("/getall")
      public List<Panier> getAllPaniers() {
            return panierServices.RetrieveAllPanier();
      }
      @GetMapping("/getall/{id}")
      public Panier getAllPaniersbyId(@PathVariable Integer id) {return panierServices.RetrievePanierById(id);
      }


      @PostMapping("/addPanier")
      @ResponseBody
      public Panier addpanier(@RequestBody Panier panier) {
            return panierServices.AddPanier(panier);
      }

      @PutMapping("/updatepanier")
      @ResponseBody
      public Panier updatepanier(@RequestBody Panier panier,Integer id) {
            return panierServices.UpdatePanier(panier, id);
      }
      @DeleteMapping("/{id}")
      public void Deletepanier(@PathVariable Integer id){
             panierServices.DeletePanier(id);
      }
}


