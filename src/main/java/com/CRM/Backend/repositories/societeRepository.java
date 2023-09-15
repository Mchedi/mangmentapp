package com.CRM.Backend.repositories;

import com.CRM.Backend.entities.Societe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface societeRepository extends JpaRepository<Societe,Long> {

    Optional<Societe> findByCreatorId(Long id);


    Societe findSocieteByCreator_Id(Long id);
}