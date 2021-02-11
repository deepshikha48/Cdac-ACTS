package com.app.core;

public class Author {
	private String name;
	private String email;

	public Author(String name, String email) {
		this.email = email;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Name=" + name + ", Email=" + email;
	}

}
