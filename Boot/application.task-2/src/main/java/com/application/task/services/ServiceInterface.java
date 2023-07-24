package com.application.task.services;

import com.application.task.dto.AddEmployee;
import com.application.task.dto.UpdateEmployee;

public interface ServiceInterface {

	public void addEmployee(AddEmployee emp);

	public void reset(String email);

	public void updateEmployee(UpdateEmployee emp);
}
