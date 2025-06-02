package com.springboot.web.security;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Demo {
	
	@RequestMapping("/hello")
	public String get() {
		return "home";
	}
}
