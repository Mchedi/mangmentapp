package com.CRM.Backend.entities;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Collection;
import java.util.Iterator;

public enum Role {
                    user ,admin,directure,comptable,vendeur
}
