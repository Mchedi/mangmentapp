package com.CRM.Backend.entities.Dto;

import com.CRM.Backend.entities.Role;
import lombok.Data;

    @Data
    public class UserDTO2 {
        private String name;
        private String mail;
        private Role role;

        public UserDTO2(String name, String mail, Role role) {
        }
    }
