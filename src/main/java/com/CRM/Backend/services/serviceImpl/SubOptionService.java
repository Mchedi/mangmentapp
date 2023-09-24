package com.CRM.Backend.services.serviceImpl;

import com.CRM.Backend.entities.Dto.SubDTO;
import com.CRM.Backend.entities.Societe;
import com.CRM.Backend.entities.SubOption;
import com.CRM.Backend.repositories.SubOptionRepository;
import com.CRM.Backend.repositories.societeRepository;
import com.CRM.Backend.services.SubOptionInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

public class SubOptionService implements SubOptionInterface {

    @Autowired
    private SubOptionRepository subr;
    @Autowired
    private societeRepository socr;
    @Override
    public List<SubOption> Retrievesubsoption() {
        return subr.findAll();
    }

    @Override
    public ResponseEntity<String> DeleteSubOption(Long id) {
        return null;
    }

    @Override
    public SubOption RetrieveSubOptionById(Long id) {
        return null;
    }

    @Override
    public SubOption AddSubOption(SubOption subOption) {
        return subr.save(subOption);
    }

    @Override
    public List<SubDTO> getAllSubDTOs() {
        return null;
    }

    @Override
    public List<SubDTO> getAllPurchasedSubs() {
        List<SubDTO> purchasedSubs = new ArrayList<>();

        List<Societe> societies = socr.findAll();

        for (Societe society : societies) {
            SubOption sub = society.getSubs();
            if (sub != null) {
                SubDTO subDTO = new SubDTO();
                subDTO.setId(sub.getId());
                subDTO.setPurchaseDate(society.getSub_purchase_date());
                subDTO.setExpirationDate(society.getSub_expiration_date());
                subDTO.setPrice(sub.getPrice());
                purchasedSubs.add(subDTO);
            }
        }

        return purchasedSubs;
    }
}
