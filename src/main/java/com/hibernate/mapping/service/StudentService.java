package com.hibernate.mapping.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hibernate.mapping.model.Student;
import com.hibernate.mapping.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	StudentRepository studentRepository;
	
	
	public Student saveStudent(Student stud)
	{
		return studentRepository.save(stud);
	}
	
	public List<Student> getAllStudent()
	{
		return studentRepository.findAll();
	}
	
	public boolean deleteById(Long id)
	{
		if(studentRepository.findById(id).isPresent())
		{
			studentRepository.deleteById(id);
			return true;
		}
		
		throw new IllegalArgumentException("Student not found  with id : "+id);
	}
	
	public Optional<Student> getStudentById(Long id)
	{  
	   return studentRepository.findById(id);
	}
	
	public Student updateStudent(Student student, Long id)
	{
		Optional<Student> optionalStudentOptional = studentRepository.findById(id);
		
		if(optionalStudentOptional.isPresent())
		{
			Student student2 = optionalStudentOptional.get();
			
			student2.setName(student.getName());
			
			return studentRepository.save(student2);
		}
		
		throw new IllegalArgumentException("No Student found with id : "+id);
	}
}
