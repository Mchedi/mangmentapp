package com.CRM.Backend.entities;

import javax.persistence.*;

@Entity
public class MyUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String Name;
    private String password;
    private String mail;
    private String image;

    @Enumerated(EnumType.STRING)
    private  RoleName role;

@OneToOne
    private societe sc;



}
