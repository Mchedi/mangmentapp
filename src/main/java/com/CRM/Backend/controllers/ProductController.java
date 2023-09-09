package com.CRM.Backend.controllers;

import com.CRM.Backend.entities.MyUser;
import com.CRM.Backend.entities.Product;
import com.CRM.Backend.entities.dto.ProductDto;
import com.CRM.Backend.repositories.UserRepository;
import com.CRM.Backend.services.serviceImpl.ProductServices;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/Product")

public class ProductController {
      private final ProductServices productServices;
      private final UserRepository userRepository;


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
      public Product addproduct(@RequestBody ProductDto product) {
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

      @PostMapping("/add")
      public ResponseEntity<Product> addProduct(@RequestBody ProductDto productDto, Authentication authentication) {
            if (authentication != null && authentication.isAuthenticated()) {
                  // Get the currently logged-in user from the authentication object
                  String loggedInUserMail = SecurityContextHolder.getContext().getAuthentication().getName();

                  MyUser loggedInUser = userRepository.findByMail(loggedInUserMail)
                          .orElseThrow(() -> new UsernameNotFoundException("Logged-in user not found"));

                  // Call the productService to add the product and assign it to the logged-in user's societe
                  Product addedProduct = productServices.addProductAndAssignUser(productDto, loggedInUser.getSocieteWork().getId() );

                  if (addedProduct != null) {
                        return ResponseEntity.ok(addedProduct);
                  } else {
                        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
                  }
            } else {
                  return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
            }

      }
      @GetMapping("/society-products")
      public List<Product> getAllProductsCreatedByLoggedInUser(Authentication authentication) {
            // Retrieve the currently logged-in user's information from the authentication object
            String loggedInUserMail = SecurityContextHolder.getContext().getAuthentication().getName();

            MyUser loggedInUser = userRepository.findByMail(loggedInUserMail)
                    .orElseThrow(() -> new UsernameNotFoundException("Logged-in user not found"));

            // Call the ProductService to retrieve products associated with the user's created society
            return productServices.Retrievemyprodcuts(loggedInUser.getId());
      }
}


