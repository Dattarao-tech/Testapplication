package com.springboot.web.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Testdemo {
	
	@Value("${go}")
	private String values;
	
	@RequestMapping("/k")
	public String demo() {
		return values;	
	}
}
