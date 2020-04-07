package com.dsr.humanres.ms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class HumanresMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(HumanresMsApplication.class, args);
	}

}
