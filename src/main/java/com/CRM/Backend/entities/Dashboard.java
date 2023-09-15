package com.CRM.Backend.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data

public class Dashboard {
    @Id
    private int id;
    private int CA;
    private  int nbsc;



}
