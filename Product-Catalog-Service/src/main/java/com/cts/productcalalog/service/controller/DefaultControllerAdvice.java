package com.cts.productcalalog.service.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class DefaultControllerAdvice extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ExceptionMessage> responseForBadRequest( Exception e){
		
		ExceptionMessage exceptionMessage= new ExceptionMessage();
		exceptionMessage.setAction(" Please give correct request !");
		exceptionMessage.setExceptionMessage(e.getMessage());	
		return new ResponseEntity<ExceptionMessage>(exceptionMessage,new HttpHeaders(),HttpStatus.BAD_REQUEST);
	}

}
