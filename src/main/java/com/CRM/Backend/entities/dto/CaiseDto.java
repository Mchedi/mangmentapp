package com.CRM.Backend.entities.dto;

import com.CRM.Backend.entities.Caise;
import com.CRM.Backend.entities.Product;
import com.CRM.Backend.entities.Type;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Data
@AllArgsConstructor
@NoArgsConstructor

public class CaiseDto {
    private int responsable;
    private Type type;
}
