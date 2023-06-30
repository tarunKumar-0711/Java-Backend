package com.bootValidationCrud.service;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.bootValidationCrud.entity.Student;

public class StudentRowMapper implements RowMapper<Student> {

    @Override
    public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
        Student student = new Student();
        student.setId(rs.getInt("id"));
        student.setName(rs.getString("name"));
        student.setSubject(rs.getString("subject"));
        student.setState(rs.getString("state"));
        student.setRollNo(rs.getString("roll_no"));
        student.setEmail(rs.getString("email"));
        student.setSports(rs.getString("sports"));
        //System.out.println(student.getId());
        return student;
    }
}