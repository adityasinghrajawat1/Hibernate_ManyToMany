package com.hibernate.mapping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hibernate.mapping.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}
