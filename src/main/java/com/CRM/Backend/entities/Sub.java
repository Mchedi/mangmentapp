package com.CRM.Backend.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
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
    @ManyToOne
    private Sublim limit;

    @OneToOne(mappedBy = "a")
    private Societe sc;

}
