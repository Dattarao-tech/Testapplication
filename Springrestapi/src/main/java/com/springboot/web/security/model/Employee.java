package com.springboot.web.security.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Employee {
	
	private String name;
	private long age;
	private String location;
	private String email;
	private String deparment;
}
