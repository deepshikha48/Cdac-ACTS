package com.app.handler;

import java.util.ArrayList;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.app.dto.ErrorResponse;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(EmptyResultDataAccessException.class)
	public ResponseEntity<?> handleEmptyResultDataAccessException(EmptyResultDataAccessException e,WebRequest req) {
		System.out.println("In handling data excep method");
		ErrorResponse err=new ErrorResponse(e.getMessage(), req.getDescription(false));
		return new ResponseEntity<>(err,HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		ArrayList<String> errMesgs=new ArrayList<String>();
		for( FieldError err : ex.getBindingResult().getFieldErrors())
			errMesgs.add(err.getDefaultMessage());
			
		ErrorResponse resp=new ErrorResponse("validation failure !!", errMesgs.toString());
		return new ResponseEntity<>(resp,HttpStatus.BAD_REQUEST);
		
	}
	


}
