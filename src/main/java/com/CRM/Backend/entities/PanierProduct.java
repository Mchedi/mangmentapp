package com.CRM.Backend.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class PanierProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPanierProduct;

    private Long idpanier;
    private Long idproduct;




}
