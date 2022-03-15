package com.hibernatejpa.HibernateJpa;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

@Entity
public class HrushiStudent {
	
	@Id
	@GeneratedValue
	private int id;
	private String name;
	
	@OneToOne(fetch=FetchType.LAZY)
	private HrushiPassport passport;

	public HrushiStudent() {
		
	}
	
	public HrushiStudent(String name) {
		this.name=name;
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

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "\nHrushiStudent [name=" + name + "]";
	}
	
	
}
