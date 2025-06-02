package com.springboot.web.security.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.web.security.Entity.Address;

public interface Addressrespo extends JpaRepository<Address, Long>{
	
	void save(List<Address> addresses);
}
