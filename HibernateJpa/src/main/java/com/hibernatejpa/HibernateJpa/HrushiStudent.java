package com.hibernatejpa.HibernateJpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

@Entity
public class HrushiStudent {
	
	@Id
	@GeneratedValue
	private int id;
	private String name;
	
	@Embedded
	private Address address;
	
	@OneToOne(fetch=FetchType.LAZY)
	private HrushiPassport passport;
	
	@ManyToMany
	@JoinTable(name="hrushi_student_hrushi_course",
			joinColumns	= @JoinColumn(name="student_id"),
			inverseJoinColumns = @JoinColumn(name="course_id"))
	private List<HrushiCourse> hrushi_courses=new ArrayList<>();


	public HrushiStudent() {
		
	}
	
	public HrushiStudent(String name) {
		this.name=name;
	}
	
	
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public HrushiPassport getPassport() {
		return passport;
	}

	public void setPassport(HrushiPassport passport) {
		this.passport = passport;
	}
	
	public List<HrushiCourse> getCourses() {
		return hrushi_courses;
	}

	public void addCourse(HrushiCourse course) {
		this.hrushi_courses.add(course);
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "\nHrushiStudent [name=" + name + "]";
	}
	
	
}
