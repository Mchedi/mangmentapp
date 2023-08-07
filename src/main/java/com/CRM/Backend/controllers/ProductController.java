package com.CRM.Backend.controllers;

import com.CRM.Backend.entities.Product;
import com.CRM.Backend.services.ProductServices;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/Product")

public class ProductController {
      private final ProductServices productServices;

      @GetMapping("/getall")
      public List<Product> getAllProducts() {
            return productServices.RetrieveAllProducts();
      }
      @GetMapping("/getall/{id}")
      public Product getAllProductsbyId(@PathVariable Long id) {
            return productServices.RetrieveProductById(id);
      }


      @PostMapping("/addproduct")
      @ResponseBody
      public Product addproduct(@RequestBody Product product) {
            return productServices.AddProduct(product);
      }

      @PutMapping("/updateproduct")
      @ResponseBody
      public Product updateproduct(@RequestBody Product product,Long id) {
            return productServices.UpdateProduct(product, id);
      }
      @DeleteMapping("/{id}")
      public void Deleteproduct(@PathVariable Long id){
            productServices.DeleteProduct(id);
      }
      }

