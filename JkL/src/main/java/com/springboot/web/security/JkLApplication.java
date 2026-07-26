package com.springboot.web.security;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.authentication.UserDetailsRepositoryReactiveAuthenticationManager;

@SpringBootApplication
public class JkLApplication {
	public static void main(String[] args) {
		SpringApplication.run(JkLApplication.class, args);	
	}

	

}
