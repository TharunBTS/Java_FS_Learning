package com.test.exceptions;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	
	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<ErrorMessage> productNotFoundException(ProductNotFoundException pnfe,WebRequest request)
	{
		ErrorMessage em = new ErrorMessage();
		int statusCode = HttpStatus.BAD_REQUEST.value();
		String desc = request.getDescription(false);
		em.setTimeStamp(new Date());
		em.setMsg(pnfe.getMessage());
		em.setStatusCode(statusCode);
		return new ResponseEntity<>(em,HttpStatus.BAD_REQUEST);
	}
	
	// global class exceptions
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorMessage> unknownException(Exception e,WebRequest request)
	{
		ErrorMessage em = new ErrorMessage();
		int statusCode = HttpStatus.BAD_REQUEST.value();
		String desc = request.getDescription(false);
		em.setTimeStamp(new Date());
		em.setMsg(e.getMessage());
		em.setStatusCode(statusCode);
		return new ResponseEntity<>(em,HttpStatus.BAD_REQUEST);
	}
	
	
}
