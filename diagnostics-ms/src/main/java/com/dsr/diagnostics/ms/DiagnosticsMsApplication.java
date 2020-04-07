package com.dsr.diagnostics.ms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class DiagnosticsMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiagnosticsMsApplication.class, args);
	}

}
