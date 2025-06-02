package com.sts;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Gretingcontroller {
	
	
	@Value("${my.greeting}")
	private String greetingMassage;
	
	@Value("${he}")
	private String demo;
	
	@GetMapping("/h")
	public String greeting() {	
		return greetingMassage;
	}
	@GetMapping("/j")
	public String get() {
		return demo;
	
	}
}