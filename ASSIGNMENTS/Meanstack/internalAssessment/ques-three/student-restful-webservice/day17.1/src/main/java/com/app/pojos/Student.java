package com.app.pojos;
//id,firstName,lastName,email(unique),dob(LocalDate),marks

import java.time.LocalDate;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
@Entity
@Table(name="students_tab")
@JsonInclude(Include.NON_DEFAULT)
public class Student extends BaseEntity{
	@Column(name="first_nm",length = 20)
	private String firstName;
	@Column(name="last_nm",length = 20)
	private String lastName;
	@Column(length = 20,unique = true)
	@NotBlank(message="Email required")
	private String email;
	private LocalDate dob;
	private int marks;
	
	public Student() {}
		
	public Student(String lastName, int marks) {
		super();
		this.lastName = lastName;
		this.marks = marks;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	@Override
	public String toString() {
		return "Student [id=" +getId() + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", dob=" + dob + ", marks=" + marks + "]";
	}
	

}
