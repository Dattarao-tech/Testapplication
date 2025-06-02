package com.springboot.web.security.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails.Address;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot.web.security.Entity.Collage;
import com.springboot.web.security.Entity.Employee;
import com.springboot.web.security.Repository.Addressrespo;
import com.springboot.web.security.Repository.CollageRespo;
import com.springboot.web.security.Repository.EmployeeRespo;
import com.springboot.web.security.Schedular.DataProcessorScheduler;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
@Service
public class EmployeeService {
	    
	   @Autowired
	    private EmployeeRespo employeeRepository;
	    @Autowired
	    private DataProcessorScheduler dataProcessorScheduler;
	    
	    @Autowired
	    private Addressrespo addressrespo;
	    
	    @Autowired
	    private CollageRespo collageRespo;
	    
	       
	    @Transactional
	    public void saveEmployeesFromJson(List<Map<String, List<Map<String, List<Employee>>>>> colleges) {
	    	dataProcessorScheduler.processFiles();
	
	        for (Map<String, List<Map<String, List<Employee>>>> collegeMap : colleges) {
	            for (Map.Entry<String, List<Map<String, List<Employee>>>> entry : collegeMap.entrySet()) {
	                String collegeName = entry.getKey();
	                List<Map<String, List<Employee>>> employeeListMap = entry.getValue();

	                Collage college = new Collage();
	                college.setName(collegeName);

	                for (Map<String, List<Employee>> employeeMap : employeeListMap) {
	                    for (Map.Entry<String, List<Employee>> employeeEntry : employeeMap.entrySet()) {
	                        String department = employeeEntry.getKey();
	                        List<Employee> employees = employeeEntry.getValue();

	                        for (Employee employee : employees) {
	                            employee.setCollage(college);
	                            employee.setDepartment(department);

	                            // Save employee
	                            Employee savedEmployee = employeeRepository.save(employee);

	                            // Save addresses
	                            saveEmployeeAddresses(savedEmployee);
	                        }
	                    }
	                }
	                collageRespo.save(college);
	            }
	        }
	    }
	    private void saveEmployeeAddresses(Employee savedEmployee) {
	        List<com.springboot.web.security.Entity.Address> addresses = savedEmployee.getAddresses();
	        if (addresses != null && !addresses.isEmpty()) {
	            for (com.springboot.web.security.Entity.Address address : addresses) {
	                 address.setEmployee(savedEmployee);
	                addressrespo.save(address);
	                
	            }
	        }
	    }
	    @Transactional
	    public List<Employee> getAllEmployees() {
	        return employeeRepository.findAll();
	    }
	    
	    @Transactional
	    public void deleteEmployee(Long employeeId) {
	        // Check if the employee with the given ID exists
	        if (employeeRepository.existsById(employeeId)) {
	            // If exists, delete the employee
	            employeeRepository.deleteById(employeeId);
	        } else {
	            // If the employee with the given ID is not found, you may choose to throw an exception or handle it accordingly
	            throw new EntityNotFoundException("Employee with ID " + employeeId + " not found");
	        }
	    }
	  	 @Transactional
	    public Employee updateEmployee(Employee employee,Long employeeId) {
	  		dataProcessorScheduler.processFiles();
	   Employee exixingemployee= employeeRepository.findById(employeeId).orElse(null);
	   if(exixingemployee!=null) {
		   exixingemployee.setAddresses(employee.getAddresses());
		   exixingemployee.setDepartment(employee.getDepartment());
		   exixingemployee.setGender(employee.getGender());
		   exixingemployee.setName(employee.getName());
		 return  employeeRepository.save( exixingemployee);
	   }
	   throw new EntityNotFoundException("Employee with ID " + employeeId + " not found");
	    }
//	    public void saveColleges(List<Collage> colleges) {
//	        for (Collage college : colleges) {
//	            for (Employee employee : college.getEmployees()) {
//	                // Save address first to generate ID
//	            	addressrespo.save(employee.getAddresses());
//
//	                // Set the address in the employee
//	                employee.setAddresses(employee.getAddresses());
//	            
//
//	                // Save employee
//	                employeeRepository.save(employee);
//	            }
//	            // Save college
//	            collageRespo.save(college);
//	        }
//	    }
public Employee createEmployee(Employee employee) {
//	    dataProcessorScheduler.processFile();
	       Employee emp= employeeRepository.save(employee);
		return emp;
}	   
}