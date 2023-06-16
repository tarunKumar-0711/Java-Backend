package com.springcore;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
	//private static ApplicationContext context;
    public static void main( String[] args )
    {
        
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        Student student = (Student) context.getBean("student");
        System.out.println(student);
        
        Student student1 = (Student) context.getBean("student1");
        System.out.println(student1);
        Student student2 = (Student) context.getBean("student2");
        System.out.println(student2);
        
        ((ClassPathXmlApplicationContext) context).close();
        //((ConfigurableApplicationContext)context).close();
   
    }
    
}
