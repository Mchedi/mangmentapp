package com.CRM.Backend.repositories;

import com.CRM.Backend.entities.Product;
import com.CRM.Backend.entities.abonnement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
