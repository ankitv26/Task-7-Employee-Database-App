package com.elevate.labs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class EmployeeDAO {

    public String addEmployee(Connection connecion, Scanner scanner) throws SQLException {

        try {
            String query = "INSERT INTO employee (name, position, salary) VALUES (?,?,?);";

            System.out.print("Enter Name : ");
            String name = scanner.nextLine();
            System.out.print("Enter Position : ");
            String position = scanner.nextLine();
            System.out.print("Enter Salary : ");
            int salary = scanner.nextInt();
            scanner.nextLine();

            PreparedStatement statement = connecion.prepareStatement(query);
            statement.setString(1, name);
            statement.setString(2, position);
            statement.setInt(3, salary);

            int rowAffected = statement.executeUpdate();
            if (rowAffected > 0) {
                return "Employee added";
            }
        } catch (SQLException e) {
    
            System.out.println("fail to add");
        }
        return null;
    }

    public void viewEmployee(Connection connection) {

        try {

            String query = "SELECT * from employee";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultset = statement.executeQuery();
            while (resultset.next()) {

                int id = resultset.getInt("id");
                String name = resultset.getString("name");
                String position = resultset.getString("position");
                double salary = resultset.getDouble("salary");

                System.out.println();
                System.out.println(
                        "ID : " + id + "\nName : " + name + "\nPosition : " + position + "\nSalary : " + salary);
                System.out.println();
            }

        } catch (SQLException e) {
            System.out.println("Employee Not found.");
        }
    }

    public void updateEmployee(Scanner scanner, Connection connection) {
        try {

            System.out.print("Enter Employee ID : ");
            int id = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Enter Name : ");
            String updatedName = scanner.nextLine();
            System.out.print("Enter Position : ");
            String updatedPosition = scanner.nextLine();
            System.out.print("Enter Salary : ");
            double updatedsalary = scanner.nextDouble();

            String query = "UPDATE employee SET name = ?, position = ?, salary = ? WHERE id = ?; ";

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, updatedName);
            statement.setString(2, updatedPosition);
            statement.setDouble(3, updatedsalary);
            statement.setInt(4, id);

            int rowAffected = statement.executeUpdate();
            if (rowAffected > 0) {
                System.out.println("Employee update.");
            }

        } catch (SQLException e) {
            System.out.println("Employee Not Update.");
        }
    }

    public void deleteEmployee(Connection connection, Scanner scanner) {
        try {

            String query = "DELETE FROM employee WHERE id = ?;";
            System.out.print("Enter Employee ID : ");
            int id = scanner.nextInt();

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);

            int rowAffected = statement.executeUpdate();

            if (rowAffected > 0)
                System.out.println("Employee Deleted");

        } catch (SQLException e) {
            System.out.println("Employee Not found.");
        }
    }
}
