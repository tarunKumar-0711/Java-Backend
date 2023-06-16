package com.springcore.collection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	// TODO Auto-generated method stub
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/springcore/collection/configCollection.xml");
		Emp employee = (Emp)context.getBean("Emp");
		System.out.println(employee);
		System.out.println(employee.getName());
		System.out.println(employee.getAddress());
		System.out.println(employee.getCourse());
		System.out.println(employee.getPhone());
		
		((ClassPathXmlApplicationContext)context).close();

	}

}
