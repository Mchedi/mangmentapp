package com.CRM.Backend.entities.Dto;

import lombok.Data;

@Data
public class AutheposnseDTO {
    private String accessToken;
    private String tokenType = "Bearer ";

    public AutheposnseDTO(String accessToken) {
        this.accessToken = accessToken;
    }
}

