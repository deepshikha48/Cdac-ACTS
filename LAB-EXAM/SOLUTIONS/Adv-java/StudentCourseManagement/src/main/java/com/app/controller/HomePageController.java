package com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomePageController {
	
	//default constructor
	public HomePageController() {
		System.out.println("Constructor: "+getClass().getName());
	}
	
	//key: / 
	//value: com.app.controller.HomePageController +showHomePage() + get request
	@RequestMapping("/")
	public String showHomePage() {
		System.out.println("showHomePage: "+getClass().getName());
		return "/index"; //logical view name
		//actual view name : WEB-INF/views/index.jsp
	}

}