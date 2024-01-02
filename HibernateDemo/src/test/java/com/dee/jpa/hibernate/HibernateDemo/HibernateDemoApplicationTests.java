package com.dee.jpa.hibernate.HibernateDemo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.contains;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Repository;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.dee.jpa.hibernate.HibernateDemo.entity.Course;
import com.dee.jpa.hibernate.HibernateDemo.repository.CourseRepository;

import jakarta.persistence.Id;
import jakarta.transaction.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = HibernateDemoApplication.class)
class HibernateDemoApplicationTests {

	private org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	CourseRepository repository;
	
	@Test
	void findByIdTest() {
		Course course = repository.findById(10003L);
		assertEquals("learning hibernate", course.getName());
	}
	
	@Test
	@DirtiesContext // It will reset the data in DB after this Test
	void deleteByIdTest() {
		repository.deleteById(10001L);
		assertNull(repository.findById(10001L));
	}
	
	@Test
	@DirtiesContext // It will reset the data in DB after this Test
	void saveTest() {
		// get a course
		Course course = repository.findById(10001L);
		// Update Value
		course.setName("Updated");
		repository.save(course);
		// check the value
		Course course1 = repository.findById(10001L);
		assertEquals("Updated", course1.getName());
	}
	
	@Test
	@Transactional
	private void retrieveReviewsForCourse() {
		Course course = repository.findById(10001L);
		logger.info("{}", course.getReviews());
	}

}
