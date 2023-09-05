package com.CRM.Backend.entities.Dto;

import lombok.Data;

@Data
public class UserRoleResponseDTO {
    private String role;

    public UserRoleResponseDTO() {
        // Default constructor
    }

    public UserRoleResponseDTO(String role) {
        this.role = role;
    }


}

