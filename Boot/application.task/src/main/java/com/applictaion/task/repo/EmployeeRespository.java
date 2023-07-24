package com.applictaion.task.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.applictaion.task.entities.Employee;

public interface EmployeeRespository extends JpaRepository<Employee, String>{

}
