package com.CRM.Backend.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Calendar;

@Data
@Entity

public class Sub {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    @Temporal(TemporalType.DATE)
    private Date purchase_date ;
     @Temporal(TemporalType.DATE)
             private Date expiration_sub_date ;
    private int durationinmonths;
    private  int price;
    @OneToOne(mappedBy = "subs")
    private Societe sc;
    @ManyToMany
    private List<Sublim> sublims ;



}
