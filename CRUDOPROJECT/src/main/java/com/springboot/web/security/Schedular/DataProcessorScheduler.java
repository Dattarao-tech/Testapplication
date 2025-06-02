package com.springboot.web.security.Schedular;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot.web.security.Entity.Address;
import com.springboot.web.security.Entity.Employee;
import com.springboot.web.security.Repository.EmployeeRespo;
import com.springboot.web.security.Service.EmployeeService;
@Component
public class DataProcessorScheduler {
	
	@Autowired
    private EmployeeService employeeService;
	
	@Autowired
	private EmployeeRespo employeeRespo;
	
	  @Scheduled(fixedRate = 60000)
	  public void processFiles() {
		    String[] filePaths = {
		            "C:\\Users\\Microsoft\\Desktop\\titorial\\example.txt",
		            "C:\\Users\\Microsoft\\Desktop\\titorial\\example1.txt",
		            "C:\\Users\\Microsoft\\Desktop\\titorial\\example2.txt"
		    };

		    // Iterate over each file path
		    for (String currentFilePath : filePaths) {
		        // Process only the specified file (example2.txt)
		        if ("C:\\Users\\Microsoft\\Desktop\\titorial\\example.txt".equals(currentFilePath)) {
		        }
		        else if("C:\\Users\\Microsoft\\Desktop\\titorial\\example1.txt".equals(currentFilePath)) {
		        }
		        else if
		        	  ("C:\\Users\\Microsoft\\Desktop\\titorial\\example2.txt".equals(currentFilePath)) { 
		        }
		        else {
		        	System.out.println("invlide file path location---");
		        }
		          try {
		               // Read the content of the current file
		                Path path = Paths.get(currentFilePath);
		                List<String> fileLines = Files.readAllLines(path);

		                // Process each line in the file
		                for (String line : fileLines) {
		                    processFileEntry(currentFilePath, line);
		                }
		            } catch (Exception e) {
		                // Handle exceptions (e.g., file not found, parsing errors)
		                // Create a separate file for wrong entries
		                createErrorFile("C:\\Users\\Microsoft\\Desktop\\titorial\\errora.txt", e.getMessage());
		            }
		        }
		    }
		public void processFileEntry(String filePath, String entry) {
		    // Assuming the format is: "StatusCode,Data"
		    String[] parts = entry.split(",");
		    if (parts.length == 2) {
		        String statusCode = parts[0].trim();
		        String data = parts[1].trim();

		        Employee employee = convertJsonToEmployee(entry);
		        for (Address address : employee.getAddresses()) {
		            String statusCode1 = address.getStatusCode();

		            // Perform operations based on StatusCode
		            switch (statusCode1) {
		                case "A":
		                    if ("A".equals(statusCode)) {
		                        // Create an error file only for StatusCode1 = "A" in the current file
		                        createErrorFile(filePath.replace(".txt", "-error-a.txt"), "Invalid format: " + entry);
		                    }
		                    employeeService.createEmployee(employee);
		                    break;
		                case "B":
		                    if ("B".equals(statusCode)) {
		                        // Create an error file only for StatusCode1 = "B" in the current file
		                        createErrorFile(filePath.replace(".txt", "-error-b.txt"), "Invalid format: " + entry);
		                    }
		                    employeeService.deleteEmployee(employee.getId());
		                    break;
		                case "C":
		                    if ("C".equals(statusCode)) {
		                        // Create an error file only for StatusCode1 = "C" in the current file
		                        createErrorFile(filePath.replace(".txt", "-error-c.txt"), "Invalid format: " + entry);
		                    }
		                    employeeService.updateEmployee(employee, employee.getId());
		                    break;
		                // Add cases for other status codes as needed
		                default:
		                    System.out.println("Unknown status code: " + statusCode1);
		            }
		        }
		    } else {
		        System.out.println("Invalid entry format: " + entry);
		    }
		}
	 	    private Employee convertJsonToEmployee(String json) {
	        try {
	            ObjectMapper objectMapper = new ObjectMapper();
	            return objectMapper.readValue(json, Employee.class);
	        } catch (Exception e) {
	            // Handle exception, log error, or return a default Employee object
	            e.printStackTrace();
	            return new Employee();
	        }
	    }

	    private void createErrorFile(String filePath, String errorMessage) {
	        try {
	            // Create a Path object for the error file
	            java.nio.file.Path errorFilePath = Paths.get(filePath);

	            // Check if the error file already exists, create it if not
	            if (!Files.exists(errorFilePath)) {
	                Files.createFile(errorFilePath);
	            }

	            // Append the error message to the error file
	            Files.write(errorFilePath, errorMessage.getBytes(), StandardOpenOption.APPEND);

	        } catch (Exception e) {
	            // Handle IOException (e.g., file creation error)
	            e.printStackTrace();
	        }
	    }
	}