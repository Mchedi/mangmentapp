package com.CRM.Backend.services;

import com.CRM.Backend.entities.Panier;
import com.CRM.Backend.entities.Product;
import com.CRM.Backend.repositories.PanierRepository;
import com.CRM.Backend.repositories.ProductRepository;
import com.CRM.Backend.repositories.societeRepository;
import com.CRM.Backend.servicesInterfaces.PanierInterface;
import com.CRM.Backend.servicesInterfaces.ProductInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PanierServices implements PanierInterface {

    @Autowired
    PanierRepository par;
    @Autowired
    societeRepository sr;


    @Override
    public List<Panier> RetrieveAllPanier() {
        return par.findAll();
    }

    @Override
    public void DeletePanier(Integer id) {
        par.deleteById(id);

    }

    @Override
    public Panier RetrievePanierById(Integer id) {
        return par.findById(id).get();
    }

    @Override
    public Panier AddPanier(Panier panier) {
        return par.save(panier);
    }

    @Override
    public Panier UpdatePanier(Panier panier, Integer id) {
        return par.save(panier);
    }
}



