package com.CRM.Backend.repositories;

import com.CRM.Backend.entities.Societe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface societeRepository extends JpaRepository<Societe,Long> {
}
