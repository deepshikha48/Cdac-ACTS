package com.app.exc_handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.app.dto.ErrorResponse;

@SuppressWarnings("serial")
@ControllerAdvice
public class GlobalExceptionHandler extends RuntimeException{
	
	@ExceptionHandler(Exception.class)
	public String handleAnyException(Exception exc, WebRequest request,Model modelMap,HttpServletRequest req) {
		System.out.println("Exception: "+getClass().getName());
		ErrorResponse errResp = new ErrorResponse(exc.getMessage(), request.getDescription(false));
		System.out.println("errResp: "+errResp);
		modelMap.addAttribute("error", errResp);
		modelMap.addAttribute("uri", req.getRequestURI());
		return "/error";
	}

}
