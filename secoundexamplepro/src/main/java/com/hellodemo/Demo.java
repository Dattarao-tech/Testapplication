package com.hellodemo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Demo {

	@RequestMapping("/j")
	public String test() {
		System.out.println("hello");
		return "hellodemo";		
	}
}
