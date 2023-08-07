package com.CRM.Backend.repositories;

import com.CRM.Backend.entities.Caise;
import com.CRM.Backend.entities.Commande;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CaiseRepository extends JpaRepository<Caise,Integer> {
}
