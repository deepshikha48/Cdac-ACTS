package com.app.pojos;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "flights")
public class Flight extends BaseEntity{
	
	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	private Company airlines;	
	@Column(name = "dep_city", length = 20)
	private String depCity;	
	@Column(name = "arrival_city", length = 20)
	private String arrivalCity;
	@Future(message = "date must be in future")
	@Column(name = "dep_date")
	private LocalDate depDate;
	@Column(name = "dep_time")
	private LocalTime depTime;
	@OneToMany(mappedBy = "bookedFight" , cascade = CascadeType.ALL)
	private List<Passenger> passengers=new ArrayList<>();
	
	
	public Flight() {
		System.out.println("Constr: "+getClass().getName());
	}


	public Flight(Company airlines, String depCity, String arrivalCity, LocalDate depDate,
			LocalTime depTime) {
		super();
		this.airlines = airlines;
		this.depCity = depCity;
		this.arrivalCity = arrivalCity;
		this.depDate = depDate;
		this.depTime = depTime;
	}

	public Company getAirlines() {
		return airlines;
	}


	public void setAirlines(Company airlines) {
		this.airlines = airlines;
	}


	public String getDepCity() {
		return depCity;
	}


	public void setDepCity(String depCity) {
		this.depCity = depCity;
	}


	public String getArrivalCity() {
		return arrivalCity;
	}


	public void setArrivalCity(String arrivalCity) {
		this.arrivalCity = arrivalCity;
	}


	public LocalDate getDepDate() {
		return depDate;
	}


	public void setDepDate(LocalDate depDate) {
		this.depDate = depDate;
	}


	public LocalTime getDepTime() {
		return depTime;
	}


	public void setDepTime(LocalTime depTime) {
		this.depTime = depTime;
	}


	public List<Passenger> getPassengers() {
		return passengers;
	}


	public void setPassengers(List<Passenger> passengers) {
		this.passengers = passengers;
	}
	
	//helper method to link flight and passenger
	public void addPassenger(Passenger p) {
		passengers.add(p);
		p.setBookedFight(this);
	}
	
	//helper method to remove link b/w flight and passenger
	public void removePassenger(Passenger p) {
		passengers.remove(p);
		p.setBookedFight(null);
	}


	@Override
	public String toString() {
		return "Flight [flightId=" + getId() + ", airlines=" + airlines + ", depCity=" + depCity + ", arrivalCity="
				+ arrivalCity + ", depDate=" + depDate + ", depTime=" + depTime + "]";
	}
	
	
}
