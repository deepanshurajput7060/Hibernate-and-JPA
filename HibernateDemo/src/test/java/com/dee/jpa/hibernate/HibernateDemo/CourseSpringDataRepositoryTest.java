package com.dee.jpa.hibernate.HibernateDemo;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.h2.mvstore.Page;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import com.dee.jpa.hibernate.HibernateDemo.entity.Course;
import com.dee.jpa.hibernate.HibernateDemo.repository.CourseSpringDataRepository;

import net.bytebuddy.asm.Advice.OffsetMapping.Sort;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = HibernateDemoApplication.class)
class CourseSpringDataRepositoryTest {

	private org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	CourseSpringDataRepository repository;
	
	@Test
	public void fingById() {
		Optional<Course> cOptional=  repository.findById(10001L);
		assertTrue(cOptional.isPresent());
	}
	
	@Test
	public void playingAroundWithSpringDataRepository() {
		
		// save method is used for both insert and update
		Course course = new Course("Microservice in 100 steps");
		repository.save(course);
		
		course.setName("Microservice in 100 steps - Updated");
		repository.save(course);
		
		logger.info("Courses -> {}", repository.findAll());
		logger.info("Count -> {}", repository.count());
	}
	
	@Test
	public void pagination() {
		PageRequest pageRequest = PageRequest.of(0, 3);
		
		logger.info("First page -> {}",  repository.findAll(pageRequest));
	
		}

}
