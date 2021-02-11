package com.app.core;

public class Admin {
	private String name;
	private String password;
	private String email;

	public Admin() {
		super();
		this.name = "admin";
		this.password="admin123";
		this.email="admin@gmail.com";
	}

	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}

	public String getEmail() {
		return email;
	}

	@Override
	public String toString() {
		return "Admin [name=" + name + ", password=" + password + ", email=" + email + "]";
	}

	
}
