package com.dee.jpa.hibernate.HibernateDemo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Repository;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.dee.jpa.hibernate.HibernateDemo.entity.Course;
import com.dee.jpa.hibernate.HibernateDemo.entity.Passport;
import com.dee.jpa.hibernate.HibernateDemo.entity.Student;
import com.dee.jpa.hibernate.HibernateDemo.repository.CourseRepository;
import com.dee.jpa.hibernate.HibernateDemo.repository.StudentRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Id;
import jakarta.transaction.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = HibernateDemoApplication.class)
class StudentRepositoryTest {
	
	private org.slf4j.Logger logger =LoggerFactory.getLogger(this.getClass());

	@Autowired
	StudentRepository repository;
	
	@Autowired
	EntityManager entityManager;
	
	@Test
	@Transactional
	void retrieveStudentAndPassportDetails() {
		Student student = entityManager.find(Student.class, 20001L);
		logger.info("student -> {}", student);		
		logger.info("passport -> {}", student.getPassport());
	}
	
	@Test
	@Transactional
	void retrieveStudentAndCourse() {
		Student student = entityManager.find(Student.class, 20001L);
		logger.info("student -> {}", student);		
		logger.info("passport -> {}", student.getCourses());
	}
	
	

}
