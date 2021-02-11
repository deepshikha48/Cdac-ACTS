package com.app.pojos;

import java.time.LocalDate;
import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "students")
public class Student extends BaseEntity{

	@Column(name = "student_name",length = 20,nullable = false)
	private String name;
	
	@Column(length = 40,nullable = false)
	private String address;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dob;
	
	@Column(columnDefinition = "double(2,1)",nullable = false)
	private double cgpa;
	
	@ManyToOne
	@JoinColumn(name = "course_id")
	private Course course;
	
	public Student() {
		System.out.println("In Student default constr");
	}
	
	public Student(String name, String address, LocalDate dob, double cgpa) {
		super();
		this.name = name;
		this.address = address;
		this.dob = dob;
		this.cgpa = cgpa;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public double getCgpa() {
		return cgpa;
	}

	public void setCgpa(double cgpa) {
		this.cgpa = cgpa;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	@Override
	public String toString() {
		return "Student [Id= "+ getId() +" , name=" + name + ", address=" + address + ", dob=" + dob + ", cgpa=" + cgpa + "]";
	}
	
	
	
	
}
