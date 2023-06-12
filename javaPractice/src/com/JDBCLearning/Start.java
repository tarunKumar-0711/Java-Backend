package com.JDBCLearning;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Start {
	public static void main(String[] args) throws SQLException{

		Connection con = null;
		try{
	
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			
			String url="jdbc:mysql://localhost:3306/db1";
			String userName="tarun";
			String pswrd="Software@123";
		
			con = DriverManager.getConnection(url,userName,pswrd);
			
	
			if(con.isClosed()){
				System.out.println("Connection is Closed");
			}
			
			else{
				System.out.println("Connection Created.....");
			}
			
			
		}
		
		catch (Exception e){
			e.printStackTrace();
		}
		
		finally{
			if(con!=null)
				con.close();
		}
		
	}
}
