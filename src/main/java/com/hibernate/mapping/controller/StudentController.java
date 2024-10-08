package com.hibernate.mapping.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hibernate.mapping.model.Student;
import com.hibernate.mapping.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	StudentService studentService;
	
	@GetMapping("start")
	public String getStart()
	{
		return "start...........";
	}
	
	@PostMapping("save")
	public Student saveStudent(@RequestBody Student student)
	{
		return studentService.saveStudent(student);
	}
	
	@GetMapping("getAll")
	public List<Student> getAllStudent()
	{
		return studentService.getAllStudent();
	}
	
	@DeleteMapping("delete/{id}")
	public String deleteById(@PathVariable Long id)
	{
		studentService.deleteById(id);
		return "Student removed with id : "+id;
	}
	
	@GetMapping("getById/{id}")
	public Optional<Student> getStudentById(@PathVariable Long id)
	{
		return studentService.getStudentById(id);
	}
	
	
	@PutMapping("update/{id}")
	public Student updateStudent(@RequestBody Student student , @PathVariable Long id)
	{
		return studentService.updateStudent(student, id);
	}
}
