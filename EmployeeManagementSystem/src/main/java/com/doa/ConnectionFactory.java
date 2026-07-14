package com.doa;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	
	private static final String DB_URL ="jdbc:mysql://localhost:3306/test";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "";
	
	public static Connection getConnection() {
		
		Connection connection = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return connection;
	}
	
	public static void closeConnection(AutoCloseable a) {
		
		try {
			if(a!=null) {
				a.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
