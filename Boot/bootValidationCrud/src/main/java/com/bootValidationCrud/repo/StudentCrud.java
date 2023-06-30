package com.bootValidationCrud.repo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.bootValidationCrud.customException.EmptyListException;
import com.bootValidationCrud.entity.Student;
import com.bootValidationCrud.service.StudentRowMapper;

@Component
public class StudentCrud {

	private final JdbcTemplate jdbcTemplate;

	public StudentCrud(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<Student> findStudents(Student student) {
		StringBuilder queryBuilder = new StringBuilder("SELECT * FROM student ");
		List<Object> queryParams = new ArrayList<>();
		boolean flag =false;
		//System.out.println(student.getAddress().getArea());
		
//		if (id != null) {
//			if(!flag) {
//				flag=true;
//				queryBuilder.append(" id = '" + id + "'");
//			}
//			else {
//				queryBuilder.append(" AND name = '" + name + "'");
//			}
//			queryParams.add(name);
//		}
		
		if (student.getName() != null && !student.getName().isEmpty()) {
			if(!flag) {
				flag=true;
				queryBuilder.append(" WHERE name = '" + student.getName() + "'");
			}
			else {
				queryBuilder.append(" AND name = '" + student.getName() + "'");
			}
			queryParams.add(student.getName());
		}

		if (student.getSubject() != null && !student.getSubject().isEmpty()) {
			if(!flag) {
				flag=true;
				queryBuilder.append(" WHERE subject = '" + student.getSubject() + "'");
			}
			else {
				queryBuilder.append(" AND subject = '" + student.getSubject() + "'");
			}
			queryParams.add(student.getSubject());
		}

		if (student.getState() != null && !student.getState().isEmpty()) {
			if(!flag) {
				flag=true;
				queryBuilder.append(" WHERE state = '" + student.getState() + "'");
			}
			else {
				queryBuilder.append(" AND state = '" + student.getState() + "'");
			}
			queryParams.add(student.getState());
		}

		if (student.getRollNo() != null && !student.getRollNo().isEmpty()) {
			if(!flag) {
				flag=true;
				queryBuilder.append(" WHERE roll_no = '" + student.getRollNo() + "'");
			}
			else {
				queryBuilder.append(" AND roll_no = '" + student.getRollNo() + "'");
			}
			queryParams.add(student.getRollNo());
		}

		if (student.getEmail() != null && !student.getEmail().isEmpty()) {
			if(!flag) {
				flag=true;
				queryBuilder.append(" WHERE email = '" + student.getEmail()+ "'");
			}
			else {
				queryBuilder.append(" AND email = '" + student.getEmail() + "'");
			}
			queryParams.add(student.getEmail());
		}

		if (student.getSports() != null && !student.getSports().isEmpty()) {
			if(!flag) {
				flag=true;
				queryBuilder.append(" WHERE sports = '" + student.getSports() + "'");
			}
			else {
				queryBuilder.append(" AND sports = '" + student.getSports() + "'");
			}
			queryParams.add(student.getSports());
		}
		
		System.out.println(queryBuilder);
		List<Student> lStudents = jdbcTemplate.query(queryBuilder.toString(), new StudentRowMapper());
		
		if(lStudents!=null && lStudents.isEmpty()) {
			throw new EmptyListException("607","No such student exists");
		}
		
		return lStudents;
		
		//, queryParams.toArray());
		//return jdbcTemplate.query(queryBuilder.toString(), queryParams.toArray(), new StudentRowMapper());


	}
}