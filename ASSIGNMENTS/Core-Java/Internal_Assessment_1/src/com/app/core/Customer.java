package com.app.core;

import java.util.HashMap;

public class Customer {
	private String name;
	private String email;
	private String password;
	private HashMap<String, Book> cart;//customer has a cart to books into it

	public Customer(String name, String email, String password) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public HashMap<String, Book> getCart() {
		return cart;
	}

	public String getPassword() {
		return password;
	}

	// function to create empty cart
	public void addCart() {
		HashMap<String, Book> cartBooks=new HashMap<>();
		this.cart = cartBooks;
	}
	
	@Override
	public String toString() {
		return "customer [name=" + name + ", email=" + email + ", password=" + password + ", cart=" + cart + "]";
	}

}
