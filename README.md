# Elevate Labs Internship

## Task 7 – Java JDBC Employee Database App

## 📌 Objective

A Java application that connects to a MySQL/PostgreSQL database using JDBC and performs CRUD operations (Create, Read, Update, Delete) on an employee table.

## 🛠️ Tools & Technologies

- Java
- JDBC
- MySQL
- VS Code

## 📂 Features

- Add employee
- View employee(s)
- Update employee
- Delete employee

## 🗄️ Database Setup

To run this project, you need to create a database and the employees table in MySQL (or PostgreSQL). Below are the SQL commands to set up your database.

### 1. Create Database

```sql
  CREATE DATABASE employee_db;
  USE employee_db;
```

### 2. Create employees Table

```sql
  CREATE TABLE employees (
      id INT AUTO_INCREMENT PRIMARY KEY,
      name VARCHAR(100) NOT NULL,
      position VARCHAR(100) NOT NULL,
      salary DOUBLE
  );

```

### 3. Sample Data

```sql
  INSERT INTO employees (name, position, salary) VALUES
  ('Alice Johnson', 'HR', 55000),
  ('Bob Smith','Engineering', 75000);

```

### Notes:

Make sure your Java DBConnection.java file uses the correct database URL, username, and password to connect to this database.
For PostgreSQL, adjust the SQL syntax accordingly (SERIAL instead of AUTO_INCREMENT for the ID, etc.).

## 🧩 Project Structure

employee/<br>
├── src/<br>
│ └── main/java/com/elevate/labs/<br>
│ ├── DBConnection.java<br>
│ ├── Employee.java<br>
│ ├── EmployeeDAO.java<br>
│ └── Main.java<br>

## 🚀 How to Run

1. Clone the repo
2. Set up your DB using the SQL script
3. Configure DB connection in `DBConnection.java`
4. Run `Main.java`

## 📝 Project Explanation

This Java JDBC Employee Database App demonstrates how to connect a Java application to a relational database (MySQL/PostgreSQL) using JDBC (Java Database Connectivity) to perform basic CRUD operations — Create, Read, Update, and Delete employee records.

Why this project matters:

      Database connectivity is essential for real-world applications that manage persistent data.
      JDBC is the standard Java API for database interaction, and mastering it is a key skill for Java developers.
      This project gives hands-on experience in writing SQL queries inside Java, handling database connections, and managing data securely with PreparedStatements.

How it works:

      The app uses a MySQL/PostgreSQL database with an employees table storing employee details like id, name, email, department, and salary.
      A DBConnection class manages establishing the connection with the database using JDBC DriverManager.
      The EmployeeDAO class encapsulates CRUD operations, using PreparedStatement to safely run SQL queries.
      The Employee class models the employee data as Java objects.
      The Main class provides a simple command-line interface or method calls to add, view, update, and delete employee records.
      Proper resource management ensures database connections and statements are closed after use.
      Use of PreparedStatement prevents SQL Injection, enhancing security.

---
