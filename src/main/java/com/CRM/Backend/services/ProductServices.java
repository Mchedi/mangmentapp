package com.CRM.Backend.services;

import com.CRM.Backend.entities.MyUser;
import com.CRM.Backend.entities.Product;
import com.CRM.Backend.entities.societe;
import com.CRM.Backend.repositories.ProductRepository;
import com.CRM.Backend.repositories.UserRepository;
import com.CRM.Backend.repositories.societeRepository;
import com.CRM.Backend.servicesInterfaces.ProductInterface;
import com.CRM.Backend.servicesInterfaces.UserInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServices implements ProductInterface {

    @Autowired
    ProductRepository pr;
    @Autowired
    societeRepository sr;


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
        return pr.findById(id).get();
    }

    @Override
    public Product AddProduct(Product product) {
        return pr.save(product);
    }

    @Override
    public Product UpdateProduct(Product product, Long id) {
        return pr.save(product) ;
    }
}



