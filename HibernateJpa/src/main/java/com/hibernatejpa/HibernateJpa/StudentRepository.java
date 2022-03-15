package com.hibernatejpa.HibernateJpa;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class StudentRepository {
	
	@Autowired
	EntityManager entityManager;
	
	public HrushiStudent findById(int i) {
		return entityManager.find(HrushiStudent.class, i);
	}
	
	public HrushiStudent save(HrushiStudent student) {
		if(student.getId() == 0) {
			entityManager.persist(student);
		}
		else {
			entityManager.merge(student);
		}
		return student;
		
	}
	public void deleteById(int i) {
		HrushiStudent student=findById(i);
		entityManager.remove(student);
	}
	
	public void saveStudentWithPassport() {
		HrushiPassport passport=new HrushiPassport("E100005");
		entityManager.persist(passport);
		
		HrushiStudent student=new HrushiStudent("Atharva");
		student.setPassport(passport);
		entityManager.persist(student);
	}
}
