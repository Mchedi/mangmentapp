package com.CRM.Backend.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity

public class test {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    String titre;



}
