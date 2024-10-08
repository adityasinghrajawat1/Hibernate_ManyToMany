package com.hibernate.mapping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hibernate.mapping.model.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

}
