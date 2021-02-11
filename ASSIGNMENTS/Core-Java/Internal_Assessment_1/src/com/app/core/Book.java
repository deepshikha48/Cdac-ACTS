package com.app.core;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import custom_enum.Category;

public class Book {
	private String title;
	private Category category;
	private ArrayList<Author> authors;
	private double price;
	private int quantity;
	private LocalDate publishDate;
	private double rating;

	public Book(String title, Category category, double price, int quantity, LocalDate publishDate, double rating) {
		this.title = title;
		this.category = category;
		this.price = price;
		this.quantity = quantity;
		this.publishDate = publishDate;
		this.rating = rating;
	}

	public String getTitle() {
		return title;
	}

	public Category getCategory() {
		return category;
	}

	public ArrayList<Author> getAuthors() {
		return authors;
	}

	public LocalDate getPublishDate() {
		return publishDate;
	}

	public double getRating() {
		return rating;
	}

	public double getPrice() {
		return price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity =quantity;
	}

	// function to add authors related to a book
	public void linkAuthorsToBook(List<Author> authors) {
		this.authors = new ArrayList<>(authors);
	}

	@Override
	public String toString() {
		return "Title=" + title + ", Category=" + category + ", Authors=" + authors + ", Price=" + price + ", Quantity="
				+ quantity + ", Publish Date=" + publishDate + ", Rating=" + rating;

	}

}
