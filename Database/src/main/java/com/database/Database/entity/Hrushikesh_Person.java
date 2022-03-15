package com.database.Database.entity;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity

public class Hrushikesh_Person {
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	@Column(name="name")
	private String name;
	@Column(name="location")
	private String location;
	@Column(name="birth_date")
	private Date birthdate;
	
	public Hrushikesh_Person() {
		
	}
	public Hrushikesh_Person(int id, String name, String location, Date birthdate) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		this.birthdate = birthdate;
		
	}
	
	public Hrushikesh_Person(String name, String location, Date birthdate) {
		super();
		this.name = name;
		this.location = location;
		this.birthdate = birthdate;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Date getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}
	@Override
	public String toString() {
			return String.format("\n Hrushikesh_Person [id=%s, name=%s, location=%s, birthDate=%s]", id, name, location, birthdate);
	}
	
	

	
}
