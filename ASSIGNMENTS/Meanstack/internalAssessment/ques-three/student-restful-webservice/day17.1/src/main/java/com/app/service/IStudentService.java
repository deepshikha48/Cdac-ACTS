package com.app.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.app.pojos.Student;

public interface IStudentService {
//List all students
	List<Student> getAllStudents();
	//List all students with date of birth after a specific date
	List<Student> getAllStudentsAfterDate(LocalDate date);
	//	List all students with lastname starting with some prefix
	List<Student> getAllStudentsByLastName(String prefix);
//	List all students having marks within a range
	List<Student> getAllStudentsByMarks(int strt,int end);
	//insert new record
	Student saveStudentDetails(Student transientStudent);
	//delete a record
	String deleteStudentDetails(int studentId);
	//update student details
	Student updateDetails(Student s);
	//get student details by id
	Optional<Student> getStudentDetailsById(int studentId);
	//get partial student details
	List<Student> getPartialDetails(String fName);
}
