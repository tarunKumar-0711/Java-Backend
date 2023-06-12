package com.JDBCLearning;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


public class createTableJDBC {
	public static void main(String[] args) {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			
			String url="jdbc:mysql://localhost:3306/db1";
			String userName="tarun";
			String pswrd="Software@123";
		
			con = DriverManager.getConnection(url,userName,pswrd);
			
			String q = "create table Table1(tId int(20) primary key auto_increment, tName varchar(200) not null, tCity varchar (400))";
			Statement stmt = con.createStatement();
			stmt.executeUpdate(q);
			System.out.println("Table created");
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
//		finally{
//			if(con!=null)
//					con.close();
//		}
	}
}
