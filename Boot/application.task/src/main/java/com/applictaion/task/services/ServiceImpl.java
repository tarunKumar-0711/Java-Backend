package com.applictaion.task.services;

import java.time.LocalTime;
import java.util.Random;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.applictaion.task.customException.EmployeeException;
import com.applictaion.task.customException.PasswordException;
import com.applictaion.task.dto.AddEmployee;
import com.applictaion.task.dto.UpdateEmployee;
import com.applictaion.task.entities.Employee;
import com.applictaion.task.repo.EmployeeRespository;

public class ServiceImpl implements ServiceInterface {

	@Autowired
	EmployeeRespository employeeRespository;
	
	@Autowired
	private EmailSender emailSender;

	private static final Random random = new Random();
	private static final int MAX_OTP_VALUE = 10000;

	@Override
	public void addEmployee(AddEmployee emp) {
		if(employeeRespository.findById(emp.getEmail())!=null)
			throw new EmployeeException("Already Exists");
		Employee emp1 = new Employee();
		BeanUtils.copyProperties(emp, emp1);
		employeeRespository.save(emp1);

	}

	@Override
	public void reset(String email) {

		Employee emp = employeeRespository.findById(email)
				.orElseThrow(() -> new EmployeeException("No employee present"));
		
		Integer otp = random.nextInt(MAX_OTP_VALUE);
		
		String body = "Hi, \n\n Your otp for resetting the password is "+otp+" .";
		emailSender.sendEmail(emp.getEmail(),"Otp to reset password", body);
		LocalTime time = LocalTime.now();
		emp.setLocal_time(time);
		emp.setOtp(otp);
		employeeRespository.save(emp);
		
	}

	@Override
	public void updateEmployee(UpdateEmployee emp) {
		
		//LocalTime time = LocalTime.now();
		Employee emp1 ;
		
		emp1 = employeeRespository.findById(emp.getEmail())
				.orElseThrow(() -> new EmployeeException("No employee present"));
		
		if(! (emp1.getOtp().equals(emp.getOtp())) ) {
			
			throw new PasswordException("Invalid otp");
		}
		
		
		emp1.setOtp(null);
		emp1.setPassword(emp.getPassword());
		
	}

}
