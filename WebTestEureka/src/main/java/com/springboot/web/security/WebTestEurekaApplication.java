package com.springboot.web.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class WebTestEurekaApplication {
	public static void main(String[] args) {
		SpringApplication.run(WebTestEurekaApplication.class, args);
	}
}
