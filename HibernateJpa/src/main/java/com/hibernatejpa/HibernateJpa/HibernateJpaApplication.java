package com.hibernatejpa.HibernateJpa;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HibernateJpaApplication implements CommandLineRunner {
	
	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired
	private StudentRepository studentRepository;


	public static void main(String[] args) {
		SpringApplication.run(HibernateJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		
		//studentRepository.insertHardcodedStudentAndCourses();
		
		//studentRepository.insertStudentAndCourses(new HrushiStudent("Sneha"),new HrushiCourse("Sneha Chavan"));
		/*HrushiCourse course=courseRepository.findById(101);
		System.out.println("HrushiCourse 1001 -> {}"+course);
		*/	
		//studentRepository.saveStudentWithPassport();
		
		//courseRepository.addHardcodedReviewsForCourse();
		
		/*List<HrushiReviews> reviews=new ArrayList<>();
		reviews.add(new HrushiReviews("5","Excellent Course"));
		reviews.add(new HrushiReviews("4","Best Course"));
		courseRepository.addReviewsForCourse(19, reviews);
		*/
	}

}
