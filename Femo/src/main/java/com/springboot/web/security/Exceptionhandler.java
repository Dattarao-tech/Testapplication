package com.springboot.web.security;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class Exceptionhandler {
	public ResponseEntity <Object> mymassage(CustomeException c){
		return new ResponseEntity <>(c.getMessage() ,HttpStatus.INTERNAL_SERVER_ERROR );
		
	}
}
