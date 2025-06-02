package com.springboot.web.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.netflix.discovery.EurekaClient;

@Component
public class Compoment {
	
	private final EurekaClient eurekaClient;
	
	  @Autowired
	    public Compoment(EurekaClient eurekaClient) {
	        this.eurekaClient = eurekaClient;
	    }
	
}
