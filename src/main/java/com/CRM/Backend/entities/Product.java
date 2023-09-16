package com.CRM.Backend.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

    @Data
    @Entity
        public class Product {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;
        private String name;
        private double price;
        private String category;

        private String picture;
        @JsonIgnore
        @ManyToOne(cascade = CascadeType.ALL)
        private Societe societe;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Commande> Commandes;
}



