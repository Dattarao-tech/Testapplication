package com.bulk;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Demo {
	@Autowired
	private User user;
	
	@RequestMapping("/api")
	public  String get() {
		return "home";
		
	}
}
