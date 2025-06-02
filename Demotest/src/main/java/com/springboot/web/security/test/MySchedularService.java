package com.springboot.web.security.test;

import java.util.Date;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class MySchedularService {
    
//	@Scheduled(fixedRate = 5000) 
	 public void myScheduledMethod() {
	        System.out.println("Scheduled task executed at: " + new Date());
}}
