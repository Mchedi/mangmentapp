package com.CRM.Backend.repositories;

import com.CRM.Backend.entities.Societe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface societeRepository extends JpaRepository<Societe,Long> {

    Optional<Societe> findByCreatorId(Long id);


    Societe findSocieteByCreator_Id(Long id);
}