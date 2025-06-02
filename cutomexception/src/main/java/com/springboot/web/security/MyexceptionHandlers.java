package com.springboot.web.security;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MyexceptionHandlers {
	@ExceptionHandler(CustomeException.class)
	public ResponseEntity <Object> mymessage(CustomeException c){
		return new ResponseEntity<>(c.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
