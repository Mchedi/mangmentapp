package com.CRM.Backend.entities.Dto;

import com.CRM.Backend.entities.Role;
import lombok.Data;

@Data
public class UserDTO {
    private String name;
    private String mail;
    private Role role;
    private String societeName;

    // Constructors, getters, and setters for the properties
}