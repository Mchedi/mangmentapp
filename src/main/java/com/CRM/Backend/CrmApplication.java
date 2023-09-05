package com.CRM.Backend;

import com.CRM.Backend.services.serviceImpl.SubServices;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;


@EnableScheduling
@SpringBootApplication

@EnableWebSecurity

//@EntityScan(basePackages = {"com.CRM.Backend.entities"})
//@ComponentScan(basePackages = {"com.CRM.Backend.controllers","com.CRM.Backend.services"})
//@EnableJpaRepositories(basePackages = {"com.CRM.Backend.repositories"})
public class CrmApplication {



	public static void main(String[] args) {
		final SubServices subServices = new SubServices();



		//subServices.checkAndLogExgetSubpiredSubscriptionsForAllSocietes();

		SpringApplication.run(CrmApplication.class, args);

	}

}


