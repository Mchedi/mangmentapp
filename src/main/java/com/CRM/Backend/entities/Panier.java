package com.CRM.Backend.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.util.Date;

@Data
@Entity
    public class Panier {
    @Id
    private int id;
    private int Qte;
    private int montant;

    @OneToOne
    private Commande Commandes;
}
