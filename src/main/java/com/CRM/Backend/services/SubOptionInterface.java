package com.CRM.Backend.services;

import com.CRM.Backend.entities.Dto.SubDTO;
import com.CRM.Backend.entities.MyUser;
import com.CRM.Backend.entities.SubOption;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface SubOptionInterface {
    public List<SubOption> Retrievesubsoption();
    public ResponseEntity<String> DeleteSubOption(Long id);

    public SubOption RetrieveSubOptionById(Long id);

    SubOption AddSubOption(SubOption SubOption);

    //public SubOption UpdateSubOption(SubOption subOption, Long id);


    List<SubDTO> getAllSubDTOs();

    List<SubDTO> getAllPurchasedSubs();
}
