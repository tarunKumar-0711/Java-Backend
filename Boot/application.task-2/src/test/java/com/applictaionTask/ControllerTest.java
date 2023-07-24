package com.applictaionTask;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.application.task.controller.MainController;
import com.application.task.dto.AddEmployee;
import com.application.task.dto.UpdateEmployee;
import com.application.task.services.ServiceInterface;
import com.applictaionTask.mock.AddEmployeeRequestMock;
import com.applictaionTask.mock.ResetMock;
import com.applictaionTask.mock.UpdateEmployeeMock;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest(classes = MainController.class)
class ControllerTest {

	@Autowired
	MainController mainController;

//	@Autowired
//	private WebApplicationContext webApplicationContext;

	// not allowed but go through @Mock
//	@Spy
	@InjectMocks
	AddEmployeeRequestMock mock;
	
	@InjectMocks
	ResetMock resetMock;
	
	@InjectMocks
	UpdateEmployeeMock updateEmployeeMock;
	
	private MockMvc mockMvc;

	@MockBean
	private ServiceInterface service;

	private ObjectMapper mapper = new ObjectMapper();

	@BeforeEach
	public void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(mainController).build();
//		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	void addEmployeeTest() throws Exception {
		Mockito.doNothing().when(service).addEmployee(any(AddEmployee.class));
		//System.out.println(mock.mockAddEmployee());
		String request = mapper.writeValueAsString(mock.mockAddEmployee());
		
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/application/signUp")
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
				.content(request);
		
		mockMvc.perform(requestBuilder).andExpect(status().isOk());
	}
	
	@Test
	void  resetPasswordTest() throws Exception{
		
		//What to do
		Mockito.doNothing().when(service).reset(any(String.class));
		
		//what to hit the api
		String req = mapper.writeValueAsString(resetMock.mockResetApi());
		System.out.println(req);
		
		
		String email = "jqsx3t5in81@kzccv.com";
		//Hitting the api with request
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/application/forgotPassword/{email}", email)
				.contentType(MediaType.APPLICATION_JSON_VALUE).accept(MediaType.APPLICATION_JSON_VALUE)
				.content(req);
		
		mockMvc.perform(requestBuilder).andExpect(status().isOk());
		
		
	}
	
//	@Test
//	void resetPasswordforException() {
//		
//	}
	
	@Test
	void updatePasswordTest() throws Exception{
		Mockito.doNothing().when(service).updateEmployee(any(UpdateEmployee.class));
		
		String request = mapper.writeValueAsString(updateEmployeeMock.mockUpdateEmployee());
		
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/application/updatePassword")
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
				.content(request);
		
		mockMvc.perform(requestBuilder).andExpect(status().isOk());
	}
}
