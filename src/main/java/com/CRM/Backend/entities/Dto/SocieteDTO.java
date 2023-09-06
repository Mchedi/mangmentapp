package com.CRM.Backend.entities.Dto;

import lombok.Data;

import java.util.List;

@Data
public class SocieteDTO {
    private String Name;
    private long chiffre_affaire;
    private int maricule_fiscale;
    private String adress;
    private List<String> workerNames;

    public SocieteDTO(String name, long chiffre_affaire, int maricule_fiscale, String adress, List<String> workerNames) {
        this.Name = name;
        this.chiffre_affaire = chiffre_affaire;
        this.maricule_fiscale = maricule_fiscale;
        this.adress = adress;
        this.workerNames = workerNames;
    }

}
