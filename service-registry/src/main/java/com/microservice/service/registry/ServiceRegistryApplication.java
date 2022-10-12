package com.microservice.service.registry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ServiceRegistryApplication {

	private static Logger logger = LoggerFactory.getLogger(ServiceRegistryApplication.class);
	
	public static void main(String[] args) {
	
		logger.debug("--- Eureka Naming Service Discovery ---");
			
		SpringApplication.run(ServiceRegistryApplication.class, args);
	}

}
