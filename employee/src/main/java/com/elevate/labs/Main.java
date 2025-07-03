package com.elevate.labs;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        DBConnection db = new DBConnection();
        EmployeeDAO employeeDAO = new EmployeeDAO();
        Scanner scanner = new Scanner(System.in);
        Connection con = db.getConnection();

        boolean running = true;

        while (running) {

            System.out.println("Employee Database Application\n");
            System.out.println("1. Add Employee ");
            System.out.println("2. View Employee");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit\n");
            System.out.print("Enter Your Choice : ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> {

                    employeeDAO.addEmployee(con, scanner);
                }

                case 2 -> employeeDAO.viewEmployee(con);
                case 3 -> employeeDAO.updateEmployee(scanner, con);
                case 4 -> employeeDAO.deleteEmployee(con, scanner);
                case 5 -> {
                    System.out.println("Thank You For Using Employee Database Application");
                    running = false;
                }
            }

        }

    }
}
