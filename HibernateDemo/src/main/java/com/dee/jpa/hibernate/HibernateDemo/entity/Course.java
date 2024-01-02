package com.dee.jpa.hibernate.HibernateDemo.entity;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.CurrentTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
// @Table(name = "Course")
@NamedQueries (value = {
		@NamedQuery(name= "query_get_all_courses", 
				query = "Select c From Course c"),
		@NamedQuery(name = "query_get_100_steps_courses", 
				query = "Select c From Course c where name like '%100 Steps'")
})

public class Course {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name = "name", nullable = false)
	private String name;

	@CurrentTimestamp
	String created_date;
	
	@UpdateTimestamp
	String last_updated_date;
	
	@OneToMany(mappedBy = "course")
	private List<Review> reviews = new ArrayList<>();
	
	@ManyToMany(mappedBy = "course")
	private List<Student> students = new ArrayList<>();
	
	public Course() {
		// TODO Auto-generated constructor stub
	}
	
	public Course(String name) {
		super();
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void addReviews(Review review) {
		this.reviews.add(review);
	}
	
	public void removeReviews(Review review) {
		this.reviews.remove(review);
	}
	
	public List<Student> getStudents() {
		return students;
	}

	public void addStudents(Student student) {
		this.students.add(student);
	}
	
	public void removeStudents(Student student) {
		this.students.remove(student);
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", created_date" + created_date + ", last_updated_date" + last_updated_date + "]";
	}

}
