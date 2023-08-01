package com.CRM.Backend.repositories;

import com.CRM.Backend.entities.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface UserRepository extends JpaRepository<MyUser,Long> {
}
