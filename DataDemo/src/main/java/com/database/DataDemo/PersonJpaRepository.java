package com.database.DataDemo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

import com.database.DataDemo.PersonJdbcDAO.PersonRowMapper;

@Repository
@Transactional
public class PersonJpaRepository {
	@PersistenceContext
	EntityManager entityManager;
	
	public List<HrushikeshPerson> findAll() {
		TypedQuery<HrushikeshPerson> namedQuery = entityManager.createNamedQuery("find_all_persons",HrushikeshPerson.class);
		return namedQuery.getResultList();
	}
		
	public HrushikeshPerson findById(int id) {
		return entityManager.find(HrushikeshPerson.class, id); 
	}
		public HrushikeshPerson update(HrushikeshPerson hrushikeshperson) {
			return entityManager.merge(hrushikeshperson);
	
	}
		public HrushikeshPerson insert(HrushikeshPerson hrushikeshperson) {
			return entityManager.merge(hrushikeshperson);
		}
		
		public void deleteById(int id) {
			HrushikeshPerson hrushikeshperson = findById(id);
			entityManager.remove(hrushikeshperson);
		}
	/*
	
	}
	
	public HrushikeshPerson update(HrushikeshPerson hrushikeshperson) {
		return entityManager.merge(hrushikeshperson);
	}
	
	
	public List<Hrushikesh_Person> findAll() {
		TypedQuery<Hrushikesh_Person> namedQuery = entityManager.createNamedQuery("select * from Hrushikesh_Person", Hrushikesh_Person.class);
		return namedQuery.getResultList();
	}
	*/
	
	}
	
