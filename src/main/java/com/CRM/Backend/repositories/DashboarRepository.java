package com.CRM.Backend.repositories;

import com.CRM.Backend.entities.Dashboard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
 public interface DashboarRepository extends JpaRepository<Dashboard, Integer>  {

}
