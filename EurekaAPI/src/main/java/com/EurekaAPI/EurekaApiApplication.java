package com.EurekaAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EurekaApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaApiApplication.class, args);
	}

}
