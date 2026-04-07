/*create a java application that performs complete Create, Read, Update and Delete operations on a database table using JDBC. The program should accept user input dynamically, execute corresponding SQL queries and display operation results clearly. The design should focus on reliable database interaction and resource management. */
import java.sql.*;
import java.util.*;

class User_Data{
    // Scanner sc=new Scanner(System.in);
    public static Connection getConnection() throws Exception{
         Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/jdbc_demo?useSSL=false&serverTimezone=UTC";
        String user = "root";
        String password = ""; 
        return DriverManager.getConnection(url, user, password);
    }
    public void AddUser(){
        try (Connection con = getConnection();
             Scanner sc = new Scanner(System.in)) {

            System.out.print("Enter name: ");
            String name = sc.nextLine();

            System.out.print("Enter email: ");
            String email = sc.nextLine();

            String sql = "INSERT INTO users(name, email) VALUES (?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, email);

            int rows = ps.executeUpdate();
            System.out.println(rows + " user(s) added successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void DisplayUser(){

    }
    public void UpdateUser(){

    }
    public void DeleteUser(){

    }
}
public class project {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        User_Data obj=new User_Data();
        while (true) {
            System.out.println("1. Add user.");
            System.out.println("2. Display User Details.");
            System.out.println("3. Update user Details.");
            System.out.println("4. Delete user Details.");
            
            System.out.println();
            System.out.print("Enter your Choice: ");
            int choice=sc.nextInt();

            switch (choice) {
                case 1:
                    obj.AddUser();
                    break;
                case 2:
                    obj.DisplayUser();
                    break;
                case 3:
                    obj.UpdateUser();
                    break;
                case 4:
                    obj.DeleteUser();
                case 5:
                    System.exit(0);
                default:
                    System.out.println("Please Enter a valid choice...");
            }


        }
    }
}
