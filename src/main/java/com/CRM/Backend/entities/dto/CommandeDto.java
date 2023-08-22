package com.CRM.Backend.entities.dto;

import com.CRM.Backend.entities.Etat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommandeDto {

    private Date date;
    private Etat etat;
    private int montant;
}
