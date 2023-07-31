package com.CRM.Backend.entities;

import javax.persistence.*;
import java.util.Date;

@Entity

public class limit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String name;
    private String type;
    private String limit;




}
