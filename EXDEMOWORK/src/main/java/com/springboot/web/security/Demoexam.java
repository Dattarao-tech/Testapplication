package com.springboot.web.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class Demoexam {
	
	@Autowired
	private User user;
	
//	@Autowired
//	private User user;
	@RequestMapping("/api")
	public String get() {
		return user.getFirst_name()+" "+user.getLast_name();
		
	}
}
