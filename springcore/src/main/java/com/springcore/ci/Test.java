package com.springcore.ci;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("/xmlConfig/configci.xml");
		ConstructorI c = (ConstructorI) context.getBean("ci");
		System.out.println(c);
		((ClassPathXmlApplicationContext) context).close();
	}

}
