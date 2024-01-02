package com.dee.jpa.hibernate.HibernateDemo.repository;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;

import com.dee.jpa.hibernate.HibernateDemo.entity.Course;
import com.dee.jpa.hibernate.HibernateDemo.entity.Passport;
import com.dee.jpa.hibernate.HibernateDemo.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class StudentRepository {

	private org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	EntityManager entityManager;
	
	public Student findById(Long id) {
		return entityManager.find(Student.class, id);
	}
	
	
	public void saveStudentWithPassport() {
		
		Passport passport = new Passport("B123");
		entityManager.persist(passport);
		
		Student student = new Student("Mike");
		student.setPassport(passport);
		entityManager.persist(student);
	}
	
	
	public void deleteById(Long id) {
		Student student = findById(id);
		entityManager.remove(id);
	}
	
	public void insertStudentAndCourse(Student student, Course course) {
		student.addCourses(course);
		course.addStudents(student);
		entityManager.persist(student);
		entityManager.persist(course);
	}

	

}
