package com.CRM.Backend.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class SubOption{
    @Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long  id;
    public String name;// Name of the sub-option (e.g., "Accountant", "Products", "Vendors")
    public int maximumNumberOfVendors ;// Maximum number of vendors for this sub-option
    public int maximumNumberOfProducts ; // Maximum number of products for this sub-option
    public  Boolean comtable;
        public  int price;
}