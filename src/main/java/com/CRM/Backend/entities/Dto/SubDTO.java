package com.CRM.Backend.entities.Dto;

import lombok.Data;

import java.util.Date;

@Data
public class SubDTO {
    private Long id;
    private Date purchaseDate;
    private Date expirationDate;
    private int durationInMonths;
    private int price;

    // Constructors, getters, setters
}
