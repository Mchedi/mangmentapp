package com.CRM.Backend.services;

import com.CRM.Backend.entities.Sublim;

import java.util.List;

public interface SublimInterface {

    public List<Sublim> RetrieveALLSublim();
    public void DeleteSublim(Long id);
    public Sublim RetrieveSublimById(Long id);
    public Sublim AddSublim(Sublim sublim);
    public Sublim UpdatSublim(Sublim sublim, Long id);



    }
