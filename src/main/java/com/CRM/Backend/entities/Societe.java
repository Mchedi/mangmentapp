package com.CRM.Backend.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity

public class Societe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String Name;
    private long chiffre_affaire;
    private  int maricule_fiscale  ;
    private String adress;
@OneToOne
MyUser u;

    @OneToOne
    Sub subs;


}
