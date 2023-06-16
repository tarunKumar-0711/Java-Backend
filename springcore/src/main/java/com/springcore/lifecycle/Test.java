package com.springcore.lifecycle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		ApplicationContext context = new FileSystemXmlApplicationContext("xmlConfig/configLifecycle.xml");
		Samosa s = (Samosa) context.getBean("s1");
		System.out.println(s);
		((FileSystemXmlApplicationContext) context).close();
	}
}
