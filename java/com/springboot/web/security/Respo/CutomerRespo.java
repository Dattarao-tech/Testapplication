package com.springboot.web.security.Respo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.web.security.Model.Transaction;

public interface CutomerRespo extends JpaRepository<Transaction, String> {
	
}
