package com.CRM.Backend.services.serviceImpl;

import com.CRM.Backend.entities.Panier;
import com.CRM.Backend.entities.Product;
import com.CRM.Backend.entities.dto.PanierDto;
import com.CRM.Backend.repositories.PanierRepository;
import com.CRM.Backend.repositories.ProductRepository;
import com.CRM.Backend.repositories.societeRepository;
import com.CRM.Backend.services.PanierInterface;
import lombok.extern.log4j.Log4j;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;
import java.util.logging.Logger;

@Service

public class PanierServices implements PanierInterface {

    @Autowired
    PanierRepository par;
    @Autowired
    societeRepository sr;

    @Autowired
    ProductRepository productRepository;

    Logger logger = (Logger) LoggerFactory.getLogger(PanierServices.class);



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
    public Panier ajouterProduitAuPanier(int panierId, int produitId) throws Exception {
        try {
            Panier panierFromDb = par.findById(panierId).orElse(null);
            Product produitFromDb = productRepository.findById((long) produitId).orElse(null);

            if (Objects.nonNull(produitFromDb) && Objects.nonNull(panierFromDb)) {
                List<Product> listP = new ArrayList<>();

                if (panierFromDb.getProducts() != null && !panierFromDb.getProducts().isEmpty()) {
                    listP = panierFromDb.getProducts();
                }

                System.out.println(" size listp before add" +listP.size());
                listP.add(produitFromDb);
                panierFromDb.setProducts(listP);
                System.out.println(" size listp after add" +panierFromDb.getProducts().size());
                panierFromDb = par.save(panierFromDb);
                System.out.println(" size listp after save in db " +panierFromDb.getProducts().size());

                panierFromDb.setQte(panierFromDb.getProducts().size());

                int total = 0;
                for (Product product : panierFromDb.getProducts()) {
                    total += (int) product.getPrice();
                }
                panierFromDb.setMontant(total);
                return par.save(panierFromDb);

            } else {
                return null;
            }

        }catch (Exception e){
            throw new Exception(e);
        }
    }
}




