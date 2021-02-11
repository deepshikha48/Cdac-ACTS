package com.app.service;

import java.util.List;
import java.util.Optional;

import com.app.pojos.Course;

public interface ICourseService {

	List<Course> findAllCourses();
	Optional<Course> findCourseById(Integer id);
	void delete(Course course);

}
