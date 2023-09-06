package com.CRM.Backend.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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
    private Role role    ;

    @ManyToOne
        //@JsonIgnore
        private Societe societeWork;
    public MyUser(String password, String mail) {
        this.password = password;
        this.mail = mail;
    }


    public MyUser() {

    }
}
