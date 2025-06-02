package com.springboot.web.security;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Testcontroller {
	
	@RequestMapping("/api")
	public void message() throws CustomeException{
		throw new CustomeException();
	}
}
