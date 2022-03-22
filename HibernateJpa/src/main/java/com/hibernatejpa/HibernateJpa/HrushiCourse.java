package com.hibernatejpa.HibernateJpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PreRemove;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@NamedQueries(value= {
@NamedQuery(name="query_get_all_courses",query="select h from HrushiCourse h"),
@NamedQuery(name="query_get_hrushi_thakur",query="select h from HrushiCourse h where name like '%Hrushi Thakur'")
})
@Cacheable
@SQLDelete(sql = "update hrushi_course set is_deleted=true where id=?")
@Where(clause = "is_deleted=false")
public class HrushiCourse {
	
	@Id
	@GeneratedValue
	private int id;
	private String name;
	
	@OneToMany(mappedBy="course")
	private List<HrushiReviews> reviews=new ArrayList<>();
	
	@ManyToMany(mappedBy="hrushi_courses")
	@JsonIgnore
	private List<HrushiStudent> hrushi_students=new ArrayList<>();
	
	private boolean isDeleted;
	
	@PreRemove
	public void preRemove() {
		System.out.println("Setting isDeleted to True");
		this.isDeleted=true;
	}
	
	public HrushiCourse() {
		
	}
	
	public HrushiCourse(String name) {
		this.name=name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	public List<HrushiReviews> getReviews() {
		return reviews;
	}

	public void addReviews(HrushiReviews review) {
		this.reviews.add(review);
	}
	
	public void removeReviews(HrushiReviews review) {
		this.reviews.remove(review);
	}
	
	public List<HrushiStudent> getStudents() {
		return hrushi_students;
	}

	public void addStudent(HrushiStudent student) {
		this.hrushi_students.add(student);
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "\nHrushiCourse [name=" + name + "]";
	}
	
	
}
