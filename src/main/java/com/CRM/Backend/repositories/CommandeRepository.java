package com.CRM.Backend.repositories;

import com.CRM.Backend.entities.Commande;
import com.CRM.Backend.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandeRepository extends JpaRepository<Commande,Integer> {
}
