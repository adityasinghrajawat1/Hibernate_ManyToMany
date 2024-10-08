package com.hibernate.mapping.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hibernate.mapping.model.Course;
import com.hibernate.mapping.repository.CourseRepository;

@Service
public class CourseService {

	@Autowired 
	CourseRepository courseRepository;
	
	public List<Course> getAllCourses()
	{
		return courseRepository.findAll();
	}
	
	public Optional<Course> getCoursesById(Long id)
	{
		return courseRepository.findById(id);
	}
	
	public boolean deleteCourseById(Long id)
	{
	     if(courseRepository.findById(id).isPresent())
	     {
	    	 courseRepository.deleteById(id);
	    	 return true;
	     }
	     
	     throw new IllegalArgumentException("Course not found with id : "+id);
	}
	
	public Course updateCourse(Course course,Long id)
	{
		Optional<Course> optionalCourseOptional = courseRepository.findById(id);
		
		if(optionalCourseOptional.isPresent())
		{
			Course course2 = optionalCourseOptional.get();
			
			course2.setTitle(course.getTitle());
			
			return courseRepository.save(course2);
		}
		
		throw new IllegalArgumentException("Course not found with id: "+id);
	}
}
