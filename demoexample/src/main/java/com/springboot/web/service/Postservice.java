package com.springboot.web.service;

import org.springframework.stereotype.Service;

@Service
public class Postservice {
	
	private Commentservice commentservice;
	public Postservice(Commentservice commentservice) {
		super();	
		this.commentservice = commentservice;
	}
}
