package com.CRM.Backend.repositories;

import com.CRM.Backend.entities.MyUser;
import com.CRM.Backend.entities.Role;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository

public interface UserRepository extends JpaRepository<MyUser,Long> {
    Optional<MyUser>  findByMail(String mail);
    Boolean existsByMail(String mail);

    Optional<MyUser> findByMailAndRole(String mail, Role role);
   // Optional<MyUser>  findMyUserByName(String name);



}
