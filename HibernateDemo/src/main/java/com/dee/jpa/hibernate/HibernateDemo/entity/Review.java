package com.dee.jpa.hibernate.HibernateDemo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Review {

	@Id
	@GeneratedValue
	private Long id;
	
	private String rating;
	
	private String description;
	
	@ManyToOne
	private Course course;

	protected Review() {
		
	}
	
	public Review(String rating, String description) {
		super();
		this.rating = rating;
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getdescription() {
		return description;
	}

	public void setdescription(String description) {
		this.description = description;
	}
	
	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	@Override
	public String toString() {
		return String.format("Review[%s %s]",rating ,description);
	}
	
	
}
