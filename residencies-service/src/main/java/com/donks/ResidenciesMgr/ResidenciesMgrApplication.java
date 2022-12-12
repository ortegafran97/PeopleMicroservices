package com.donks.ResidenciesMgr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ResidenciesMgrApplication {

	public static void main(String[] args) {
		SpringApplication.run(ResidenciesMgrApplication.class, args);
	}

}
