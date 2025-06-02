package com.springboot.web.security;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
public class Commentservice {
	private Postservice postservice;
	
	public Commentservice( @Lazy Postservice postservice) {
		super();
		this.postservice = postservice;
	}
}
