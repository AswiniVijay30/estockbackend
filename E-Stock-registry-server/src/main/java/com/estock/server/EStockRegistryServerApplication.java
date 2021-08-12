package com.estock.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EStockRegistryServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EStockRegistryServerApplication.class, args);
		
	}

}
