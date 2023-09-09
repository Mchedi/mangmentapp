package com.CRM.Backend.services;

import com.CRM.Backend.entities.Dto.SocieteDTO;
import com.CRM.Backend.entities.Dto.SocieteDTO2;
import com.CRM.Backend.entities.Societe;

import java.util.List;

public interface SocieteInterface {

    public List<Societe> RetrieveAllSociete();


    public void DeletSociete(Long id);
    public Societe RetrieveSocieteById(Long id);
    public Societe AddSociete(Societe myUser);
    public Societe UpdateSociete(Societe myUser, Long id);
    Societe addAndAssignUserToSociete(Societe societe, Long userId);


    String assignSocieteToSub(Long societeId, Long subId);

    void inviteComptable(String directorEmail, String comptableEmail);

    SocieteDTO getSocieteDTOByCreator(Long id);

    void deleteComptable(String directorEmail, String comptableEmail);


    boolean verifsociete(String directorEmail);
}
