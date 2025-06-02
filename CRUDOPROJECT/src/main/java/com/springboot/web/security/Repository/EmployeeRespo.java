package com.springboot.web.security.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.web.security.Entity.Employee;
public interface EmployeeRespo extends JpaRepository<Employee, Long>{
	
}
