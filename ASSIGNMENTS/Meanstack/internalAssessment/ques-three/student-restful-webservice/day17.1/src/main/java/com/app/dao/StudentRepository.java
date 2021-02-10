package com.app.dao;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.pojos.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
	//@Query("select s from Student s where s.dob > :dt")
//	List<Student> fetchStudentDetailsByDob(@Param(value = "dt")LocalDate dob);
	//OR
	List<Student> findByDobGreaterThan(LocalDate dt);
	//List all students with lastname starting with some prefix
	List<Student> findByLastNameStartingWith(String prefix);
	// List all students with marks in the range of begin n end
	List<Student> findByMarksBetween(int strt,int end);
	//fetch partial student details having common first name
	@Query("select new com.app.pojos.Student(lastName,marks) from Student s where s.firstName=:nm")
	List<Student> fetchPartialDetails(@Param("nm")  String fName);
	
	
	
}
