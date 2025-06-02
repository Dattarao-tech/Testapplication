package com.springboot.web.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class DemotestApplication {	
	public static void main(String[] args) {
		SpringApplication.run(DemotestApplication.class, args);
		
	}
}
