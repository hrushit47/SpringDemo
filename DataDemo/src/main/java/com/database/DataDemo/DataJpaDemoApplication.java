
package com.database.DataDemo;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class DataJpaDemoApplication implements CommandLineRunner {
	
	
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	PersonJpaRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(DataJpaDemoApplication.class, args);
				
	}

	@Override
	public void run(String... args) throws Exception {
		
		System.out.println("All Users -> {} " +repository.findAll());
		
		/*
		System.out.println("User 1001 -> {} " +repository.findById(1));
		
		
		System.out.println("Updating into hrushikesh_person -> {} " 
				+repository.update(new HrushikeshPerson(3,"Kunal", "Hadapsar", new Date())));	
		
		System.out.println("Inserting into hrushikesh_person -> {} " 
				+repository.insert(new HrushikeshPerson("Atharva", "Yeola", new Date())));
		
		
		System.out.println("Deleting User-> {} ");
		repository.deleteById(7);
		
		
		
		
		
		//	logger.info("User id 1001 -> {} ",dao.findById(1001));
   		//	logger.info("All Users -> {} ",dao.findAll());
        //	logger.info("User name Hrushi -> {} ",dao.findByName("Hrushi"));
		//logger.info("Deleting id 1003 -> {} ",dao.deleteById(1003));
		//	logger.info("Inserting 1003 -> {}", dao.insert(new Hrushikesh_person(1003, "Kunal", "Hadapsar", new Date())));
		//	logger.info("Update 1003 -> {}", dao.update(new Hrushikesh_person(1003, "Devansh", "Bavdhan", new Date())));
									
		*/
	}

}
	
