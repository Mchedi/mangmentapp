package com.CRM.Backend.services.serviceImpl;

import com.CRM.Backend.entities.Panier;
import com.CRM.Backend.entities.Product;
import com.CRM.Backend.entities.dto.PanierDto;
import com.CRM.Backend.repositories.PanierRepository;
import com.CRM.Backend.repositories.ProductRepository;
import com.CRM.Backend.repositories.societeRepository;
import com.CRM.Backend.services.PanierInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service
public class PanierServices implements PanierInterface {

    @Autowired
    PanierRepository par;
    @Autowired
    societeRepository sr;

    @Autowired
    ProductRepository productRepository;


    @Override
    public List<Panier> RetrieveAllPanier() {
        return par.findAll();
    }

    @Override
    public String DeletePanier(Integer id) {
        if(par.findById(id).isPresent()) {
            par.deleteById(id);
            return "DONE";
        }
        else{return "ERREUR";}
    }

    @Override
    public Panier RetrievePanierById(Integer id) {
        try {
            return par.findById(id).get();

        } catch (Exception e) {
            System.out.println("Error retrieving panier by ID " + id + e);
            throw new RuntimeException("Error retrieving panier by ID" + e);
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
        if (par.findById(id).isPresent()) {
            return par.save(panier);

        } else {
            System.out.println("erreur update");
            return null;
        }
    }

    @Transactional
    public Panier ajouterProduitAuPanier(int panierId, int produitId) {
        Panier panier = par.findById(panierId)
                .orElseGet(() -> {
                    Panier nouveauPanier = new Panier();
                    nouveauPanier.setProducts(new ArrayList<>());
                    return nouveauPanier;
                });
        Product produit = productRepository.findById((long) produitId).orElse(null);
        if (produit != null) {
            List<Product> listP = new ArrayList<>(panier.getProducts());
            listP.add(produit);
            panier.setProducts(listP);
            panier.setQte(panier.getProducts().size());
            int total = 0;
            for (Product product : panier.getProducts()) {
                total += (int) product.getPrice();
            }
            panier.setMontant(total);
            return par.save(panier);
        } else {
            return null;

        }
    }
}




