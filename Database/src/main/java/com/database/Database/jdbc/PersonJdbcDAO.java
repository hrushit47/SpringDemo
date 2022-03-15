package com.database.Database.jdbc;
import org.springframework.stereotype.Repository;
import com.database.Database.entity.Hrushikesh_Person;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

@Repository
public class PersonJdbcDAO {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	class PersonRowMapper implements RowMapper<Hrushikesh_Person>{
		@Override
		public Hrushikesh_Person mapRow(ResultSet rs, int rowNum) throws SQLException {
			Hrushikesh_Person person = new Hrushikesh_Person();
			person.setId(rs.getInt("id"));
			person.setName(rs.getString("name"));
			person.setLocation(rs.getString("location"));
			person.setBirthdate(rs.getTimestamp("birth_date"));
			return person;
		}
		
	}
	
	public List<Hrushikesh_Person> findAll() {
		return jdbcTemplate.query("select * from Hrushikesh_Person", new PersonRowMapper());
	}
	
	
	/*
	public List<Hrushikesh_person> findAll() {
		return jdbcTemplate.query("select * from Hrushikesh_person",
				new BeanPropertyRowMapper<Hrushikesh_person>(Hrushikesh_person.class));
	}
	*/
	
	public Hrushikesh_Person findById(int id){
		return jdbcTemplate.queryForObject
				("select * from Hrushikesh_Person where id=?",new Object[]{id},
				new BeanPropertyRowMapper<Hrushikesh_Person>(Hrushikesh_Person.class));
	}
		public Hrushikesh_Person findByName(String name){
			return jdbcTemplate.queryForObject
					("select * from Hrushikesh_Person where name=?",new Object[]{name},
					new BeanPropertyRowMapper<Hrushikesh_Person>(Hrushikesh_Person.class));
	}
		
		public int deleteById(int id){
			return jdbcTemplate.update
					("Delete from Hrushikesh_Person where id=?",new Object[]{id});
			
		}
		
		public int insert(Hrushikesh_Person hrushikesh_person) {
			return jdbcTemplate.update(
					"insert into Hrushikesh_Person (id, name, location, birth_date) "
					+ "values(?,  ?, ?, ?)",
					new Object[] {
							hrushikesh_person.getId(), hrushikesh_person.getName(), hrushikesh_person.getLocation(),
							new Timestamp(hrushikesh_person.getBirthdate().getTime()) });
		}
		
		public int update(Hrushikesh_Person hrushikesh_person) {
			return jdbcTemplate.update(
					"update Hrushikesh_Person " 
					+ " set name = ?, location = ?, birth_date = ? " 
					+ " where id = ?",
					new Object[] {
							hrushikesh_person.getName(), hrushikesh_person.getLocation(), new Timestamp(hrushikesh_person.getBirthdate().getTime()),
							hrushikesh_person.getId() });
		}
		
		
	
	


}