package com.CRM.Backend.services;

import com.CRM.Backend.entities.Commande;
import com.CRM.Backend.entities.dto.CommandeDto;


import java.util.List;

public interface CommandeInterface {

    public List<Commande> RetrieveAllCommandes();
    public void DeleteCommande(Integer id);
    public Commande RetrieveCommandeById(Integer id);
    public Commande AddCommande(CommandeDto commande);
    public Commande UpdateCommande(Commande commande, Integer id);


}
