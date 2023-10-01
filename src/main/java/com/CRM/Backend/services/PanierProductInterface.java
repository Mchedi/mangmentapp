package com.CRM.Backend.services;


import com.CRM.Backend.entities.Panier;
import com.CRM.Backend.entities.PanierProduct;
import com.CRM.Backend.entities.dto.PanierDto;

import java.util.List;

public interface PanierProductInterface {

    public List<Panier> RetrieveAllPanierProduct();
    public String DeletePanierProductRepository(Long id);
    public PanierProduct RetrievePanierProductRepositoryById(Long id);
    public PanierProduct AddPanierProduct(PanierProduct PanierProduct);
    public PanierProduct UpdatePanierProduct(PanierProduct PanierProduct, Long id);

}
