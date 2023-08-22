package com.CRM.Backend.services;


import com.CRM.Backend.entities.Panier;
import com.CRM.Backend.entities.dto.PanierDto;

import java.util.List;

public interface PanierInterface {

    public List<Panier> RetrieveAllPanier();
    public void DeletePanier(Integer id);
    public Panier RetrievePanierById(Integer id);
    public Panier AddPanier(PanierDto panier);
    public Panier UpdatePanier(Panier panier, Integer id);


}
