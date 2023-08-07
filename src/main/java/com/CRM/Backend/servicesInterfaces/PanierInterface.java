package com.CRM.Backend.servicesInterfaces;


import com.CRM.Backend.entities.Panier;

import java.util.List;

public interface PanierInterface {

    public List<Panier> RetrieveAllPanier();
    public void DeletePanier(Integer id);
    public Panier RetrievePanierById(Integer id);
    public Panier AddPanier(Panier panier);
    public Panier UpdatePanier(Panier panier, Integer id);


}
