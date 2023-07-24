package com.applictaionTask.mock;

import org.springframework.boot.test.context.TestComponent;

import com.application.task.dto.UpdateEmployee;

@TestComponent
public class UpdateEmployeeMock {
	
	public UpdateEmployee mockUpdateEmployee() {
		UpdateEmployee updateEmployee = new UpdateEmployee();
		updateEmployee.setConfirmPassword("trfuj");
		updateEmployee.setEmail("tvyububyt@ahj.com");
		updateEmployee.setPassword("trfuj");
		updateEmployee.setOtp(7896);
		
		return updateEmployee;
	}
}
