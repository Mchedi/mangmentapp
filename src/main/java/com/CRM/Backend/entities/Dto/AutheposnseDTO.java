    package com.CRM.Backend.entities.Dto;

    import lombok.Data;

    @Data
    public class AutheposnseDTO {
        private String accessToken;
        private String tokenType = "Bearer ";
        private Long userId;

        public AutheposnseDTO(String accessToken ,Long userId) {
            this.accessToken = accessToken;this.userId = userId;
        }
    }

