package com.hibernatetut.ProjectWithMaven;

import java.lang.module.Configuration;

import javax.naming.ConfigurationException;


import com.mysql.cj.xdevapi.SessionFactory; 

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        
        SessionFactory factory = cfg.buildSessionFactory();
        
        System.out.println(factory);
        System.out.println(factory.isClosed());
    }
}
