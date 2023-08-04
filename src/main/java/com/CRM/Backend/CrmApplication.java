package com.CRM.Backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@CrossOrigin(origins = "*", maxAge = 3600)

@EntityScan(basePackages = {"com.CRM.Backend.entities"})
@ComponentScan(basePackages = {"com.CRM.Backend.controllers","com.CRM.Backend.services"})
@EnableJpaRepositories(basePackages = {"com.CRM.Backend.repositories"})
public class CrmApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrmApplication.class, args);
	}




}


