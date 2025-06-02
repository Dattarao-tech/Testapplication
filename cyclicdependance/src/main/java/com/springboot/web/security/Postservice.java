package com.springboot.web.security;

import org.springframework.stereotype.Service;

@Service
public class Postservice {
	private Commentservice commentservice;
	
	public Postservice(Commentservice commentservice) {
		super();
		this.commentservice = commentservice;	
	}
}
