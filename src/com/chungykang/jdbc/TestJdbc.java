package com.chungykang.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String jdbcUrl = "jdbc:mysql://localhost:8889/table_name?useSSL=false";
		String user = "user";
		String pass = "password";
		
		try {
			System.out.println("Connection to database: " + jdbcUrl);
			
			Connection myConn = DriverManager.getConnection(jdbcUrl, user, pass);
			
			System.out.println("Connection Succesful!");
			System.out.println(myConn);
			
		} catch(Exception exc) {
			exc.printStackTrace();
		}
	}

}
