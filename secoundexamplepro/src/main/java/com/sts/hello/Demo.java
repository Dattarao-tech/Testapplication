package com.sts.hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Demo {

	@RequestMapping("/d")
	public String getdemo() {
		System.out.println("hello demo");
		return "hello";
	}
}
