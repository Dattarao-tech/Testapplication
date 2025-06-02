package com.springboot.web.security.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class Employeecontroller {

	@GetMapping("/emp")
	public String getEmployee() {	
		return "displying the list emplyee";
	}
	@GetMapping("/emp/{id}")
	public String getEmployee1(@PathVariable("id") long id) {		
		return "Fetching the employee for the "+id;	
	}
	@DeleteMapping("/emp")
	public String deleteEmployee(@RequestParam("id") long id) {
		return "Deleting the employee for the "+id;
	
	}
}