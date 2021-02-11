package com.app.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Student;
import com.app.service.IStudentService;

@RestController // combination of @Controller + @ResponseBody , on ret types
//of req handling methods : meant for marshalling (java--->json/xml)
@RequestMapping("/students")
public class StudentController {
	// dep
	@Autowired
	private IStudentService service;

	@PostConstruct
	public void init() {
		System.out.println("in init " + service);
	}

	// REST API end point to supply list of all students
	// o.s.http.ResponseEntity<T> => represents entire resp pkt. T : body
	// ResponseEntity<T> (T body , HttpStatus sc)
	// ResponseEntity<T> (HttpStatus sc)
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping
	public ResponseEntity<?> getAllStudentDetails() {
		System.out.println("in get all studs");
		// invoke service layer method
		List<Student> students = service.getAllStudents();
		if (students.isEmpty())
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<>(students, HttpStatus.OK);
	}

	// REST end point : to fetch selected student list
	@GetMapping("/{birthDate}")
	public ResponseEntity<?> getStudentDetailsByDob(
			@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate birthDate) {
		System.out.println("get by dob " + birthDate);
		List<Student> students = service.getAllStudentsAfterDate(birthDate);
		if (students.isEmpty())
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<>(students, HttpStatus.OK);

	}

	// REST end point : to fetch selected student list by last name prefix
	@GetMapping("/last_name/{prefix}")
	public ResponseEntity<?> getStudentDetailsByLastName(@PathVariable String prefix) {
		System.out.println("get by dob " + prefix);
		List<Student> students = service.getAllStudentsByLastName(prefix);
		if (students.isEmpty())
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<>(students, HttpStatus.OK);

	}

	// REST end point : to fetch selected student list by range of marks
	@GetMapping("/marks")
	public ResponseEntity<?> getStudentDetailsByMarks(@RequestParam int start, @RequestParam int end) {
		System.out.println("get by marks " + start + " " + end);
		List<Student> students = service.getAllStudentsByMarks(start, end);
		if (students.isEmpty())
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<>(students, HttpStatus.OK);

	}

	// REST end point : to fetch partial details of all students with same first
	// name
	@GetMapping("/fname/{first_nm}")
	public ResponseEntity<?> getStudentDetailsByName(@PathVariable String first_nm) {
		System.out.println("get by fname " + first_nm);
		List<Student> students = service.getPartialDetails(first_nm);
		if (students.isEmpty())
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<>(students, HttpStatus.OK);

	}

	// REST end point to create a new resource : Student
	@PostMapping("/store")
	public ResponseEntity<?> saveStudentDetails(@RequestBody @Valid Student s) {
		System.out.println("in save student " + s);// transient un marshalled from json ---> student details
		try {
			Student details = service.saveStudentDetails(s);
			return new ResponseEntity<>(details, HttpStatus.CREATED);
		} catch (RuntimeException e) {
			System.out.println("err in save " + e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);// empty body content , sending only err code
		}
	}

	// REST end point to delete a existing resource
	@DeleteMapping("/{sid}")
	public ResponseEntity<?> deleteInfo(@PathVariable int sid) {
		System.out.println("in del info " + sid);

		return new ResponseEntity<>(service.deleteStudentDetails(sid), HttpStatus.OK);

	}
	
	// REST end point to fetch student by id
	@GetMapping("/id/{sid}")
	public ResponseEntity<?> fetchById(@PathVariable int sid){
		System.out.println("in find by id "+sid);
		Optional<Student> student = service.getStudentDetailsById(sid);
		if (student.isPresent())
			return new ResponseEntity<>(student.get(), HttpStatus.OK);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
	}

	// REST end point for updating student details
	@PutMapping("/{sid}")
	public ResponseEntity<?> updateStudentDetails(@RequestBody Student s, @PathVariable int sid) {
		// chk if resource exists
		Optional<Student> optionalStudent = service.getStudentDetailsById(sid);
		if (optionalStudent.isPresent()) {
			// resource exists : detached
			Student existingStudent = optionalStudent.get();
			existingStudent.setMarks(s.getMarks());
			existingStudent.setLastName(s.getLastName());
			try {
				service.updateDetails(existingStudent);
				// return new ResponseEntity<>(existingStudent, HttpStatus.OK);
				return ResponseEntity.ok(existingStudent);
			} catch (RuntimeException e) {
				System.out.println("err in delete " + e);
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}

		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);

	}

}
