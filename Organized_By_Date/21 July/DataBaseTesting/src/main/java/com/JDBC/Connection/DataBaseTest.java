package com.JDBC.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseTest {

    public void testDatabaseConnection() throws SQLException, ClassNotFoundException {

        // Database Connection Parameters
        String url = "jdbc:mysql://localhost:3306/seleniumautomation";
        String username = "root";
        String password = "Hardik@123";

        // Load MySQL JDBC Driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        // Establish Database Connection
        Connection con = DriverManager.getConnection(url, username, password);

        // Create Statement
        Statement stmt = con.createStatement();

        // Execute Query
        String query = "SELECT * FROM student";
        ResultSet rs = stmt.executeQuery(query);

        // Process the Results
        while (rs.next()) {
        	String auth = rs.getString("author");
        	String tit = rs.getString("title");

            System.out.println(rs.getString("auth") + " - " + rs.getString("tit"));
        
        }

        // Close the Connection
        rs.close();
        stmt.close();
        con.close();

        System.out.println("Database Connection Closed.");
    }
}