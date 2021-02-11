package com.app.dao;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Flight;

public interface FlightRepository extends JpaRepository<Flight, Integer>{
	
	List<Flight> findByDepCityAndArrivalCityAndDepDate(String from,String to ,LocalDate date);
	Optional<Flight> findById(int id);
	
}
