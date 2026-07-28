package com.SQLOperation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateValues {

    private Connection connection;

    public void establishDatabaseConnection() throws ClassNotFoundException, SQLException {

        String url = "jdbc:mysql://localhost:3306/seleniumautomation";
        String username = "root";
        String password = "Hardik@123";

        Class.forName("com.mysql.cj.jdbc.Driver");

        System.out.println("Connecting to Database...");

        connection = DriverManager.getConnection(url, username, password);

        if (connection != null) {
            System.out.println("Database Connected Successfully!");
        }
    }

    public void updateData() throws SQLException {

        Statement stmt = connection.createStatement();

        String query = "UPDATE book_detl SET author='Varshney' WHERE author='Hardik'";

        int rows = stmt.executeUpdate(query);

        if (rows > 0) {
            System.out.println("Record Updated Successfully!");
        } else {
            System.out.println("No Record Found!");
        }

        stmt.close();
    }

    public static void main(String[] args) throws Exception {

        UpdateValues obj = new UpdateValues();

        obj.establishDatabaseConnection();

        obj.updateData();
    }
}