package com.CRM.Backend.entities.dto;

import com.CRM.Backend.entities.Category;
import com.CRM.Backend.entities.Commande;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class        ProductDto {

    private String name;
    private double price;
    private Category category;
    private String picture;

}
