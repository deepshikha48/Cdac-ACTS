package com.app.core;

import java.util.HashMap;

public class BookShop {
	private HashMap<String, Customer> customers;//book shop has customers
	private HashMap<String, Book> books;//book shop has books
	private Admin admin;//book shop owner

	public BookShop(HashMap<String, Customer> customers, HashMap<String, Book> books) {
		this.customers = customers;
		this.books = books;
		this.admin=new Admin();
	}

	public HashMap<String, Customer> getCustomers() {
		return customers;
	}

	public HashMap<String, Book> getBooks() {
		return books;
	}

	public Admin getAdmin() {
		return admin;
	}

	@Override
	public String toString() {
		return "BookShop [customers=" + customers + ", books=" + books + ", admin=" + admin + "]";
	}

	
}
