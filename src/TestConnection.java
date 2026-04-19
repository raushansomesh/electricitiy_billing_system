import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConnection {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/Bill_system";
        String username = "root";
        String password = "QazSw$#33";

        System.out.println("Testing database connection...");
        System.out.println("URL: " + url);
        System.out.println("Username: " + username);

        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("\nMySQL JDBC Driver loaded successfully!");

            // Attempt connection
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("✅ Database connection SUCCESSFUL!");
            System.out.println("Connected to: " + connection.getMetaData().getURL());
            System.out.println("Database: " + connection.getCatalog());
            connection.close();
            System.out.println("Connection closed.");

        } catch (ClassNotFoundException e) {
            System.out.println("\n❌ MySQL JDBC Driver not found!");
            System.out.println("Error: " + e.getMessage());
            System.out.println("\nPlease add MySQL Connector/J to your project libraries.");
        } catch (SQLException e) {
            System.out.println("\n❌ Database connection FAILED!");
            System.out.println("Error Code: " + e.getErrorCode());
            System.out.println("SQL State: " + e.getSQLState());
            System.out.println("Error Message: " + e.getMessage());

            if (e.getMessage().contains("Communications link failure")) {
                System.out.println("\nPossible causes:");
                System.out.println("- MySQL Server is not running");
                System.out.println("- Port 3306 is blocked by firewall");
                System.out.println("- Wrong host or port");
            } else if (e.getMessage().contains("Access denied")) {
                System.out.println("\nPossible causes:");
                System.out.println("- Incorrect username or password");
                System.out.println("- User 'root' doesn't have privileges");
            } else if (e.getMessage().contains("Unknown database")) {
                System.out.println("\nPossible causes:");
                System.out.println("- Database 'Bill_system' doesn't exist");
                System.out.println("- Create the database first in MySQL Workbench");
            }
        }
    }
}
