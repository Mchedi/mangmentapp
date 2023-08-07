package com.CRM.Backend.servicesInterfaces;


import com.CRM.Backend.entities.Product;

import java.util.List;

public interface ProductInterface {

    public List<Product> RetrieveAllProducts();
    public void DeleteProduct(Long id);
    public Product RetrieveProductById(Long id);
    public Product AddProduct(Product product);
    public Product UpdateProduct(Product product, Long id);


}
