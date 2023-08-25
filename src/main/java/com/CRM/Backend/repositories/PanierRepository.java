package com.CRM.Backend.repositories;

import com.CRM.Backend.entities.Caise;
import com.CRM.Backend.entities.Panier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PanierRepository extends JpaRepository<Panier,Integer> {
}
