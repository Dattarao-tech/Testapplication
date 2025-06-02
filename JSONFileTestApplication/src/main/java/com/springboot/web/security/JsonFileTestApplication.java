package com.springboot.web.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.springboot.web.security")
public class JsonFileTestApplication {
	public static void main(String[] args) {
		SpringApplication.run(JsonFileTestApplication.class, args);
	}
}
