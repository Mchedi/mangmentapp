package com.CRM.Backend.repositories;

import com.CRM.Backend.entities.abonnement;
import com.CRM.Backend.entities.limit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface limitRepository extends JpaRepository<limit,Long> {
}
