package com.CRM.Backend.entities;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Data
@Entity
    public class Caise {
    @Id
    private int id;
    private int responsable;
    private Type type;


    @OneToMany(cascade = CascadeType.ALL)
    private Set<Commande> Commandes;
    
}
