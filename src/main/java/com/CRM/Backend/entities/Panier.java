package com.CRM.Backend.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
    public class Panier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int Qte;
    private int montant;

<<<<<<< Updated upstream
    @OneToOne
    private Commande Commandes;
=======



>>>>>>> Stashed changes
}
