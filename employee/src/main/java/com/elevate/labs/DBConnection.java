package com.elevate.labs;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class DBConnection {

    String url = "jdbc:mysql://localhost:3306/Employees";
    String user = "root";
    String password = "root";

    public Connection getConnection() {

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection(url, user, password);
            return connection;

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Driver not found...");
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Connection not Established..");
            return null;
        }
    }
}
