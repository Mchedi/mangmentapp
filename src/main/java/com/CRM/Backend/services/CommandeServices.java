package com.CRM.Backend.services;

import com.CRM.Backend.entities.Commande;
import com.CRM.Backend.entities.Product;
import com.CRM.Backend.repositories.CommandeRepository;
import com.CRM.Backend.repositories.ProductRepository;
import com.CRM.Backend.repositories.societeRepository;
import com.CRM.Backend.servicesInterfaces.CommandeInterface;
import com.CRM.Backend.servicesInterfaces.ProductInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommandeServices implements CommandeInterface {

    @Autowired
    CommandeRepository cr;
    @Autowired
    societeRepository sr;


    @Override
    public List<Commande> RetrieveAllCommandes() {
        return cr.findAll();
    }

    @Override
    public void DeleteCommande(Integer id) {
    cr.deleteById(id);
    }

    @Override
    public Commande RetrieveCommandeById(Integer id) {
        return cr.findById(id).get();
    }

    @Override
    public Commande AddCommande(Commande commande) {
        return cr.save(commande);
    }

    @Override
    public Commande UpdateCommande(Commande commande, Integer id) {
        return cr.save(commande);
    }
}



