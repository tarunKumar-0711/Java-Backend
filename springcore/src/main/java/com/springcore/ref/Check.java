package com.springcore.ref;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Check {

	public static void main(String[] args) {
	
		ApplicationContext context = new ClassPathXmlApplicationContext("com/springcore/ref/configRef.xml");
		A a = (A) context.getBean("aref");
		System.out.println(a.getX());
		System.out.println(a.getObj());
		System.out.println(a);
		
		((ClassPathXmlApplicationContext)context).close();

	}

}
