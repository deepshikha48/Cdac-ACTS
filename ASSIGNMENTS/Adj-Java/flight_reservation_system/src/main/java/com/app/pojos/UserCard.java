package com.app.pojos;

import java.time.LocalDate;

import javax.validation.constraints.*;

import org.springframework.format.annotation.DateTimeFormat;

public class UserCard{

	@NotBlank(message="card number can't be blank")
	@Pattern(regexp = "^[0-9]{16}$",message = "16-digits number allowed")
	private String cardNumber;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Future(message="Your Card has been expired already")
	private LocalDate expDate;
	@Digits(fraction = 0,integer = 3,message = "cvv can't be greater than 3 digits")
	private int cvv;
	
	public UserCard() {
		System.out.println("Constr: "+getClass().getName());
	}

	public UserCard(String cardNumber, LocalDate expDate, int cvv) {
		super();
		this.cardNumber = cardNumber;
		this.expDate = expDate;
		this.cvv=cvv;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public LocalDate getExpDate() {
		return expDate;
	}

	public void setExpDate(LocalDate expDate) {
		this.expDate = expDate;
	}

	public int getCvv() {
		return cvv;
	}

	public void setCvv(int cvv) {
		this.cvv = cvv;
	}

	@Override
	public String toString() {
		return "UserCard [cardNumber=" + cardNumber + ", expDate=" + expDate +  ", cvv=" + cvv + "]";
	}
	
	
}
