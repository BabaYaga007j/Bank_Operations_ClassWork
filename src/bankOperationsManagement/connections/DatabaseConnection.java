package bankOperationsManagement.connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	private static final String URL = "jdbc:mysql://localhost:3306/bank_management_system";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "babayaga@12345";

    private static Connection connection;

    private DatabaseConnection() {}

    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        }
        return connection;
    }

}
