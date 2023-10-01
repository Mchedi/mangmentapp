package com.CRM.Backend.services.serviceImpl;

import com.CRM.Backend.entities.Panier;
import com.CRM.Backend.entities.PanierProduct;
import com.CRM.Backend.entities.Product;
import com.CRM.Backend.entities.dto.PanierDto;
import com.CRM.Backend.repositories.PanierProductRepository;
import com.CRM.Backend.repositories.PanierRepository;
import com.CRM.Backend.repositories.ProductRepository;
import com.CRM.Backend.repositories.societeRepository;
import com.CRM.Backend.services.PanierInterface;
import com.CRM.Backend.services.PanierProductInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class PanierProductServices implements PanierProductInterface {

    @Autowired
    PanierRepository par;


    @Autowired
    PanierProductRepository PanierProductRepository;



    public List<Panier> RetrieveAllPanierProduct() {
        return par.findAll();
    }

    public String DeletePanierProductRepository(Long id) {
        if(PanierProductRepository.findById(id).isPresent()) {
            PanierProductRepository.deleteById(id);
            return "DONE";
        }
        else{return "ERREUR";}
    }


    public PanierProduct RetrievePanierProductRepositoryById(Long id) {
        try {
            return PanierProductRepository.findById(id).get();

        } catch (Exception e) {
            System.out.println("Error retrieving panier by ID " + id + e);
            throw new RuntimeException("Error retrieving panier by ID" + e);
        }
    }


    public PanierProduct AddPanierProduct(PanierProduct PanierProduct) {

        return PanierProductRepository.save(PanierProduct);
    }

    public PanierProduct UpdatePanierProduct(PanierProduct PanierProduct, Long id) {
        if (PanierProductRepository.findById(id).isPresent()) {
            return PanierProductRepository.save(PanierProduct);

        } else {
            System.out.println("erreur update");
            return null;
        }
    }

}




