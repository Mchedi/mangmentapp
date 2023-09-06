package com.CRM.Backend.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MyUser)) return false;
        MyUser user = (MyUser) o;
        return Objects.equals(getId(), user.getId()) && Objects.equals(getName(), user.getName()) && Objects.equals(getPassword(), user.getPassword()) && Objects.equals(getMail(), user.getMail()) && Objects.equals(getImage(), user.getImage()) && getRole() == user.getRole() && Objects.equals(getSocieteWork(), user.getSocieteWork());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getPassword(), getMail(), getImage(), getRole(), getSocieteWork());
    }

    public MyUser() {

    }
}
