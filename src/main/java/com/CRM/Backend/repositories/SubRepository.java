package com.CRM.Backend.repositories;

import com.CRM.Backend.entities.Sub;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface    SubRepository extends JpaRepository<Sub,Long> {
}
