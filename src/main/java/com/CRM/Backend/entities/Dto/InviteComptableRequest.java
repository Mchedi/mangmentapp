package com.CRM.Backend.entities.Dto;

import com.CRM.Backend.entities.Role;
import lombok.Data;

@Data
public class InviteComptableRequest {
    private String workerEmail;
    private String name;
    private Role role;
}
