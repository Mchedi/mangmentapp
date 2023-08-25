package com.CRM.Backend.services.serviceImpl;

import com.CRM.Backend.entities.Caise;
import com.CRM.Backend.entities.Commande;
import com.CRM.Backend.entities.Panier;
import com.CRM.Backend.entities.dto.PanierDto;
import com.CRM.Backend.repositories.PanierRepository;
import com.CRM.Backend.repositories.societeRepository;
import com.CRM.Backend.services.PanierInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public Panier RetrievePanierById(Integer id){
    try {
        Optional<Panier> panierOptional = par.findById(id);

        if (panierOptional.isPresent()) {
            return panierOptional.get();
        } else {
            System.out.println("Panier with ID {} not found" +id);
            return null;
        }
    } catch (Exception e) {
        System.out.println("Error retrieving panier by ID " + id + e);
        throw new RuntimeException("Error retrieving panier by ID"+ e);
    }
}

    @Override
    public Panier AddPanier(PanierDto panier) {
        Panier paniertoadd = new Panier();
        paniertoadd.setQte(panier.getQte());
        paniertoadd.setMontant(panier.getMontant());

        return par.save(paniertoadd);
    }
    @Override
    public Panier UpdatePanier(Panier panier, Integer id) {
        if (par.findById(id).isPresent())
        {return par.save(panier);}
        else {System.out.println("erreur update");return  null ;}
    }
}



