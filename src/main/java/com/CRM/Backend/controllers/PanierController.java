package com.CRM.Backend.controllers;

import com.CRM.Backend.entities.Panier;
import com.CRM.Backend.entities.Product;
import com.CRM.Backend.entities.dto.PanierDto;
import com.CRM.Backend.services.serviceImpl.PanierServices;
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
      public Panier addpanier(@RequestBody PanierDto panier) {
            return panierServices.AddPanier(panier);
      }

      @PutMapping("/updatepanier")
      @ResponseBody
      public Panier updatePanier(@RequestBody Panier panier,Integer id) {
            return panierServices.UpdatePanier(panier, id);
      }
      @DeleteMapping("/{id}")
      public void DeletePanier(@PathVariable Integer id){
             panierServices.DeletePanier(id);
      }

      @GetMapping("/ListeProduits/{id}")
      public List<Product> ListeProduits(@PathVariable int id) {return panierServices.ListeProduits(id);
      }

}


