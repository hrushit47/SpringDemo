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
	
}
