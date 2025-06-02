package com.springboot.web.security;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Test {
	
	@RequestMapping("/api")
	public void massage() throws CutomeException{
		 throw new CutomeException();
	}
}
