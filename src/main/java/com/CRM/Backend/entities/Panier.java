package com.CRM.Backend.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Data
@Entity
    public class Panier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int Qte;
    private int montant;

    @ManyToMany(mappedBy="paniers", cascade = CascadeType.ALL)
    private List<Product> Products;


}
