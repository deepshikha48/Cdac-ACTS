package com.app.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.FlightRepository;
import com.app.pojos.Flight;

@Service
@Transactional
public class FlightServiceImpl implements IFlightService {

	@Autowired
	private FlightRepository dao;
	
	@Override
	public List<Flight> searchAllFlights(String from, String to, LocalDate date) {		
		return dao.findByDepCityAndArrivalCityAndDepDate(from, to, date);
	}

	@Override
	public Optional<Flight> searchById(int id) {
		return dao.findById(id);
	}

}
