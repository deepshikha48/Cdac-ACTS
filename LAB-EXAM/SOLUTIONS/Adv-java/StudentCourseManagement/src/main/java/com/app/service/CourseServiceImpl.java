package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.Course;
import com.app.repository.CourseRepository;

@Service
@Transactional
public class CourseServiceImpl implements ICourseService {
	
	@Autowired
	private CourseRepository repo;

	@Override
	public List<Course> findAllCourses() {
		return repo.findAll();
	}

	@Override
	public Optional<Course> findCourseById(Integer id) {
		return repo.findById(id);
	}
	

	@Override
	public void delete(Course course) {
		repo.delete(course);		
	}


	
}
