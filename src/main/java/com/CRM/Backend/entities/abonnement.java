package com.CRM.Backend.entities;

import javax.persistence.*;
import java.util.Date;

@Entity

public class abonnement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    @Temporal(TemporalType.DATE)

    private Date Start_Datte;
    @Temporal(TemporalType.DATE)

    private Date End_Date;
    private  int price;
    @ManyToOne
    private sublim limit;

    @OneToOne(mappedBy = "a")
    private Societe sc;

}
