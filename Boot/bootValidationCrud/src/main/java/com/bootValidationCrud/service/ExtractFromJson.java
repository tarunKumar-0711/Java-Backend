package com.bootValidationCrud.service;

import com.bootValidationCrud.entity.Student;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ExtractFromJson {
	public String extractNameFromJson(String json) {
	    try {
	        ObjectMapper mapper = new ObjectMapper();
	        Student student = mapper.readValue(json, Student.class);
	        return student.getName();
	        
	    } 
	    catch (Exception e) {
	        e.printStackTrace();
	        return null;
	    }
	}

}
