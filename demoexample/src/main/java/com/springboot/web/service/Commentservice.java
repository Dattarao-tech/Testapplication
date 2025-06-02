package com.springboot.web.service;

import org.springframework.stereotype.Service;

@Service
public class Commentservice {
	private Postservice postservice;

	public Commentservice(Postservice postservice) {
		super();
		this.postservice = postservice;
	}
	
}
