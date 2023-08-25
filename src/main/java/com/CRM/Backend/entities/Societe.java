package com.CRM.Backend.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

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

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Product> Products;
    @OneToOne
    Sub subs;


}
