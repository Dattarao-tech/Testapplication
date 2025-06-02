package com.springboot.web.security.Controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot.web.securityModel.Addresses;
import com.springboot.web.securityModel.Employee;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class Employee2 {
	
	  @PostMapping("/getEmployee")
	    public String getEmployee(@RequestBody Employee employee) throws JsonProcessingException {
	        try {
	            // Accessing data directly from the 'employee' object
	            String name = employee.getName();
	            String department = employee.getDepartment();
	            String gender = employee.getGender();

	            // Accessing 'Addresses' data
	            Addresses addresses = employee.getAddresses();

	            if (addresses == null) {
	                return "Received employee data without addresses information";
	            }

	            // Accessing 'Addresses' properties
	            List<String> homeAddress = addresses.getHomeaddres();  // Adjusted attribute name
	            String salary = addresses.getSallary();  // Adjusted attribute name

	            // Check if homeAddress is null
	            if (homeAddress == null) {
	                return "Received employee data with null homeAddress";
	            }

	            // Your logic to process the data as needed...
	            // For example, calculating the total salary per department

	            Map<String, Integer> departmentSalaryMapping = new HashMap<>();

	            // Calculate total salary for the department
	            int totalSalary = Integer.parseInt(salary);

	            // Update the existing salary for the department or add a new entry
	            departmentSalaryMapping.put(department, departmentSalaryMapping.getOrDefault(department, 0) + totalSalary);

	            System.out.println("departmentSalaryMapping  " + departmentSalaryMapping);

	            StringBuilder result = new StringBuilder("Departments with total salary above 90,000: ");

	            for (Map.Entry<String, Integer> entry : departmentSalaryMapping.entrySet()) {
	                if (entry.getValue() > 90000) {
	                    System.out.println(entry.getKey());
	                    System.out.println(entry.getValue());
	                    result.append(entry.getKey()).append(", ");
	                }
	            }

	            String finalResult = result.length() > "Departments with total salary above 90,000: ".length() ?
	                    result.substring(0, result.length() - 2) : "No departments found";
	            System.out.println(finalResult);
	            return finalResult;

	        } catch (Exception e) {
	            e.printStackTrace();
	            return "Error processing request";
	        }
	    }
	
}
		
