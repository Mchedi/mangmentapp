package com.CRM.Backend.entities;

import jdk.net.SocketFlow;
import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Date;
import java.util.Set;

@Data
@Entity
    public class Commande {
    @Id
    private int id;
    private Date date;
    private Etat etat;
    private int montant;

    @ManyToMany(mappedBy="Commandes", cascade = CascadeType.ALL)
    private Set<Product> Products;
}
