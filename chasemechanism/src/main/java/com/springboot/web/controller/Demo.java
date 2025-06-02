package com.springboot.web.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Demo {
	@RequestMapping("/get")
	@Cacheable(value="customerInformation")
	public List customerInformation() {
		System.out.println("im am fromm contrinformation");
		List custDetail = Arrays.asList(new Customer(100,"banks of america" ,"usa"),
				new Customer(101 ,"Bank of india" ,"india"));
		return custDetail;
	}
}