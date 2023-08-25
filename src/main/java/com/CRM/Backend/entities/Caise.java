package com.CRM.Backend.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
    public class Caise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int responsable;
    private Type type;


    @OneToMany(cascade = CascadeType.ALL)
    private Set<Commande> Commandes;
    
}
