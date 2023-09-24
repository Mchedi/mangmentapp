package com.CRM.Backend.services.serviceImpl;

import com.CRM.Backend.entities.Caise;
import com.CRM.Backend.entities.Commande;
import com.CRM.Backend.entities.Product;
import com.CRM.Backend.entities.dto.CommandeDto;
import com.CRM.Backend.repositories.CommandeRepository;
import com.CRM.Backend.repositories.ProductRepository;
import com.CRM.Backend.repositories.societeRepository;
import com.CRM.Backend.services.CommandeInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class CommandeServices implements CommandeInterface {

    @Autowired
    CommandeRepository cr;
    @Autowired
    societeRepository sr;
    @Autowired
    ProductRepository productRepository;


    @Override
    public List<Commande> RetrieveAllCommandes() {
        List<Commande> commandes= cr.findAll();


        return commandes;

    }

    @Override
    public void DeleteCommande(Integer id) {
    cr.deleteById(id);
    }

    @Override
    public Commande RetrieveCommandeById(Integer id) {
        try {
        Optional<Commande> commandeOptional = cr.findById(id);

        if (commandeOptional.isPresent()) {
            return commandeOptional.get();
        } else {
            System.out.println("Commande with ID {} not found" +id);
            return null;
        }
    } catch (Exception e) {
        System.out.println("Error retrieving commande by ID " + id + e);
        throw new RuntimeException("Error retrieving commande by ID"+ e);
    }
}


    @Override
    public Commande AddCommande(CommandeDto commande){
        Commande Commandetoadd = new Commande();
        Commandetoadd.setDate(commande.getDate());
        Commandetoadd.setEtat(commande.getEtat());
        Commandetoadd.setMontant(commande.getMontant());
        return cr.save(Commandetoadd);
    }
    @Override
    public Commande UpdateCommande(Commande commande, Integer id) {
        if (cr.findById(id).isPresent())
        {return cr.save(commande);}
        else {System.out.println("erreur update");return  null ;}
    }


}




