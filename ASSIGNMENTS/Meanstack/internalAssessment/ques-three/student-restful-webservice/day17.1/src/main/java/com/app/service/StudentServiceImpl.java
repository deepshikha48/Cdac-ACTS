package com.app.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.StudentRepository;
import com.app.pojos.Student;

@Service
@Transactional
public class StudentServiceImpl implements IStudentService {
	// dependency : Repo.
	@Autowired
	private StudentRepository repo;

	@Override
	public List<Student> getAllStudents() {
		// JpaRepository : findAll
		return repo.findAll();
	}

	@Override
	public List<Student> getAllStudentsAfterDate(LocalDate date) {
		// TODO Auto-generated method stub
		// return repo.fetchStudentDetailsByDob(date);
		return repo.findByDobGreaterThan(date);
	}

	@Override
	public List<Student> getAllStudentsByLastName(String prefix) {
		// TODO Auto-generated method stub
		return repo.findByLastNameStartingWith(prefix);
	}

	@Override
	public List<Student> getAllStudentsByMarks(int strt, int end) {
		// TODO Auto-generated method stub
		return repo.findByMarksBetween(strt, end);
	}

	@Override
	public Student saveStudentDetails(Student transientStudent) {
		Student student = repo.save(transientStudent);// student : DETACHED : insert
		student.setFirstName(student.getFirstName().toUpperCase());
		return student;
	}

	@Override
	public String  deleteStudentDetails(int studentId) {
		String mesg = "Student rec deleted successfully";
		repo.deleteById(studentId);
		return mesg;
	}

	@Override
	public Student updateDetails(Student s) {
		//  s: DETACHED (not in L1 cache BUT exists in DB) pojo BUT with updated state
		return repo.save(s);//update
	}

	@Override
	public Optional<Student> getStudentDetailsById(int studentId) {
		// fetch student details by id
		return repo.findById(studentId);
	}

	@Override
	public List<Student> getPartialDetails(String fName) {
		// TODO Auto-generated method stub
		return repo.fetchPartialDetails(fName);
	}
	
	

}
