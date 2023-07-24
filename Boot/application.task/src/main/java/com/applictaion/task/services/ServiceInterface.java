package com.applictaion.task.services;

import org.springframework.stereotype.Service;

import com.applictaion.task.dto.AddEmployee;
import com.applictaion.task.dto.UpdateEmployee;

@Service
public interface ServiceInterface {
	
	public void addEmployee(AddEmployee emp);
	
	public void reset(String email);
	public void updateEmployee(UpdateEmployee emp);
}
