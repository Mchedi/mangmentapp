package com.CRM.Backend.services;


import com.CRM.Backend.entities.Product;
import com.CRM.Backend.entities.dto.ProductDto;

import java.util.List;

public interface ProductInterface {

    public List<Product> RetrieveAllProducts();
    public void DeleteProduct(Long id);
    public Product RetrieveProductById(Long id);

    Product AddProduct(ProductDto product);

    public Product UpdateProduct(Product product, Long id);


}
