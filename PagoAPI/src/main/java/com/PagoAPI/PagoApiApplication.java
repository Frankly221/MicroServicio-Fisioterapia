package com.PagoAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@EnableDiscoveryClient
@SpringBootApplication
public class PagoApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PagoApiApplication.class, args);
	}

}
