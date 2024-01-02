package com.dee.jpa.hibernate.HibernateDemo.repository;

import java.util.Iterator;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dee.jpa.hibernate.HibernateDemo.entity.Course;
import com.dee.jpa.hibernate.HibernateDemo.entity.Review;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
public interface CourseSpringDataRepository extends JpaRepository<Course, Long>{

	

}
