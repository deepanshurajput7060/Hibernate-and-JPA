package com.dee.jpa.hibernate.HibernateDemo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.contains;

import java.util.List;

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

import jakarta.persistence.Embeddable;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Id;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = HibernateDemoApplication.class)
class JPQLTest {

	private org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	EntityManager entityManager;
	
	@Test
	public void jpql_basic() {
		Query query = entityManager.createNamedQuery("query_get_all_courses");
		
		List resultList = query.getResultList();
		logger.info("Select c From Course c -> {}", resultList);
	
	}
	
	@Test
	public void jpql_where() {
		TypedQuery<Course> query = entityManager.createNamedQuery("query_get_100_steps_courses", Course.class);
		
		List resultList = query.getResultList();
		logger.info("Select c From Course c where name like '%100 Steps' -> {}", resultList);
	
	}
	
	@Test
	public void jpql_courses_without_students() {
		TypedQuery<Course> query = entityManager.createQuery("Select c From Course c where c.student is empty", Course.class);
		List resultList = query.getResultList();
		logger.info("Result -> {}", resultList);
	
	}
	
	
	@Test
	public void jpql_courses_with_atleast_2_students() {
		TypedQuery<Course> query = entityManager.createQuery("Select c From Course c where size(c.student) >= 2", Course.class);
		List resultList = query.getResultList();
		logger.info("Result -> {}", resultList);
	
	}
	
	@Test
	public void jpql_courses_ordered_by__students() {
		TypedQuery<Course> query = entityManager.createQuery("Select c From Course c order by c.student ", Course.class);
		List resultList = query.getResultList();
		logger.info("Result -> {}", resultList);
	
	}

	@Test
	public void jpql_students_with_pssport_in_a_certain_pattern() {
		TypedQuery<Course> query = entityManager.createQuery("Select s From Student s where s.passport.number like '%123%' ", Course.class);
		List resultList = query.getResultList();
		logger.info("Result -> {}", resultList);
	
	}
	
	
}
