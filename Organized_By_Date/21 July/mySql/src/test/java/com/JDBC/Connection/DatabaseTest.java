package com.JDBC.Connection;

import java.sql.*;

import org.testng.annotations.*;

public class DatabaseTest {

	
	@Test
	
	public void establishDatabaseConnection() throws ClassNotFoundException, SQLException {
		
		// 1. Define connection parameters
		String databaseURL = "jdbc:mysql://localhost:3306/SeleniumAutomation";
		String user = "root";
		String password = "2275";
		
		// 2. Load the MySQL JDBC driver and establish connection
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(databaseURL, user, password);
		Statement stmt = con.createStatement();
		
		// 3. Execute a query
		
		String query = "SELECT * FROM SeleniumAutomation.book_detl;";
		ResultSet rs = stmt.executeQuery(query);
		
		// 4. Process the results
		
		while(rs.next()) {
			String auth = rs.getString("author");
			String tit = rs.getString("title");
			System.out.println("author: " + auth + ", title: " + tit);
		}
		
		// 5. 
		
	}
	
}
