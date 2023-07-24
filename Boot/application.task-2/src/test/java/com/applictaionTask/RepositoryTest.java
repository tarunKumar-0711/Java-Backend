package com.applictaionTask;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import com.application.task.entities.Employee;
import com.application.task.repo.EmployeeRespository;

@DataJpaTest
@SpringBootTest(classes = EmployeeRespository.class)
public class RepositoryTest {
	
	 @Autowired
	  private EmployeeRespository employeeRepository;

	    @Test
	    public void testSaveAndFindById() {
	        // Create an Employee entity
	        Employee employee = new Employee();
	        employee.setEmail("test@example.com");
	        employee.setName("John Doe");

	        // Save the entity using the repository
	        Employee savedEmployee = employeeRepository.save(employee);

	        // Fetch the entity by its email using the repository
	        Employee foundEmployee = employeeRepository.findById("test@example.com").orElse(null);

	        // Assert that the saved and found employees have the same email and name
	        assertNotNull(foundEmployee);
	        assertEquals(savedEmployee.getEmail(), foundEmployee.getEmail());
	        assertEquals(savedEmployee.getName(), foundEmployee.getName());
	    }
}
