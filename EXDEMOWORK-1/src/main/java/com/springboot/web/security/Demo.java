package com.springboot.web.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class Demo {
	@Value("${example}")
	private String demo;
	
	@RequestMapping("/api")
	public String get() {
		return demo;
		
	}
}
