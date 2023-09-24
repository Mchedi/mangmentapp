package com.CRM.Backend.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Data
@Entity
    public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private double price;

    @Enumerated(EnumType.STRING)
    private Category category;

    private String picture;



    @ManyToMany(cascade = CascadeType.ALL)
    private List<Panier> paniers ;
}



