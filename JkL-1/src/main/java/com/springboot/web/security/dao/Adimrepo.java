package com.springboot.web.security.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.web.security.entity.Contactadmin;

public interface Adimrepo extends JpaRepository<Contactadmin,Integer>{
	
}
