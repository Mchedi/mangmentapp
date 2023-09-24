package com.CRM.Backend.repositories;

import com.CRM.Backend.entities.SubOption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
    public interface SubOptionRepository extends JpaRepository<SubOption,Long> {
}
