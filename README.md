

# JDBC CRUD Java Project

This is a simple **Java application** that performs complete **Create, Read, Update, and Delete (CRUD)** operations on a MySQL database using **JDBC**. The program accepts **dynamic user input**, executes SQL queries, and displays results clearly. It is designed for **reliable database interaction** and proper **resource management**.

---

## Features

* Add a new user to the database
* Display all users
* Update user details by ID
* Delete a user by ID
* Menu-driven interface for easy operation

---

## Technologies Used

* Java (JDK 8 or higher)
* MySQL (via **XAMPP**)
* JDBC (Java Database Connectivity)
* MySQL Connector/J (`mysql-connector-java-8.1.0.jar`)

---

## Database Setup (XAMPP MySQL)

1. Start **MySQL** using XAMPP.
2. Create the database:

```sql
CREATE DATABASE jdbc_demo;
```

3. Create the `users` table:

```sql
USE jdbc_demo;

CREATE TABLE users (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL
);
```

---

## Project Structure

```
MyJDBCProject/
├─ lib/
│   └─ mysql-connector-java-8.1.0.jar
├─ project.java        # Java source file with full CRUD operations
└─ README.md
```

---

## How to Compile and Run

### Windows (PowerShell)

```powershell
javac -cp ".;lib/mysql-connector-java-8.1.0.jar" project.java
java -cp ".;lib/mysql-connector-java-8.1.0.jar" project
```

### macOS / Linux

```bash
javac -cp ".:lib/mysql-connector-java-8.1.0.jar" project.java
java -cp ".:lib/mysql-connector-java-8.1.0.jar" project
```

> Make sure `mysql-connector-java-8.1.0.jar` exists in the `lib/` folder.
> The database `jdbc_demo` and table `users` must exist.

---

## Usage

1. Run the program.
2. You will see a menu:

```
1. Add user
2. Display User Details
3. Update user Details
4. Delete user Details
5. Exit
```

3. Enter your choice (1-5) and follow the prompts.

---

## Notes

* The program uses **try-with-resources** to automatically close database connections and scanners.
* Default XAMPP MySQL credentials are used:

  * **User:** `root`
  * **Password:** *(empty)*
* Make sure MySQL is running before starting the program.
* If `ClassNotFoundException` occurs, ensure the MySQL connector JAR is included in the classpath.

---


