package com.springboot.web.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class ChasemechanismApplication {
		
	public static void main(String[] args) {
		SpringApplication.run(ChasemechanismApplication.class, args);
	}
}
