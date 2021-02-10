package com.app.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.app.pojos.Flight;

public interface IFlightService {
	
	List<Flight> searchAllFlights(String from , String to , LocalDate date);
	Optional<Flight> searchById(int id);
}
