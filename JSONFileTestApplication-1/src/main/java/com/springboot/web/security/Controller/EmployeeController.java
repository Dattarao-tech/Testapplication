package com.springboot.web.security.Controller;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot.web.securityModel.Employee;

@RestController
@RequestMapping("/api/test")
public class EmployeeController {
	
    @PostMapping("/departments_above_90k")
    public String departmentsAbove90k(@RequestBody Map<String, Object> requestData) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonDataNode = objectMapper.convertValue(requestData.get("employees"), JsonNode.class);
            Map<String, Integer> departmentSalaryMapping = new HashMap<>();

            for (JsonNode employeeNode : jsonDataNode) {
                String department = employeeNode.path("department").asText();
                String salaryString = employeeNode.path("addresses").path("salary").asText().replace(",", "");
                		
//                System.out.println("department : "+ department + "salaryString :"+ salaryString);
                if (!department.isEmpty() && salaryString.matches("\\d+")) {
                    int salary = Integer.parseInt(salaryString);    
                    if(departmentSalaryMapping.containsKey(department)) {                   	
                    	int newSal = departmentSalaryMapping.get(department)+salary;
//                   	departmentSalaryMapping.put(department, departmentSalaryMapping.getOrDefault(department, null) + salary);
                    
                    	departmentSalaryMapping.put(department, newSal);
                    }else
                    {
                    	departmentSalaryMapping.put(department, salary);       
                    }   
                }   
            }          
            System.out.println("departmentSalaryMapping  "+departmentSalaryMapping);
            StringBuilder result = new StringBuilder("Departments with total salary above 90,000: ");
          
                                            
            for (Map.Entry<String, Integer> entry : departmentSalaryMapping.entrySet()) {
                if (entry.getValue() > 90000) {
                	System.out.println(entry.getKey());       
                	System.out.println(entry.getValue());
                    result.append(entry.getKey()).append(", ");      
                }
            }
           
            String finalresult=result.length() > "Departments with total salary above 90,000: ".length() ?
                    result.substring(0, result.length() - 2) : "No departments found";
            System.out.println(finalresult);
            return finalresult;
            
        } catch (Exception e) {
            e.printStackTrace();
            return "Error processing request";
        }
	}
}



