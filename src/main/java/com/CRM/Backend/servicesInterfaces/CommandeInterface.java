package com.CRM.Backend.servicesInterfaces;

import com.CRM.Backend.entities.Commande;


import java.util.List;

public interface CommandeInterface {

    public List<Commande> RetrieveAllCommandes();
    public void DeleteCommande(Integer id);
    public Commande RetrieveCommandeById(Integer id);
    public Commande AddCommande(Commande commande);
    public Commande UpdateCommande(Commande commande, Integer id);


}
