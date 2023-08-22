package com.CRM.Backend.services.serviceImpl;

import com.CRM.Backend.entities.Sublim;
import com.CRM.Backend.repositories.SubRepository;
import com.CRM.Backend.repositories.*;

import com.CRM.Backend.repositories.UserRepository;
import com.CRM.Backend.repositories.societeRepository;
import com.CRM.Backend.services.SublimInterface;
import org.springframework.beans.factory.annotation.Autowired;
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
        return limitRepository.findAll();
    }

    @Override
    public void DeleteSublim(Long id) {
        limitRepository.deleteById(id);
    }

    @Override
    public Sublim RetrieveSublimById(Long id) {
return limitRepository.findById(id).get();
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


