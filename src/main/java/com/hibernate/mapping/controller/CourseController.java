package com.hibernate.mapping.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hibernate.mapping.model.Course;
import com.hibernate.mapping.service.CourseService;
import com.hibernate.mapping.service.StudentService;

@RestController
@RequestMapping("/course")
public class CourseController {

	@Autowired
	CourseService courseService;
	
	@GetMapping("run")
	public String getRun()
	{
		return "running........";
	}
	
	@GetMapping("getAll")
	public List<Course> getAllCourses()
	{
		return courseService.getAllCourses();
	}
	
	@GetMapping("getById/{id}")
	public Optional<Course> getCoursesById(@PathVariable Long id)
	{
		return courseService.getCoursesById(id);
	}
	
	@DeleteMapping("delete/{id}")
	public String deleteCourseById(@PathVariable Long id)
	{
		courseService.deleteCourseById(id);
		return "Course deleted with id"+id;
	}
	
	
	@PutMapping("update/{id}")
	public Course updateCourse(@RequestBody Course course,@PathVariable Long id)
	{
		return courseService.updateCourse(course, id);
	}
}
