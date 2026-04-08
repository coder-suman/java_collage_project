package com.jdbc.student;

import java.sql.*;
import java.util.Scanner;

public class studentDatabase {
    private static Connection connection= null;
    private static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
        studentDatabase std=new studentDatabase();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/jdbc_db";
            String userName = "root";
            String password = "root";
            connection = DriverManager.getConnection(url, userName, password);
            while (true) {
                System.out.println("--------------------------------");
                System.out.println("|         MAIN MENU             |");
                System.out.println("--------------------------------");
                System.out.println("|    1. Add user Data.          |");
                System.out.println("|    2. display user Details.   |");
                System.out.println("|    3. Update User Data        |");
                System.out.println("|    4. Delete User Data        |");
                System.out.println("|    5.Exit.                    |");
                System.out.println("--------------------------------");
                System.out.println();
                System.out.print("Enter your Choice: ");
                int choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        std.addUser();
                        break;
                    case 2:
                        std.showUser();
                        break;
                    case 3:
                        std.updateUser();
                        break;
                    case 4:
                        std.deleteUser();
                        break;
                    case 5:
                        System.out.println("Exit...");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Enter a valid choice...");
                }
            }
            }catch(Exception e){
                e.printStackTrace();
                throw new RuntimeException("Something else wrong...");
            }
    }

    public void addUser() throws SQLException {
        String sql="Insert into student(name,department,email_id) values(?,?,?)";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        sc.nextLine();
        System.out.println();
        System.out.println("--------------------------------");
        System.out.print("Enter Student Name: ");
        preparedStatement.setString(1,sc.nextLine());
        System.out.print("Enter Department Name: ");
        preparedStatement.setString(2,sc.nextLine());
        System.out.print("Enter Email_id: ");
        preparedStatement.setString(3,sc.nextLine());
        int rows=preparedStatement.executeUpdate();
        if(rows>0){
            System.out.println("Data Insert successfully...");
        }
        System.out.println("--------------------------------");
    }

    public void showUser() throws SQLException{
        System.out.println("--------------------------------");
        System.out.println("|         DISPLAY MENU         |");
        System.out.println("--------------------------------");
        System.out.println("|      1. Show All Data.       |");
        System.out.println("|      2. Show Particular data.|");
        System.out.println("--------------------------------");
        System.out.println();
        System.out.print("Enter your choice: ");
        int choice=sc.nextInt();
        String sql="";
        switch (choice){
            case 1:
                sql="select * from student";
                break;
            case 2:
                System.out.print("Enter Roll_number:  ");
                int roll=sc.nextInt();
                sql="select * from student where roll_number="+roll;
                break;
            default:
                System.out.println("Select a right choice...");
        }

        Statement statement=connection.createStatement();
        ResultSet result=statement.executeQuery(sql);
        System.out.println();
        System.out.println("---------------------------------------------------------------");
        System.out.printf("%-15s %-20s %-15s %-25s%n", "Roll No", "Name", "Department", "Email");
        System.out.println("---------------------------------------------------------------");

        while(result.next()) {
            int roll_number = result.getInt("roll_number");
            String st_name = result.getString("name");
            String dept = result.getString("department");
            String email = result.getString("email_id");

            System.out.printf("%-15d %-20s %-15s %-25s%n",
                    roll_number, st_name, dept, email);
        }
        System.out.println("---------------------------------------------------------------");
    }

    public void updateUser() throws SQLException {
        System.out.println();
        System.out.println("----------------------------");
        System.out.println("|      UPDATE MENU         |");
        System.out.println("----------------------------");
        System.out.println("|  1. Update Name.         |");
        System.out.println("|  2. Update Department.   |");
        System.out.println("|  3. Update Email_id      |");
        System.out.println("----------------------------");
        System.out.print("Enter your choice: ");

        int choice = sc.nextInt();
        sc.nextLine();

        String sql = "";
        int roll;

        switch (choice) {
            case 1:
                System.out.print("Enter Roll number: ");
                roll = sc.nextInt();
                sc.nextLine();

                System.out.print("Enter Name for update: ");
                String name = sc.nextLine();

                sql = "UPDATE student SET name = ? WHERE roll_number = ?";
                PreparedStatement ps1 = connection.prepareStatement(sql);
                ps1.setString(1, name);
                ps1.setInt(2, roll);
                ps1.executeUpdate();
                break;

            case 2:
                System.out.print("Enter Roll number: ");
                roll = sc.nextInt();
                sc.nextLine();

                System.out.print("Enter Department for update: ");
                String dept = sc.nextLine();

                sql = "UPDATE student SET department = ? WHERE roll_number = ?";
                PreparedStatement ps2 = connection.prepareStatement(sql);
                ps2.setString(1, dept);
                ps2.setInt(2, roll);
                ps2.executeUpdate();
                break;

            case 3:
                System.out.print("Enter Roll number: ");
                roll = sc.nextInt();
                sc.nextLine();

                System.out.print("Enter Email_id for update: ");
                String mail = sc.nextLine();

                sql = "UPDATE student SET email_id = ? WHERE roll_number = ?";
                PreparedStatement ps3 = connection.prepareStatement(sql);
                ps3.setString(1, mail);
                ps3.setInt(2, roll);
                ps3.executeUpdate();
                break;
            default:
                System.out.println("Please choose a valid choice...");
                return;
        }
        System.out.println("Data Updated Successfully...");
    }

    public void deleteUser() throws SQLException{
        System.out.println("--------------------------------");
        System.out.println("|          DELETE MENU          |");
        System.out.println("--------------------------------");
        System.out.println("|      1. Delete All Data.      |");
        System.out.println("|      2. Delete Specific Row.  |");
        System.out.println("--------------------------------");
        System.out.println();
        System.out.print("Enter your choice: ");
        int choice=sc.nextInt();
        String sql="";
        switch (choice){
            case 1:
                sql="delete from student";
                break;
            case 2:
                System.out.print("Enter Roll_number:  ");
                int roll=sc.nextInt();
                sql="delete from student where roll_number="+roll;
                break;
            default:
                System.out.println("Select a right choice...");
        }

        Statement statement = connection.createStatement();
        int rows = statement.executeUpdate(sql);
        System.out.println(rows + " row(s) deleted successfully...");

    }



}
