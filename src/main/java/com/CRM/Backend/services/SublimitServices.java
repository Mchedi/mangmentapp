package com.CRM.Backend.services;

import com.CRM.Backend.entities.Sub;
import com.CRM.Backend.entities.Sublim;
import com.CRM.Backend.repositories.SubRepository;
import com.CRM.Backend.repositories.*;

import com.CRM.Backend.repositories.UserRepository;
import com.CRM.Backend.repositories.societeRepository;
import com.CRM.Backend.servicesInterfaces.SubInterface;
import com.CRM.Backend.servicesInterfaces.SublimInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SublimitServices implements SublimInterface {

    @Autowired
    UserRepository ur;
    @Autowired
    societeRepository sr;
    @Autowired
    SubRepository sur;
    @Autowired
    limitRepository limitRepository;

    @Override
    public List<Sublim> RetrieveALLSublim() {
        return null;
    }

    @Override
    public ResponseEntity<String> DeleteSublim(Long id) {
        return null;
    }

    @Override
    public Sublim RetrieveSublimById(Long id) {
        return null;
    }

    @Override
    public Sublim AddSublim(Sublim sublim) {
        return limitRepository.save(sublim);
    }

    @Override
    public Sublim UpdatSublim(Sublim sublim, Long id) {
        return null;
    }
}


