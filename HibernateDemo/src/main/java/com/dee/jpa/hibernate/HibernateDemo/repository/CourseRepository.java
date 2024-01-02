package com.dee.jpa.hibernate.HibernateDemo.repository;

import java.util.Iterator;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;

import com.dee.jpa.hibernate.HibernateDemo.entity.Course;
import com.dee.jpa.hibernate.HibernateDemo.entity.Review;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CourseRepository {

	private org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	EntityManager entityManager;
	
	public Course findById(Long id) {
		return entityManager.find(Course.class, id);
	}
	
	public void deleteById(Long id) {
		Course course = findById(id);
		entityManager.remove(id);
	}
	
	public Course save(Course course) {
		if (course.getId()==null) {
			entityManager.persist(course); // Insert
		} else {
			entityManager.merge(course); // Update
		}
		
		return course;
	}
	
	
	
	public void addReviewsForCourse(Long courseId, List<Review> reviews) {
		// get the course
		Course course = findById(courseId);
		logger.info("course.getReviews() -> {}", course.getReviews());
		
		for(Review review: reviews) {
			course.addReviews(review);
			review.setCourse(course);
			entityManager.persist(course);
		}
		
	}
	
	public void playWithEntityManager() {
		
		logger.info("Play with Entity Manager - Start");

        // Adding a new course
		Course course = new Course(4L, "Web Service in 100 Steps");
		// Adding this course into DB
		entityManager.persist(course);
		// Without calling Persist method, setName will update the new value in DB
		course.setName("Web Service in 100 Steps - Updated");
		
	}
	
	public void playWithEntityManager2() {
		
		Course course = new Course(5L, "Web Service in 150 Steps");
		entityManager.persist(course);
		course.setName("Web Service in 100 Steps - Updated");
		// flust() is used to add everything in the DB till Now.
		entityManager.flush();
		
		// detach() is used to stop inserting the changes into DB made after it 
		entityManager.detach(course);
		
		course.setName("Web Service in 100 Steps - Updated 2nd time");
		
		// refresh() will remove all the updated value from the DB
		entityManager.refresh(course);
		
	}

}
