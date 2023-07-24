package com.applictaionTask;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.application.task.customException.EmployeeException;
import com.application.task.customException.PasswordException;
import com.application.task.dto.AddEmployee;
import com.application.task.entities.Employee;
import com.application.task.repo.EmployeeRespository;
import com.application.task.services.EmailSender;
import com.application.task.services.ServiceImpl;
import com.application.task.services.ServiceInterface;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest(classes = { ServiceInterface.class, ServiceImpl.class })
class ServiceTest {

	private MockMvc mockMvc;
	private ObjectMapper mapper = new ObjectMapper();

	@Autowired
	ServiceInterface serviceInterface;

	@MockBean
	EmployeeRespository employeeRespositoryMock;

	@MockBean
	PasswordException passwordExceptionMock;

	@MockBean
	EmployeeException employeeExceptionMock;

	@MockBean
	EmailSender emailSenderMock;

	@BeforeEach
	public void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(serviceInterface).build();
	}

	@ParameterizedTest
	@CsvSource({ "valid,active", "invalid,inactive" })
	void addEmployeeTesting(String matchPass, String status) {
		System.out.println(matchPass + " " + status);
		AddEmployee addEmployee = new AddEmployee();
		addEmployee.setName("Tarun");
		addEmployee.setEmail("vyev@yuvewu.com");
		addEmployee.setPassword("return");
		if ("valid".equals(matchPass)) {
			addEmployee.setConfirmPassword("return");
			serviceInterface.addEmployee(addEmployee);
		} else {
			addEmployee.setConfirmPassword("returnsdg");
			try {
				serviceInterface.addEmployee(addEmployee);
			} catch (PasswordException e) {
				System.out.println("hello");
			}
			// Call the method and expect a PasswordException to be thrown
			assertThrows(PasswordException.class, () -> serviceInterface.addEmployee(addEmployee));
		}
		verify(employeeRespositoryMock).save(any(Employee.class));
	}

//	@Test
//	void addEmployeeTest() throws Exception{
//		AddEmployee addEmployee = new AddEmployee();
//		addEmployee.setName("Tarun");
//		addEmployee.setConfirmPassword("return");
//		addEmployee.setPassword("return");
//		addEmployee.setEmail("vyev@yuvewu.com");
//		serviceInterface.addEmployee(addEmployee);		
//		verify(employeeRespositoryMock).save(any(Employee.class));
//	}

//	@Test
//	void addEmployeeTestForPasswordException() throws Exception {
//		 AddEmployee emp = new AddEmployee();
//	        emp.setEmail("test@example.com");
//	        emp.setPassword("password123");
//	        emp.setConfirmPassword("differentPassword");
//	        try {
//				serviceInterface.addEmployee(emp);
//			} catch (PasswordException e) {
//				System.out.println("hello");
//			}
//	        // Call the method and expect a PasswordException to be thrown
//	        assertThrows(PasswordException.class, () -> serviceInterface.addEmployee(emp));
//
//	        // Verify that the employeeRespository save method was never called
//	        verify(employeeRespositoryMock, never()).save(any(Employee.class));
//	}

	@Test
	void testAddEmployee_EmployeeAlreadyExists_EmployeeExceptionThrown() {
		// Test data
		AddEmployee emp = new AddEmployee();
		emp.setEmail("test@example.com");
		emp.setPassword("password123");
		emp.setConfirmPassword("password123");

		// Define the behavior of the mock employeeRespository
		when(employeeRespositoryMock.findById(emp.getEmail())).thenReturn(Optional.of(new Employee()));

		// Call the method and expect an EmployeeException to be thrown
		assertThrows(EmployeeException.class, () -> serviceInterface.addEmployee(emp));

		// Verify that the employeeRespository save method was never called
		verify(employeeRespositoryMock, never()).save(any(Employee.class));
	}

	@Test
	void testReset_EmployeeExists_OTPGeneratedAndSaved() {

		String email = "test@example.com";
		Employee emp = new Employee();
		emp.setEmail(email);

		when(employeeRespositoryMock.findById(email)).thenReturn(Optional.of(emp));

		serviceInterface.reset(email);

		verify(employeeRespositoryMock).save(emp);

		verify(emailSenderMock).sendEmail(email, "Otp to reset password", "Hello");
	}

	@Test
	void testReset_EmployeeDoesNotExist_EmployeeExceptionThrown() {

		String email = "test@example.com";

		when(employeeRespositoryMock.findById(email)).thenReturn(Optional.empty());

		assertThrows(EmployeeException.class, () -> serviceInterface.reset(email));

		verify(employeeRespositoryMock, never()).save(any(Employee.class));

		verify(emailSenderMock, never()).sendEmail(email, "Otp to reset password", "Hello");
	}

//	@Test
//	void resetEmployeeTest() throws Exception{
//		String email ="jqsx3t5in81@kzccv.com";
//		Employee emp = new Employee();
//		emp.setEmail(email);
//		
//		when(employeeRespositoryMock.findById(email))
//			.thenReturn(Optional.of(emp));
//		serviceImpl.reset(email);
//		
//		verify(emailSenderMock).sendEmail(email, "dwffe","vuuy");
//        verify(employeeRespositoryMock).save(emp);
//		
//        assertNotNull(emp.getLocal_time());
//        assertNotNull(emp.getOtp());
//	}
}
