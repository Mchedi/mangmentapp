package com.CRM.Backend.entities;

//import jdk.net.SocketFlow;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Data
@Entity
    public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Date date;
    private Etat etat;
    private int montant;

    @ManyToMany(mappedBy="Commandes", cascade = CascadeType.ALL)
    private Set<Product> Products;
}
