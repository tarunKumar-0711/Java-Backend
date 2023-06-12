package com.JDBCLearning;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class InsertJDBC {
	public static void main(String[] args) throws ClassNotFoundException{
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con =null;
		
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1","tarun","Software@123");
			String q = "insert into Students(RollNo,FirstName) values(?,?)";
			
			PreparedStatement pstmt= con.prepareStatement(q);
			pstmt.setString(1,"34");
			pstmt.setString(2,"Tarun Kumar");
			pstmt.executeUpdate();
			
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
