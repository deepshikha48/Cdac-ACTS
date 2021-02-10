package com.app.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.pojos.Course;
import com.app.pojos.Student;
import com.app.service.ICourseService;
import com.app.service.IStudentService;

@Controller
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private IStudentService studentService;
	@Autowired
	private ICourseService courseService;
	
	@GetMapping("/add")
	public String AddStudentForm(Student student,@RequestParam Integer id,HttpSession hs)
	{
	
		Course course=courseService.findCourseById(id).get();
		hs.setAttribute("course", course);
		return "/student/add";
	}
	
	@PostMapping("/add")
	public String ProcessAddStudentForm(Student student,HttpSession hs)
	{
		Course course=(Course)hs.getAttribute("course");
		student.setCourse(course);
		System.out.println(studentService.addStudent(student));
		return "redirect:/course/list";
	}
}
