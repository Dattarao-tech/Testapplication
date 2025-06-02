package com.springboot.web.security.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.web.security.Entity.Employee;
import com.springboot.web.security.Service.EmployeeService;

@RestController
@RequestMapping("/api/emp")
public class EmployeeController {
	 
	@Autowired
	private EmployeeService employeeService;
	
	 @PostMapping("/sa")
	 public ResponseEntity<String> saveEmployees(@RequestBody List<Map<String, List<Map<String, List<Employee>>>>> colleges) {
	        try {
	            employeeService.saveEmployeesFromJson(colleges);
	            return ResponseEntity.ok("Employees saved successfully");
	        } catch (Exception e) {
	            e.printStackTrace();
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error saving employees");
	        }
	    }
	    @GetMapping("/employees")
	    public ResponseEntity<List<Employee>> getAllEmployees() {
	        List<Employee> employees = employeeService.getAllEmployees();
	        return new ResponseEntity<>(employees, HttpStatus.OK);
	    }
	    @DeleteMapping("/{id}")
	    public void deleteEmployee(@PathVariable Long id) {
	        employeeService.deleteEmployee(id);
	    }
	    @PutMapping("/employees/update")
	    public ResponseEntity<List<Employee>> updateEmployees(@RequestBody List<Employee> employees) {
	        List<Employee> updatedEmployees = new ArrayList<>();
	        for (Employee employee : employees) {
	        	
	            updatedEmployees.add(employeeService.updateEmployee(employee, employee.getId()));
	        }
	        return new ResponseEntity<>(updatedEmployees, HttpStatus.OK);
	    }
	    // Other methods...

//		 @PostMapping("/save")
//	    public ResponseEntity<String> saveColleges(@RequestBody List<Collage> colleges) {
//		 employeeService.saveColleges(colleges);
//	        return new ResponseEntity<>("Colleges saved successfully", HttpStatus.OK);
//	    }
	    @PostMapping
	   public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) { 	
	        employeeService.createEmployee(employee);
	        // You can return an appropriate response, such as ResponseEntity
			return new ResponseEntity<Employee>(employeeService.createEmployee(employee),HttpStatus.CREATED);
	  }
}
