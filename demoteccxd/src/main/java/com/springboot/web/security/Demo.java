package com.springboot.web.security;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Demo {
	
	@RequestMapping("/api")
	public String home() {
		return "hello";	
	}
}
