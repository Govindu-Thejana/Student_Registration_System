import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class databaseConnection {
    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/schoolmanagement", "root", "56692942");
            return con;
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }
    
    public static boolean isConnected(Connection con) {
        try {
            return con != null && !con.isClosed();
        } catch (SQLException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        Connection connection = getConnection();
        if (isConnected(connection)) {
            System.out.println("Connected to the database.");
            // You can perform further operations here if needed
        } else {
            System.out.println("Failed to connect to the database.");
        }
    }
}
