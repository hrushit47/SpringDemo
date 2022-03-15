package com.hibernatejpa.HibernateJpa;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

@Entity
public class HrushiPassport {
	
	@Id
	@GeneratedValue
	private int id;
	private String number;
	
	@OneToOne(fetch=FetchType.LAZY , mappedBy="passport")
	private HrushiStudent student;

	public HrushiPassport() {
		
	}
	
	public HrushiPassport(String number) {
		this.number=number;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public HrushiStudent getStudent() {
		return student;
	}

	public void setStudent(HrushiStudent student) {
		this.student = student;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "\nHrushiPassport [number=" + number + "]";
	}
	
	
}
