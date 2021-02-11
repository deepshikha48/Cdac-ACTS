package com.app.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.pojos.Flight;
import com.app.pojos.Passenger;
import com.app.service.IFlightService;

@Controller
@RequestMapping("/flight")
@Validated
public class FlightController {

	@Autowired
	private IFlightService service;
	
	public FlightController() {
		System.out.println("Constr: " + getClass().getName());
	}

	@GetMapping("/search")
	public String showSearchPage() {
		System.out.println("showSearchPage: " + getClass().getName());
		return "/flight/search";
	}

	@PostMapping("/search")
	public String showSearchFlightForm(@RequestParam @NotBlank(message = "destination can't be blank") String from, @NotBlank(message = "departure city can't be blank") @RequestParam String to,
			@RequestParam @NotNull(message = "date can't be blank") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date , RedirectAttributes flashMap,Model modelMap) {
		System.out.println("showSearchFlightForm: from-" + from + " to-" + to + " date-" + date);
		List<Flight> flights= service.searchAllFlights(from, to, date);
		if(flights.isEmpty()) {
			modelMap.addAttribute("msg", "No Flights available !");
			return "/flight/search";
		}
		System.out.println(flights);
		flashMap.addFlashAttribute("flights", flights);
		return "redirect:/flight/display";

	}
	
	@GetMapping("/display")
	public String showFlights() {
		return "/flight/display";
	}

}
