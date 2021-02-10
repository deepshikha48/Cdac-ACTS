package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "passengers")
public class Passenger extends BaseEntity{
	
	@NotBlank(message = "Passenger name can't be blank")
	@Column(length = 20)
	private String name;
	@NotBlank(message = "Email can't be blank")
	@Email
	@Column(length = 30,unique = true)
	private String email;
	@NotBlank(message = "contact details can't be blank")
	@Pattern(regexp = "^[0-9]{10}$" , message = "enter 10 digits mobile number")
	@Column(length = 10)
	private String contact;
	@ManyToOne
	@JoinColumn(name = "flight_id" , nullable = false)
	private Flight bookedFight;
	
	public Passenger() {
		System.out.println("Constr: "+getClass().getName());
	}

	public Passenger(String name, String email, String contact,Flight bookedFight) {
		super();
		this.name = name;
		this.email = email;
		this.contact=contact;
		this.bookedFight = bookedFight;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public Flight getBookedFight() {
		return bookedFight;
	}

	public void setBookedFight(Flight bookedFight) {
		this.bookedFight = bookedFight;
	}

	@Override
	public String toString() {
		return "Passenger [passenger_id=" + getId() + "name=" + name + ", email=" + email + ", contact=" + contact + "]";
	}
	
	
}
