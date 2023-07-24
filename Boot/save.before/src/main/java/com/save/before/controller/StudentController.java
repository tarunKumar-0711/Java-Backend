package com.save.before.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.save.before.component.ScheduledTasks;
import com.save.before.dto.RequiredDto;
import com.save.before.entities.Student;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private ScheduledTasks scheduledTasks;

	@GetMapping("/getPage/{number}/{pageSize}")
	public ResponseEntity<Object> getPage(@PathVariable("number") Integer pageNumber, @PathVariable("pageSize") Integer pageSize) {
		
		
		RequiredDto answer = scheduledTasks.printStudent(pageNumber,pageSize);
		return new ResponseEntity<>(answer, HttpStatus.OK);
	}
}
