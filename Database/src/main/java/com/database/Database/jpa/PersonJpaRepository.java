package com.database.Database.jpa;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;
import com.database.Database.entity.Hrushikesh_Person;


@Repository
@Transactional
public class PersonJpaRepository {
	
	@PersistenceContext
	EntityManager entityManager;
	
	public Hrushikesh_Person findById(int id) {
		return entityManager.find(Hrushikesh_Person.class,id);
	}

}
