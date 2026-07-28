package com.SQLOperation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertValues {

    private Connection connection;

    public void establishDatabaseConnection() throws ClassNotFoundException, SQLException {

        // Database Connection Details
        String url = "jdbc:mysql://localhost:3306/seleniumautomation";
        String username = "root";
        String password = "Hardik@123";

        // Load MySQL JDBC Driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        System.out.println("Connecting to Database...");

        connection = DriverManager.getConnection(url, username, password);

        if (connection != null) {
            System.out.println("Database Connected Successfully!");
        } else {
            System.out.println("Connection Failed!");
        }
    }

    public void insertData() throws SQLException {

        Statement stmt = connection.createStatement();

        String query = "INSERT INTO book_detl (book_no, title, sub_code, author, publisher, status, yop, price) "
                + "VALUES ('AI001', 'PostmanAI', 'API', 'Hardik', 'OpenAI', 'S', '2026', 900)";

        int rows = stmt.executeUpdate(query);

        if (rows > 0) {
            System.out.println("Record Inserted Successfully!");
        } else {
            System.out.println("Record Not Inserted!");
        }

        stmt.close();
    }

    public static void main(String[] args) throws Exception {

        InsertValues obj = new InsertValues();

        obj.establishDatabaseConnection();

        obj.insertData();
    }
}