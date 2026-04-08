


## **Student Database Management System (Java + JDBC)**

---

## 1. 📌 Introduction

The **Student Database Management System** is a console-based Java application that performs basic database operations using **JDBC (Java Database Connectivity)**.

It allows users to:

* Add student records
* View student details
* Update student information
* Delete records

The system connects to a **MySQL database** and performs CRUD (Create, Read, Update, Delete) operations.

---

## 2. 🎯 Objective

The main objective of this project is to:

* Understand JDBC connectivity
* Perform database operations using Java
* Implement CRUD functionality
* Learn use of `PreparedStatement` and `Statement`

---

## 3. 🛠️ Technologies Used

| Technology             | Description                |
| ---------------------- | -------------------------- |
| Java                   | Core programming language  |
| JDBC                   | Database connectivity API  |
| MySQL                  | Database management system |
| MySQL Connector/J      | JDBC driver                |
| IDE (Eclipse/IntelliJ) | Development environment    |

---

## 4. 🗄️ Database Details

### Database Name:

```
jdbc_db
```

### Table Name:

```
student
```

### Table Structure:

```sql
CREATE TABLE student (
    roll_number INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50),
    department VARCHAR(50),
    email_id VARCHAR(100)
);
```

---

## 5. 🔗 Database Connection

The application connects to MySQL using:

```java
String url = "jdbc:mysql://localhost:3306/jdbc_db";
String userName = "root";
String password = "root";
connection = DriverManager.getConnection(url, userName, password);
```

Driver loaded using:

```java
Class.forName("com.mysql.cj.jdbc.Driver");
```

---

## 6. ⚙️ Functional Modules

### 6.1 ➕ Add User (`addUser()`)

* Takes input from user:

  * Name
  * Department
  * Email
* Inserts data using `PreparedStatement`

```sql
INSERT INTO student(name, department, email_id) VALUES (?, ?, ?)
```

---

### 6.2 📄 Show User (`showUser()`)

Two options:

1. Show all records
2. Show specific record using roll number

Displays data in **table format**:

```
Roll No   Name         Department     Email
```

Uses:

```java
Statement + ResultSet
```

---

### 6.3 ✏️ Update User (`updateUser()`)

Menu-based update:

1. Update Name
2. Update Department
3. Update Email

Uses `PreparedStatement`:

```sql
UPDATE student SET column = ? WHERE roll_number = ?
```

---

### 6.4 ❌ Delete User (`deleteUser()`)

Options:

1. Delete all data
2. Delete specific row

```sql
DELETE FROM student
DELETE FROM student WHERE roll_number = ?
```

---

## 7. 🔄 Program Flow

1. Load JDBC Driver
2. Establish database connection
3. Display menu:

   ```
   1. Add User
   2. Show User
   3. Update User
   4. Delete User
   5. Exit
   ```
4. Perform selected operation
5. Repeat until user exits

---

## 8. 💡 Key Concepts Used

* JDBC API
* `Connection`
* `Statement`
* `PreparedStatement`
* `ResultSet`
* Exception Handling
* User Input using `Scanner`

---

## 9. ⚠️ Error Handling

* Uses try-catch block in main method
* Throws runtime exception if connection fails
* SQL exceptions handled in methods

---

## 10. 🚀 Advantages

* Simple and easy to use
* Demonstrates real database interaction
* Uses secure `PreparedStatement`
* Console-based (lightweight)

---

## 11. ❌ Limitations

* No GUI (only console-based)
* No input validation
* No password security
* SQL injection risk in some `Statement` usage

---


## 13. 📌 Conclusion

This project successfully demonstrates how Java can interact with a MySQL database using JDBC. It provides a strong foundation for building real-world database applications and helps in understanding backend development concepts.


