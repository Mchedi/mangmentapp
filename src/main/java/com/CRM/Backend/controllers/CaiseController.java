package com.CRM.Backend.controllers;

import com.CRM.Backend.entities.Caise;
import com.CRM.Backend.entities.Panier;
import com.CRM.Backend.services.CaiseServices;
import com.CRM.Backend.services.PanierServices;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/Caise")

public class CaiseController {
      private final CaiseServices caiseServices;

      @GetMapping("/getall")
      public List<Caise> getAllCaise() {
            return caiseServices.RetrieveAllCaise();
      }
      @GetMapping("/getall/{id}")
      public Caise getAllCaisesbyId(@PathVariable Integer id) {return caiseServices.RetrieveCaiseById(id);
      }


      @PostMapping("/addCaise")
      @ResponseBody
      public Caise addcaise(@RequestBody Caise caise) {
            return caiseServices.AddCaise(caise);
      }

      @PutMapping("/updatepanier")
      @ResponseBody
      public Caise updatecaise(@RequestBody Caise caise,Integer id) {return caiseServices.UpdateCaise(caise, id);
      }
      @DeleteMapping("/{id}")
      public void Deletecaise(@PathVariable Integer id){
            caiseServices.DeleteCaise(id);
      }
}


