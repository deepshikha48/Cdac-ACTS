package com.app.pojos;

import javax.persistence.Column;
import javax.validation.constraints.*;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User extends BaseEntity{
	@NotBlank(message = "Name can't be blank")
	@Column(length = 20)
	private String name;
	@Column(length = 20 , unique = true,nullable = false)
	@NotBlank(message = "Email can't be blank")
	private String email;
	@Column(length = 20)
	@NotBlank(message = "Password can't be blank")
	private String password;
	
	
	public User() {
		System.out.println("Constr: "+getClass().getName());
	}

	public User(String name, String email, String password) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [userId=" + getId() + ", name=" + name + ", email=" + email + ", password=" + password + "]";
	}
	
	
	
}
