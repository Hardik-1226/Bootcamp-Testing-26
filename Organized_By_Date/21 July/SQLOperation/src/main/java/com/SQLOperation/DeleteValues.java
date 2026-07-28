package com.SQLOperation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteValues {

	private Connection connection;

	public void establishDatabaseConnection() throws ClassNotFoundException, SQLException {

		String url = "jdbc:mysql://localhost:3306/seleniumautomation";
		String username = "root";
		String password = "Hardik@123";

		// Load MySQL JDBC Driver
		Class.forName("com.mysql.cj.jdbc.Driver");

		System.out.println("Connecting to Database...");

		connection = DriverManager.getConnection(url, username, password);

		if (connection != null) {
			System.out.println("Database Connected Successfully!");
		}
	}

	public void deleteData() throws SQLException {

		Statement stmt = connection.createStatement();

		String query = "DELETE FROM book_detl WHERE book_no='AI001'";

		int rows = stmt.executeUpdate(query);

		if (rows > 0) {
			System.out.println("Record Deleted Successfully!");
		} else {
			System.out.println("No Record Found!");
		}

		stmt.close();
		connection.close();
	}

	public static void main(String[] args) throws Exception {

		DeleteValues obj = new DeleteValues();

		obj.establishDatabaseConnection();

		obj.deleteData();
	}
}