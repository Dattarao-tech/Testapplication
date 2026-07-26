package com.springboot.web.security;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class Test {
	@GetMapping
	public String get() {
		return "Hello";
	}
}
