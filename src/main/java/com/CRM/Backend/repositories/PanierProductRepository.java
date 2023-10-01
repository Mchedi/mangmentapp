package com.CRM.Backend.repositories;

import com.CRM.Backend.entities.Panier;
import com.CRM.Backend.entities.PanierProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PanierProductRepository extends JpaRepository<PanierProduct,Long> {
}
