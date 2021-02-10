package com.app.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.pojos.Flight;
import com.app.pojos.Passenger;
import com.app.service.IFlightService;

@Controller
@RequestMapping("/passenger")
public class PassengerController {
	@Autowired
	private IFlightService flightService;
	public PassengerController() {
		System.out.println("Constr: "+getClass().getName());
		
	}
	
	@GetMapping("/details")
	public String showPassengerForm(@RequestParam int id , HttpSession hs,Passenger passenger) {
		System.out.println("showPassengerForm: id-"+id);
		Flight choosenFlight= flightService.searchById(id).get();
		hs.setAttribute("choosen_flight", choosenFlight);
		return "/passenger/details";
	}
	
	@PostMapping("details")
	public String processPassengerForm(@Valid Passenger passenger,HttpSession hs){
		System.out.println("processPassengerForm: passenger-"+passenger);
		hs.setAttribute("passenger", passenger);
		return "redirect:/user/card";
	}
}
