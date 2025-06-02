package com.sts.hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	@RequestMapping("/helo")
	public String getHello()	{
		System.out.println("this is web page");
		return "hello";
	}
}
