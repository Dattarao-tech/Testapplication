package com.springboot.web.security.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.web.security.Entity.Collage;

public interface CollageRespo extends JpaRepository<Collage, Long>{
	
}
