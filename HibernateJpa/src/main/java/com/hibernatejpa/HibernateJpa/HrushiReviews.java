package com.hibernatejpa.HibernateJpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

@Entity
public class HrushiReviews {
	
	@Id
	@GeneratedValue
	private int id;
	private String rating;
	private String description;
	
	@ManyToOne
	private HrushiCourse course;

	public HrushiReviews() {
		
	}
	
	
	public HrushiReviews(String rating, String description) {
		super();
		this.rating = rating;
		this.description = description;
	}


	public String getRating() {
		return rating;
	}


	public void setRating(String rating) {
		this.rating = rating;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}

	

	public HrushiCourse getCourse() {
		return course;
	}


	public void setCourse(HrushiCourse course) {
		this.course = course;
	}


	public int getId() {
		return id;
	}


	@Override
	public String toString() {
		return "HrushiReviews [rating=" + rating + ", description=" + description + "]";
	}

	
	
	
}
