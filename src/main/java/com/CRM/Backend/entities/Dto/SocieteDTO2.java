package com.CRM.Backend.entities.Dto;

import lombok.Data;

@Data
public class SocieteDTO2 {
    private Long id;
    private String Name;
    private int chiffre_affaire;
    private int maricule_fiscale;
    private String adress;
    private String creatorName; // Include only the creator's name

    public SocieteDTO2(String name, int chiffre_affaire, int maricule_fiscale, String adress, String creatorName) {
        Name = name;
        this.chiffre_affaire = chiffre_affaire;
        this.maricule_fiscale = maricule_fiscale;
        this.adress = adress;
        this.creatorName = creatorName;
    }

    public SocieteDTO2() {

    }
}
