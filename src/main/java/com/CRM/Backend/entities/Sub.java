package com.CRM.Backend.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity

public class Sub {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    @Temporal(TemporalType.DATE)

    private Date Start_Datte;
    @Temporal(TemporalType.DATE)

    private Date End_Date;
    private  int price;
    @ManyToMany
    private List<Sublim> sublims ;

    @OneToOne(mappedBy = "subs")
    private Societe sc;

}
