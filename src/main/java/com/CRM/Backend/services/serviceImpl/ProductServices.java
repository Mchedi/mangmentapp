package com.CRM.Backend.services.serviceImpl;

import com.CRM.Backend.entities.MyUser;
import com.CRM.Backend.entities.Product;
import com.CRM.Backend.entities.Societe;
import com.CRM.Backend.entities.dto.ProductDto;
import com.CRM.Backend.repositories.ProductRepository;
import com.CRM.Backend.repositories.UserRepository;
import com.CRM.Backend.repositories.societeRepository;
import com.CRM.Backend.services.ProductInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServices implements ProductInterface {

    @Autowired
    ProductRepository pr;
    @Autowired
    societeRepository sr;
    @Autowired
    UserRepository ur;

    @Override
    public List<Product> RetrieveAllProducts() {
        return pr.findAll();
    }

    @Override
    public void DeleteProduct(Long id) {
    pr.deleteById(id);
    }


    @Override
    public Product RetrieveProductById(Long id) {
        try {
            Optional<Product> productOptional = pr.findById(id);

            if (productOptional.isPresent()) {
                return productOptional.get();
            } else {
                System.out.println("Product with ID {} not found" +id);
                return null;
            }
        } catch (Exception e) {
            System.out.println("Error retrieving product by ID " + id + e);
            throw new RuntimeException("Error retrieving product by ID"+ e);
        }
    }
    @Override
    public Product AddProduct(ProductDto product) {
        Product productToAdd = new Product();
        productToAdd.setName(productToAdd.getName());
        productToAdd.setPrice(productToAdd.getPrice());
        productToAdd.setCategory(productToAdd.getCategory());
        productToAdd.setPicture(productToAdd.getPicture());

        return pr.save(productToAdd);
    }

    @Override
    public Product UpdateProduct(Product product, Long id) {
        if (pr.findById(id).isPresent())
        {return pr.save(product);}
        else {System.out.println("erreur update");return  null ;}
    }
    @Override

    public Product addProductAndAssignUser(ProductDto productDto, Long userId) {
        // Find the logged-in user's societe
        MyUser loggedInUser = ur.findById(userId)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        Societe userSociete = loggedInUser.getSocieteWork() ;

        // Create a new product and set its societe to the user's societe
        Product newProduct = new Product();
        newProduct.setName(productDto.getName());
        newProduct.setPrice(productDto.getPrice());
        newProduct.setCategory(productDto.getCategory());
        newProduct.setPicture(productDto.getPicture());
        newProduct.setSociete(userSociete);

        // Save the product
        return pr.save(newProduct);
    }




}