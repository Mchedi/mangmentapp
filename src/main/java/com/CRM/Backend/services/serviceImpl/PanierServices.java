package com.CRM.Backend.services.serviceImpl;

import com.CRM.Backend.entities.Caise;
import com.CRM.Backend.entities.Commande;
import com.CRM.Backend.entities.Panier;
<<<<<<< Updated upstream
=======
import com.CRM.Backend.entities.PanierProduct;
import com.CRM.Backend.entities.Product;
>>>>>>> Stashed changes
import com.CRM.Backend.entities.dto.PanierDto;
import com.CRM.Backend.repositories.PanierProductRepository;
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


    @Autowired
    PanierProductRepository PanierProductRepository;


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
<<<<<<< Updated upstream
        if (par.findById(id).isPresent())
        {return par.save(panier);}
        else {System.out.println("erreur update");return  null ;}
=======
        if (par.findById(id).isPresent()) {
            return par.save(panier);

        } else {
            System.out.println("erreur update");
            return null;
        }
    }

    @Transactional
    public Panier ajouterProduitAuPanier(int panierId, int produitId) {
        Product produit = productRepository.findById((long) produitId).orElse(null);
        if (produit != null) {
            Panier panier = par.findById(panierId)
                    .orElseGet(() -> {
                        Panier nouveauPanier = new Panier();
                        return nouveauPanier;
                    });
            par.save(panier);
            System.out.println(panier);
            PanierProduct panierProduct = new PanierProduct();
            panierProduct.setIdpanier((long) panier.getId());
            panierProduct.setIdproduct((long) produitId);
            PanierProductRepository.save(panierProduct);

            List<PanierProduct> listAllPanierProduct= PanierProductRepository.findAll();
            List<Product> listProduct= new ArrayList<>();
            for (PanierProduct panierProductfor : listAllPanierProduct) {
                    if (panierProductfor.getIdpanier() == panier.getId() ) {
                        listProduct.add(productRepository.findById(panierProductfor.getIdproduct()).get());
                    }
            }

                panier.setMontant((int) (panier.getMontant() + productRepository.findById((long) produitId).get().getPrice()));

            panier.setQte(listProduct.size());


            return par.save(panier);
        } else {
            return null;

        }
>>>>>>> Stashed changes
    }

    public List<Product> ListeProduits(int panierId) {
        List<PanierProduct> listAllPanierProduct= PanierProductRepository.findAll();
        List<Product> listProduct= new ArrayList<>();
        for (PanierProduct panierProductfor : listAllPanierProduct) {
            if (panierProductfor.getIdpanier() == panierId ) {
                listProduct.add(productRepository.findById(panierProductfor.getIdproduct()).get());
            }
        }
        return listProduct;
    }
}



