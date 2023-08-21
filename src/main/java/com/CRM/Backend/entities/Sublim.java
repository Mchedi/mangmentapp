package com.CRM.Backend.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Sublim {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String type;
    private String sublim;
    @ManyToMany(mappedBy = "sublims")
    private List<Sub> subscriptions ;



}
