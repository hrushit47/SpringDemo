package com.hibernatejpa.HibernateJpa;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class CourseRepository {
	
	@Autowired
	EntityManager entityManager;
	
	public HrushiCourse findById(int i) {
		return entityManager.find(HrushiCourse.class, i);
	}
	
	public HrushiCourse save(HrushiCourse course) {
		if(course.getId() == 0) {
			entityManager.persist(course);
		}
		else {
			entityManager.merge(course);
		}
		return course;
		
	}
	public void deleteById(int i) {
		HrushiCourse course=findById(i);
		entityManager.remove(course);
	}
	
	public void playWithEntityManager() {
		HrushiCourse course1 = new HrushiCourse("Nilesh");
		entityManager.persist(course1);
		HrushiCourse course2 = new HrushiCourse("Suhas");
		entityManager.persist(course2);
		
		entityManager.flush();
		
		course1.setName("Nilesh Updated");
		course2.setName("Suhas Updated");
		entityManager.refresh(course1);
		
		entityManager.flush();
		
		
	}

	public void addHardcodedReviewsForCourse() {
		//get the course 101
		HrushiCourse course3=findById(101);
		System.out.println("Finding course_id 101->"+course3.getReviews());
		
		//add 2 reviews to it
		HrushiReviews review1=new HrushiReviews(ReviewRating.FIVE,"Great Hands-on Stuff");
		HrushiReviews review2= new HrushiReviews(ReviewRating.FIVE,"Hats-off");
		
		//setting the relationship
		course3.addReviews(review1);
		review1.setCourse(course3);
		
		course3.addReviews(review2);
		review2.setCourse(course3);
		
		//save it to the database
		entityManager.persist(review1);
		entityManager.persist(review2);
	}
	
	public void addReviewsForCourse(int courseId,List<HrushiReviews> reviews) {
		//get the course 101
		HrushiCourse course3=findById(19);
		System.out.println("Finding course_id 101->"+course3.getReviews());
				
		for(HrushiReviews review:reviews)
		{		
		course3.addReviews(review);
		review.setCourse(course3);
		entityManager.persist(review);
		
		}
	}
}
