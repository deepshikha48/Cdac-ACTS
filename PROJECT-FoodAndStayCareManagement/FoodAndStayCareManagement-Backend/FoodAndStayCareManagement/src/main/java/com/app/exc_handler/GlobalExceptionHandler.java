package com.app.exc_handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import com.app.cust_excs.ResourceNotFoundException;

@ControllerAdvice // stereotype annotation . Class level annotation .
//Supplies common advice to all controllers  n rest controllers.
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException e) {
		System.out.println("handling  res not found exc ");

		return new ResponseEntity<>(HttpStatus.NOT_FOUND);// 404
	}

	@ExceptionHandler(HttpClientErrorException.class)
	public ResponseEntity<?> handleForbiddenExc(HttpClientErrorException e) {
		System.out.println("handling constraint violation exc");

		return new ResponseEntity<>(e.getStatusCode());
	}

	// handle ANY other exception
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> handleAnyException(Exception e) {
		System.out.println("in handle exc");

		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);// 500
	}

}
