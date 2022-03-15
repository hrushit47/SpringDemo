package com.database.Database;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.database.Database.entity.Hrushikesh_Person;
import com.database.Database.jdbc.PersonJdbcDAO;

@SpringBootApplication
public class JdbcDatabaseApplication implements CommandLineRunner {
	
	
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	
	PersonJdbcDAO dao;

	public static void main(String[] args) {
		SpringApplication.run(JdbcDatabaseApplication.class, args);
				
	}

	@Override
	public void run(String... args) throws Exception {
								//	logger.info("All Users -> {} ",dao.findAll());
									System.out.println("All Users -> {} " +dao.findAll());
									
								//	logger.info("User id 1001 -> {} ",dao.findById(1001));
									System.out.println("User 1001 -> {} " +dao.findById(1001));
									
								//	logger.info("User name Hrushi -> {} ",dao.findByName("Hrushi"));
									System.out.println("User Hrushi -> {} " +dao.findByName("Hrushi"));
									
									//logger.info("Deleting id 1003 -> {} ",dao.deleteById(1003));
									System.out.println("Deleting 1003 -> No of Rows Deleted {} " +dao.deleteById(1003));
									
							    //	logger.info("Inserting 1003 -> {}", dao.insert(new Hrushikesh_person(1003, "Kunal", "Hadapsar", new Date())));
									System.out.println("Inserting into Hrushikesh_person -> {} " 
											+dao.insert(new Hrushikesh_Person(1003, "Kunal", "Hadapsar", new Date())));
									
								//	logger.info("Update 1003 -> {}", dao.update(new Hrushikesh_person(1003, "Devansh", "Bavdhan", new Date())));
									System.out.println("Updating into Hrushikesh_person -> {} " 
											+dao.update(new Hrushikesh_Person(1003, "Devansh", "Bavdhan", new Date())));

									
									
			
	}

}
