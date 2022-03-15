package com.database.DataDemo;

import org.springframework.stereotype.Repository;
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
	
	class PersonRowMapper implements RowMapper<HrushikeshPerson>{
		@Override
		public HrushikeshPerson mapRow(ResultSet rs, int rowNum) throws SQLException {
			HrushikeshPerson person = new HrushikeshPerson();
			person.setId(rs.getInt("id"));
			person.setName(rs.getString("name"));
			person.setLocation(rs.getString("location"));
			person.setBirthdate(rs.getTimestamp("birth_date"));
			return person;
		}
		
	}
	
	public List<HrushikeshPerson> findAll() {
		return jdbcTemplate.query("select * from hrushikesh_person", new PersonRowMapper());
	}
	
	
	/*
	public List<Hrushikesh_person> findAll() {
		return jdbcTemplate.query("select * from Hrushikesh_person",
				new BeanPropertyRowMapper<Hrushikesh_person>(Hrushikesh_person.class));
	}
	*/
	
	public HrushikeshPerson findById(int id){
		return jdbcTemplate.queryForObject
				("select * from hrushikesh_person where id=?",new Object[]{id},
				new BeanPropertyRowMapper<HrushikeshPerson>(HrushikeshPerson.class));
	}
		public HrushikeshPerson findByName(String name){
			return jdbcTemplate.queryForObject
					("select * from hrushikesh_person where name=?",new Object[]{name},
					new BeanPropertyRowMapper<HrushikeshPerson>(HrushikeshPerson.class));
	}
		
		public int deleteById(int id){
			return jdbcTemplate.update
					("Delete from hrushikesh_person where id=?",new Object[]{id});
			
		}
		
		public int insert(HrushikeshPerson hrushikesh_person) {
			return jdbcTemplate.update(
					"insert into hrushikesh_person (id, name, location, birth_date) "
					+ "values(?,  ?, ?, ?)",
					new Object[] {
							hrushikesh_person.getId(), hrushikesh_person.getName(), hrushikesh_person.getLocation(),
							new Timestamp(hrushikesh_person.getBirthdate().getTime()) });
		}
		
		public int update(HrushikeshPerson hrushikesh_person) {
			return jdbcTemplate.update(
					"update hrushikesh_person " 
					+ " set name = ?, location = ?, birth_date = ? " 
					+ " where id = ?",
					new Object[] {
							hrushikesh_person.getName(), hrushikesh_person.getLocation(), new Timestamp(hrushikesh_person.getBirthdate().getTime()),
							hrushikesh_person.getId() });
		}
		
		
	
	


}