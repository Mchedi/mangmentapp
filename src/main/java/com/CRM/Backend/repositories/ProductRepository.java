package com.CRM.Backend.repositories;

import com.CRM.Backend.entities.Product;
//import com.CRM.Backend.entities.abonnement;
import com.CRM.Backend.entities.Societe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product,Long> {


    List<Product> findBySociete(Optional<Societe> societeWorkId);

}
