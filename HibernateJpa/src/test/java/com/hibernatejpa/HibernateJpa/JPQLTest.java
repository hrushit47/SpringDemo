package com.hibernatejpa.HibernateJpa;


//import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
//import org.springframework.test.context.junit4.SpringRunner;

//@RunWith(SpringRunner.class)
@SpringBootTest(classes=HibernateJpaApplication.class)
class JPQLTest {
	
	@Autowired
	EntityManager entityManager;

	@Test
	void jpql_basic() {
		Query query = entityManager.createNamedQuery("query_get_all_courses");
		List resultList = query.getResultList();
		System.out.println("select h from HrushiCourse h ->{}"+resultList);
	}
	
	@Test
	void jpql_typed() {
		TypedQuery<HrushiCourse> query = 
				entityManager.createNamedQuery("query_get_all_courses", HrushiCourse.class);
		
		List<HrushiCourse> resultList = query.getResultList();
		System.out.println("select h from HrushiCourse h ->{}"+resultList);
	}
	
	@Test
	void jpql_where() {
		TypedQuery<HrushiCourse> query = 
				entityManager.createNamedQuery("query_get_hrushi_thakur", HrushiCourse.class);
		
		List<HrushiCourse> resultList = query.getResultList();
		System.out.println("query_get_hrushi_thakur ->{}"+resultList);
	}
	
	

	@Test
	void jpql_courses_with_atleast_student() {
		TypedQuery<HrushiCourse> query = 
				entityManager.createQuery(
						"select h from HrushiCourse h where size(h.hrushi_students) >=2",
						HrushiCourse.class);
		
		List<HrushiCourse> resultList = query.getResultList();
		System.out.println("Results ->{}"+resultList);
	}
	
	@Test
	void jpql_courses_ordered_by_student() {
		TypedQuery<HrushiCourse> query = 
				entityManager.createQuery(
						"select h from HrushiCourse h order by size(h.hrushi_students)",
						HrushiCourse.class);
		
		List<HrushiCourse> resultList = query.getResultList();
		System.out.println("Results ->{}"+resultList);
	}
	
	@Test
	void jpql_student_with_passport_with_certain_pattern() {
		TypedQuery<HrushiStudent> query = 
				entityManager.createQuery(
						"select h from HrushiStudent h where h.passport.number like '%100005%'",
						HrushiStudent.class);
		
		List<HrushiStudent> resultList = query.getResultList();
		System.out.println("Results ->{}"+resultList);
	}
	
	@Test
	public void join() {
		Query query = entityManager.createQuery("select c, s from HrushiCourse c JOIN c.hrushi_students s");
		List<Object[]> resultList = query.getResultList();
		System.out.println("Results Size ->{}"+resultList.size());
		for(Object[] result:resultList) {
			System.out.println("Course{} Student{}"+ result[0]+"  "+result[1]);
		}
	}
	
	@Test
	public void left_join() {
		Query query = entityManager.createQuery("select c, s from HrushiCourse c LEFT JOIN c.hrushi_students s");
		List<Object[]> resultList = query.getResultList();
		System.out.println("Results Size ->{}"+resultList.size());
		for(Object[] result:resultList) {
			System.out.println("Course{} Student{}"+ result[0]+"  "+result[1]);
		}
	}
	
	@Test
	public void cross_join() {
		Query query = entityManager.createQuery("select c, s from HrushiCourse c, HrushiStudent s");
		List<Object[]> resultList = query.getResultList();
		System.out.println("Results Size ->{}"+resultList.size());
		for(Object[] result:resultList) {
			System.out.println("Course{} Student{}"+ result[0]+"  "+result[1]);
		}
	}
}
