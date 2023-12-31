package com.CRM.Backend.entities;

import lombok.Data;

import javax.persistence.*;

@Data
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

@OneToOne(mappedBy = "u",cascade = CascadeType.ALL)
    private Societe sc;



}
