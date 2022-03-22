package com.hibernatejpa.HibernateJpa;


//import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.EntityManager;
//import javax.transaction.Transactional;
import org.springframework.transaction.annotation.Transactional;
import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
//import org.springframework.test.context.junit4.SpringRunner;

//@RunWith(SpringRunner.class)
@SpringBootTest(classes=HibernateJpaApplication.class)
class CourseRepositoryTest {
	
	@Autowired
	CourseRepository repository;
	
	@Autowired
	EntityManager entityManager;


	@Test
	void findById_basic() {
		HrushiCourse course= repository.findById(101);
		System.out.println(course);
		assertEquals("Hrushi Thakur",course.getName());
	}
	
	@Test
	@Transactional
	void findById_firstLevelCacheDemo() {
		HrushiCourse course= repository.findById(101);
		System.out.println("First Course retrieved{}->"+course);
		
		HrushiCourse course1= repository.findById(101);
		System.out.println("First Course retrieved again{}->"+course1);

		assertEquals("Hrushi Thakur",course.getName());
		assertEquals("Hrushi Thakur",course1.getName());
	}
	
	@Test
	@DirtiesContext
	void deleteById_basic() {
		repository.deleteById(481);
		assertNull(repository.findById(481));
	}
	
	@Test
	@DirtiesContext
	void save_basic() {
		HrushiCourse course= repository.findById(101);
		assertEquals("Hrushi",course.getName());
		
		course.setName("Hrushi Thakur");
		repository.save(course);
		
		HrushiCourse course1= repository.findById(101);
		assertEquals("Hrushi Thakur",course1.getName());
	}
	
	@Test
	@DirtiesContext
	void playWithEntityManager() {
		repository.playWithEntityManager();
		
	}
	
	@Test
	@Transactional
	void retrieveReviewsForCourse() {
		HrushiCourse course=repository.findById(101);
		System.out.println("{}"+course.getReviews());
	}
	
	@Test
	@Transactional
	void retrieveCourseForReview() {
		HrushiReviews review=entityManager.find(HrushiReviews.class,401);
		System.out.println("{}"+review.getCourse());
	}

	

	

}
