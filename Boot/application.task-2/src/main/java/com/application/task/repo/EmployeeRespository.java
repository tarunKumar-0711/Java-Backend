package com.application.task.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.application.task.entities.Employee;

@Repository
public interface EmployeeRespository extends JpaRepository<Employee, String>{
	
	
}
