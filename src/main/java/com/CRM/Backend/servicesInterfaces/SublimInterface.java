package com.CRM.Backend.servicesInterfaces;

import com.CRM.Backend.entities.MyUser;
import com.CRM.Backend.entities.Societe;
import com.CRM.Backend.entities.Sublim;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface SublimInterface {

    public List<Sublim> RetrieveALLSublim();
    public ResponseEntity<String> DeleteSublim(Long id);
    public Sublim RetrieveSublimById(Long id);
    public Sublim AddSublim(Sublim sublim);
    public Sublim UpdatSublim(Sublim sublim, Long id);



    }
