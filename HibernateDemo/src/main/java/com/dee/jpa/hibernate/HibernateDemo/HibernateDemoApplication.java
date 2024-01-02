package com.dee.jpa.hibernate.HibernateDemo;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.dee.jpa.hibernate.HibernateDemo.entity.Course;
import com.dee.jpa.hibernate.HibernateDemo.entity.Review;
import com.dee.jpa.hibernate.HibernateDemo.repository.CourseRepository;
import com.dee.jpa.hibernate.HibernateDemo.repository.StudentRepository;

import ch.qos.logback.classic.Logger;

@SpringBootApplication
public class HibernateDemoApplication implements CommandLineRunner{

	private org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired
	private StudentRepository studentRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(HibernateDemoApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		// studentRepository.saveStudentWithPassport();
		
		List<Review> reviews = new ArrayList<>();
		reviews.add(new Review("4", "Nice work"));
		reviews.add(new Review("5", "good work"));
		
		courseRepository.addReviewsForCourse(10003L, reviews);
	}

//	@Override
//	public void run(String... args) throws Exception {
//		Course course = repository.findById(10001L);
//		
//		repository.save(new Course(10005L, "learning spring"));
//		
//		repository.playWithEntityManager();
//		
//		repository.playWithEntityManager2();
//	}

}
