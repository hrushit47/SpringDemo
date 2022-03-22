package com.hibernatejpa.HibernateJpa;


//import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.transaction.annotation.Transactional;
//import org.springframework.test.context.junit4.SpringRunner;

//@RunWith(SpringRunner.class)
@SpringBootTest(classes=HibernateJpaApplication.class)
class StudentRepositoryTest {
	
	@Autowired
	CourseRepository repository;

	@Autowired
	EntityManager entityManager;

	@Test
	@Transactional
	public void retrieveStudentAndPassportDetails() {
		HrushiStudent student=entityManager.find(HrushiStudent.class,204);
		System.out.println("Student Details ->"+student);
		System.out.println("Passport Details ->"+student.getPassport());
		
	}
	
	@Test
	@Transactional
	public void setAddressDetails() {
		HrushiStudent student=entityManager.find(HrushiStudent.class,204);
		student.setAddress(new Address("4156","Balaji Lane","Yeola"));
		entityManager.flush();
		entityManager.persist(student);
		System.out.println("Student Details ->"+student);
		System.out.println("Passport Details ->"+student.getPassport());
		
	}

	@Test
	@Transactional
	public void retrievePassportAndAssociatedStudent() {
		HrushiPassport passport=entityManager.find(HrushiPassport.class,304);
		System.out.println("Passport Details ->"+passport);
		System.out.println("Student Details ->"+passport.getStudent());
		
	}

	@Test
	@Transactional
	public void retrieveStudentAndCourses() {
		HrushiStudent student=entityManager.find(HrushiStudent.class,201);
		System.out.println("Student Details ->"+student);
		System.out.println("Course Details ->"+student.getCourses());
		
	}

	@Test
	@Transactional
	public void retrieveCourseAndStudent() {
		HrushiCourse course=entityManager.find(HrushiCourse.class,101);
		System.out.println("Course Details ->"+course);
		System.out.println("Students Details ->"+course.getStudents());
		
	}

	

}
