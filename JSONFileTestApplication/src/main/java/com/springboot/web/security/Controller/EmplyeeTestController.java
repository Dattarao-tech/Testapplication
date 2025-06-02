package com.springboot.web.security.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails.Address;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot.web.security.Entity.Employee;

import jakarta.servlet.http.HttpServletRequest;
import netscape.javascript.JSObject;

@RestController
@RequestMapping("/api/test")
public class EmplyeeTestController {
	
//	@PostMapping
//	public void processdata() {
//		
//		String json ="{\r\n"
//				+ "\r\n"
//				+ "\"employees\":[\r\n"
//				+ "\r\n"
//				+ "      {\r\n"
//				+ "\r\n"
//				+ "         \"name\":\"Datta\",\r\n"
//				+ "\r\n"
//				+ "         \"department\":\"Technology\",\r\n"
//				+ "\r\n"
//				+ "         \"gender\":\"male\",\r\n"
//				+ "\r\n"
//				+ "         \"addresses\":{\r\n"
//				+ "\r\n"
//				+ "            \"homeAddress\":[\r\n"
//				+ "\r\n"
//				+ "               \"abc\",\r\n"
//				+ "\r\n"
//				+ "               \"road\",\r\n"
//				+ "\r\n"
//				+ "               \"mumbai\",\r\n"
//				+ "\r\n"
//				+ "               \"400009\"\r\n"
//				+ "\r\n"
//				+ "            ],\r\n"
//				+ "\r\n"
//				+ "            \"salary\":\"20,000\"\r\n"
//				+ "\r\n"
//				+ "         }\r\n"
//				+ "\r\n"
//				+ "      },\r\n"
//				+ "\r\n"
//				+ "      {\r\n"
//				+ "\r\n"
//				+ "         \"name\":\"Dinesh\",\r\n"
//				+ "\r\n"
//				+ "         \"department\":\"HR\",\r\n"
//				+ "\r\n"
//				+ "         \"gender\":\"male\",\r\n"
//				+ "\r\n"
//				+ "         \"addresses\":{\r\n"
//				+ "\r\n"
//				+ "            \"homeAddress\":[\r\n"
//				+ "\r\n"
//				+ "              \"abc\",\r\n"
//				+ "\r\n"
//				+ "               \"road\",\r\n"
//				+ "\r\n"
//				+ "               \"mumbai\",\r\n"
//				+ "\r\n"
//				+ "               \"400009\"\r\n"
//				+ "\r\n"
//				+ "            ],\r\n"
//				+ "\r\n"
//				+ "            \"salary\":\"45,000\"\r\n"
//				+ "\r\n"
//				+ "         }\r\n"
//				+ "\r\n"
//				+ "      },\r\n"
//				+ "\r\n"
//				+ "      {\r\n"
//				+ "\r\n"
//				+ "         \"name\":\"sandesh\",\r\n"
//				+ "\r\n"
//				+ "         \"department\":\"Technology\",\r\n"
//				+ "\r\n"
//				+ "         \"gender\":\"male\",\r\n"
//				+ "\r\n"
//				+ "         \"addresses\":{\r\n"
//				+ "\r\n"
//				+ "            \"homeAddress\":[\r\n"
//				+ "\r\n"
//				+ "               \"abc\",\r\n"
//				+ "\r\n"
//				+ "               \"road\",\r\n"
//				+ "\r\n"
//				+ "               \"mumbai\",\r\n"
//				+ "\r\n"
//				+ "               \"400009\"\r\n"
//				+ "\r\n"
//				+ "            ],\r\n"
//				+ "\r\n"
//				+ "            \"salary\":\"55,000\"\r\n"
//				+ "\r\n"
//				+ "         }\r\n"
//				+ "\r\n"
//				+ "      },\r\n"
//				+ "\r\n"
//				+ "                  {\r\n"
//				+ "\r\n"
//				+ "         \"name\":\"Kalpana\",\r\n"
//				+ "\r\n"
//				+ "         \"department\":\"Technology\",\r\n"
//				+ "\r\n"
//				+ "         \"gender\":\"female\",\r\n"
//				+ "\r\n"
//				+ "         \"addresses\":{\r\n"
//				+ "\r\n"
//				+ "            \"homeAddress\":[\r\n"
//				+ "\r\n"
//				+ "               \"abc\",\r\n"
//				+ "\r\n"
//				+ "               \"road\",\r\n"
//				+ "\r\n"
//				+ "               \"mumbai\",\r\n"
//				+ "\r\n"
//				+ "               \"400009\"\r\n"
//				+ "\r\n"
//				+ "            ],\r\n"
//				+ "\r\n"
//				+ "            \"salary\":\"25,000\"\r\n"
//				+ "\r\n"
//				+ "         }\r\n"
//				+ "\r\n"
//				+ "      },\r\n"
//				+ "\r\n"
//				+ "      {\r\n"
//				+ "\r\n"
//				+ "         \"name\":\"Drona\",\r\n"
//				+ "\r\n"
//				+ "         \"department\":\"HR\",\r\n"
//				+ "\r\n"
//				+ "         \"gender\":\"male\",\r\n"
//				+ "\r\n"
//				+ "         \"addresses\":{\r\n"
//				+ "\r\n"
//				+ "            \"homeAddress\":[\r\n"
//				+ "\r\n"
//				+ "              \"abc\",\r\n"
//				+ "\r\n"
//				+ "               \"road\",\r\n"
//				+ "\r\n"
//				+ "               \"mumbai\",\r\n"
//				+ "\r\n"
//				+ "               \"400009\"\r\n"
//				+ "\r\n"
//				+ "            ],\r\n"
//				+ "\r\n"
//				+ "            \"salary\":\"75,000\"\r\n"
//				+ "\r\n"
//				+ "         }\r\n"
//				+ "\r\n"
//				+ "      },\r\n"
//				+ "\r\n"
//				+ "      {\r\n"
//				+ "\r\n"
//				+ "         \"name\":\"Reena\",\r\n"
//				+ "\r\n"
//				+ "         \"department\":\"Marketing\",\r\n"
//				+ "\r\n"
//				+ "         \"gender\":\"female\",\r\n"
//				+ "\r\n"
//				+ "         \"addresses\":{\r\n"
//				+ "\r\n"
//				+ "            \"homeAddress\":[\r\n"
//				+ "\r\n"
//				+ "               \"abc\",\r\n"
//				+ "\r\n"
//				+ "               \"road\",\r\n"
//				+ "\r\n"
//				+ "               \"mumbai\",\r\n"
//				+ "\r\n"
//				+ "               \"400009\"\r\n"
//				+ "\r\n"
//				+ "            ],\r\n"
//				+ "\r\n"
//				+ "            \"salary\":\"60,000\"\r\n"
//				+ "\r\n"
//				+ "         }\r\n"
//				+ "\r\n"
//				+ "      }\r\n"
//				+ "\r\n"
//				+ "                  ]\r\n"
//				+ "\r\n"
//				+ "                  }";
       
//        int thresholdSalary = 90000;
//
//        // Parse JSON and find departments with total salary greater than 90,000
//        Set<String> departments = new HashSet<>();
//        Map<String, Integer> departmentTotalSalary = new HashMap<>();
//
//        Gson gson = new Gson();
//        JsonObject jsonObject = gson.fromJson(json, JsonObject.class);
//
//        if (jsonObject.has("employees")) {
//            JsonArray employeesArray = jsonObject.getAsJsonArray("employees");
//
//            for (JsonElement employeeElement : employeesArray) {
//                Employee employee = gson.fromJson(employeeElement, Employee.class);
//                String department = employee.getDepartment();
//                int salary = Integer.parseInt(employee.getAddresses().getSalary().replace(",", ""));
//
//                // Update the total salary for the department
//                departmentTotalSalary.put(department, departmentTotalSalary.getOrDefault(department, 0) + salary);
//
//                // Check if the total salary for the department exceeds the threshold
//                if (departmentTotalSalary.get(department) > thresholdSalary) {
//                    departments.add(department);
//                }
//            }
//        }
//
//        // Print the result
//        System.out.println("Departments with total salary greater than 90,000: " + departments);
//    }	

//		 int thresholdSalary = 90000;
//
//	        Gson gson = new Gson();
//	        JsonObject jsonObject = gson.fromJson(json, JsonObject.class);
//
//	        Set<String> departments = jsonObject.getAsJsonArray("employees")
//	                .stream()
//	                .map(gson::fromJson)
//	                .filter(employee -> Integer.parseInt(employee.getAddresses().getSalary().replace(",", "")) > thresholdSalary)
//	                .collect(Collectors.toMap(Employee::getDepartment, employee -> 1, Integer::sum))
//	                .entrySet()
//	                .stream()
//	                .filter(entry -> entry.getValue() > thresholdSalary)
//	                .map(Map.Entry::getKey)
//	                .collect(Collectors.toSet());
	
//  
//	  @PostMapping("/analyze-salary")
//	    public Set<String> analyzeSalary(@RequestBody String jsonData) {
//		  String [] onj=jsonData.split(",");
//		  for(String  ch1 :onj) {
//			  System.out.println(ch1);
//		  }		  
//		  int thresholdSalary = 90000;
//	        Gson gson = new Gson();
//	        JSObject jsonObject = gson.fromJson(jsonData, JsonObject.class);
//
//	        JsonArray employeesArray = jsonObject.getAsJsonArray("employees");
//	        Set<String> departments = new HashSet<>();
//	        
//	        for (JsonElement employeeElement : employeesArray) {
//	            Employee employee = gson.fromJson(employeeElement, Employee.class);
//	            int salary = Integer.parseInt(employee.getAddresses().getSallary().replace(",", ""));
//	            
//	            if (salary > thresholdSalary) {
//	                departments.add(employee.getDepartment());
//	            }
//	        }
//	        return departments;     
//	  }
	@PostMapping("/highSpendingDepartments")
    public List<String> findHighSpendingDepartments(@RequestBody List<Employee> employees) {
        Map<String, Integer> departmentExpenses = new HashMap<>();
        // Calculate total expenses per department
        for (Employee employee : employees) {
            String department = employee.getDepartment();
            int salary = Integer.parseInt(employee.getAddresses().getSallary().replace(",", ""));

            departmentExpenses.put(department, departmentExpenses.getOrDefault(department, 0) + salary);
        }
        // Find departments with expenses > 90k
        return departmentExpenses.entrySet().stream()
                .filter(entry -> entry.getValue() > 90000)
                .map(Map.Entry::getKey)
                .toList();
        
	    }
}
