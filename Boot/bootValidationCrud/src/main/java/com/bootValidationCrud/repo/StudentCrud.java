package com.bootValidationCrud.repo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.bootValidationCrud.entity.Student;
import com.bootValidationCrud.service.StudentRowMapper;

@Component
public class StudentCrud {

	private final JdbcTemplate jdbcTemplate;

	public StudentCrud(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<Student> findStudents(Integer id,String name, String subject, String state, String rollNo, String email,
			String sports) {
		StringBuilder queryBuilder = new StringBuilder("SELECT * FROM student WHERE");
		List<Object> queryParams = new ArrayList<>();
		boolean flag =false;
		
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
		
		if (name != null && !name.isEmpty()) {
			if(!flag) {
				flag=true;
				queryBuilder.append(" name = '" + name + "'");
			}
			else {
				queryBuilder.append(" AND name = '" + name + "'");
			}
			queryParams.add(name);
		}

		if (subject != null && !subject.isEmpty()) {
			if(!flag) {
				flag=true;
				queryBuilder.append(" subject = '" + subject + "'");
			}
			else {
				queryBuilder.append(" AND subject = '" + subject + "'");
			}
			queryParams.add(subject);
		}

		if (state != null && !state.isEmpty()) {
			if(!flag) {
				flag=true;
				queryBuilder.append(" state = '" + state + "'");
			}
			else {
				queryBuilder.append(" AND state = '" + state + "'");
			}
			queryParams.add(state);
		}

		if (rollNo != null && !rollNo.isEmpty()) {
			if(!flag) {
				flag=true;
				queryBuilder.append(" rollNo = '" + rollNo + "'");
			}
			else {
				queryBuilder.append(" AND name = '" + rollNo + "'");
			}
			queryParams.add(rollNo);
		}

		if (email != null && !email.isEmpty()) {
			if(!flag) {
				flag=true;
				queryBuilder.append(" email = '" + email + "'");
			}
			else {
				queryBuilder.append(" AND email = '" + email + "'");
			}
			queryParams.add(email);
		}

		if (sports != null && !sports.isEmpty()) {
			if(!flag) {
				flag=true;
				queryBuilder.append(" sports = '" + sports + "'");
			}
			else {
				queryBuilder.append(" AND sports = '" + sports + "'");
			}
			queryParams.add(sports);
		}
		
		//+System.out.println(queryBuilder);
		return jdbcTemplate.query(queryBuilder.toString(), new StudentRowMapper());//, queryParams.toArray());
		//return jdbcTemplate.query(queryBuilder.toString(), queryParams.toArray(), new StudentRowMapper());


	}
}