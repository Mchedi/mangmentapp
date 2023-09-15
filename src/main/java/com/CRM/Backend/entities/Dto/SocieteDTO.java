package com.CRM.Backend.entities.Dto;

import com.CRM.Backend.entities.Role;
import lombok.Data;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.List;
import java.util.Date;


@Data
    public class SocieteDTO {
        private String Name;
        private long chiffre_affaire;
        private int maricule_fiscale;
        private String adress;
        private List<String> workerNames;
    private List<String> workermail;

    private List<Role> workerrole;
    @Temporal(TemporalType.DATE)

    private Date Expiration_date;


    public SocieteDTO(String name, long chiffre_affaire, int maricule_fiscale, String adress, List<String> workerNames, List<String> workermail, List<Role> workerrole , Date expiration_date) {
        Name = name;
        this.chiffre_affaire = chiffre_affaire;
        this.maricule_fiscale = maricule_fiscale;
        this.adress = adress;
        this.workerNames = workerNames;
        this.workermail = workermail;
        this.workerrole = workerrole;
        this.Expiration_date = expiration_date;

    }

    public SocieteDTO() {

    }
}
