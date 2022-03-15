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
class NativeQueryTest {
	
	@Autowired
	EntityManager entityManager;

	@Test
	void native_queries_basic() {
		Query query = entityManager.createNativeQuery("SELECT * FROM hrushi_course",HrushiCourse.class);
		List resultList = query.getResultList();
		System.out.println("SELECT * FROM HrushiCourse ->{}"+resultList);
	}
	
	@Test
	void native_queries_with_parameter() {
		Query query = entityManager.createNativeQuery("SELECT * FROM hrushi_course where id= ?",HrushiCourse.class);
		query.setParameter(1,101);
		List resultList = query.getResultList();
		System.out.println("SELECT * FROM HrushiCourse where id=? ->"+resultList);
	}
}
