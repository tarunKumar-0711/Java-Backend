package com.application.task.services;

import java.time.LocalTime;
import java.util.Optional;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.task.customException.EmployeeException;
import com.application.task.customException.PasswordException;
import com.application.task.dto.AddEmployee;
import com.application.task.dto.UpdateEmployee;
import com.application.task.entities.Employee;
import com.application.task.repo.EmployeeRespository;

@Service
public class ServiceImpl implements ServiceInterface {

	@Autowired
	EmployeeRespository employeeRespository;

	static Logger logger = LogManager.getLogger(ServiceImpl.class);

	@Autowired
	private EmailSender emailSender;

	private static final Random random = new Random();
	private static final int MAX_OTP_VALUE = 10000;

	@Override
	public void addEmployee(AddEmployee emp) {
		logger.info("Inside addEmployee method of ServiceImpl class");

		if (!emp.getConfirmPassword().equals(emp.getPassword())) {
			logger.warn("Password did not match");
			throw new PasswordException("Password does not match");
		}

		Optional<Employee> emp1 = employeeRespository.findById(emp.getEmail());
		if (!emp1.isEmpty()) {
			logger.error("Already present");
			throw new EmployeeException("Already Present");
		}

		Employee emp2 = new Employee();
		BeanUtils.copyProperties(emp, emp2);
		employeeRespository.save(emp2);
	}

	@Override
	public void reset(String email) {

		logger.info("Inside otp generation method(reset) of ServiceImpl class");

		Employee emp = employeeRespository.findById(email)
				.orElseThrow(() -> new EmployeeException("No employee present"));

		Integer otp = random.nextInt(MAX_OTP_VALUE);

		String body = "Hi, \n\n Your otp for resetting the password is " + otp + " .";
		emailSender.sendEmail(emp.getEmail(), "Otp to reset password", body);
		LocalTime time = LocalTime.now();
		emp.setLocal_time(time);
		emp.setOtp(otp);
		employeeRespository.save(emp);

	}

	@Override
	public void updateEmployee(UpdateEmployee emp) {

		logger.info("Inside updateEmployee method of ServiceImpl class");

		// LocalTime time = LocalTime.now();
		Employee emp1;

		emp1 = employeeRespository.findById(emp.getEmail())
				.orElseThrow(() -> new EmployeeException("No employee present"));

		if (!(emp1.getOtp().equals(emp.getOtp()))) {

			throw new PasswordException("Invalid otp");
		}

		emp1.setOtp(null);
		emp1.setLocal_time(null);
		emp1.setPassword(emp.getPassword());
		employeeRespository.save(emp1);

	}

}
