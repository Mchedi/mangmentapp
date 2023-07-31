package com.CRM.Backend.entities;

import javax.persistence.*;

@Entity

public class société {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String Name;
    private long chiffre_affaire;
    private  int maricule_fiscale;
    private String adress;
@OneToOne(mappedBy = "sc")
User u;

}
