package com.applictaionTask.mock;

import org.springframework.boot.test.context.TestComponent;

import com.application.task.dto.AddEmployee;

@TestComponent
public class AddEmployeeRequestMock {

	public AddEmployee mockAddEmployee() {

		AddEmployee emp = new AddEmployee();
		emp.setConfirmPassword("return");
		emp.setEmail("gdvgkuewv@bcbeiw.com");
		emp.setPassword("return");
		emp.setName("Tarun");
		return emp;
	}

}
