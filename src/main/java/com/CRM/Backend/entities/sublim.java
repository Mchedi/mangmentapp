package com.CRM.Backend.entities;

import javax.persistence.*;

@Entity

public class sublim {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String type;
    private String sublim;




}
