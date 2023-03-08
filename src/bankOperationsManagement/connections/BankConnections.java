package bankOperationsManagement.connections;


/*
 * Author: SOUMYA SOURAV BEHERA
 * Date: MARCH 8, 2023
 *
 * Description: This program is a demo for bank operations
 */

// Actual code starts here...
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;



class DatabaseConnection
{
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
public class BankConnections {


	static int balance=0;
	static Scanner SCANNER = new  Scanner(System.in);

	public static void showUserDetails() throws ClassNotFoundException, SQLException
	{
		Connection connection = DatabaseConnection.getConnection();//singleton Pattern
		Statement statement = connection.createStatement();

		//Show Customer Details
		String queryOne = "select * from customerDetails";
		ResultSet resultSetOne = statement.executeQuery(queryOne);
		while(resultSetOne.next()) 
		{
			int customerId = resultSetOne.getInt("CustomerId");
			String customerName = resultSetOne.getString("FirstName");
			String customerAddress = resultSetOne.getString("MiddleName");
			String customerEmail = resultSetOne.getString("LastName");
			long customerPhone = resultSetOne.getLong("MobileNumber");

			//Print the customer details
			System.out.println("Customer ID: " + customerId);
			System.out.println("Customer FirstName: " + customerName);
			System.out.println("Customer MiddleName: " + customerAddress);
			System.out.println("Customer LastName: " + customerEmail);
			System.out.println("Customer Phone: " + customerPhone);
		}
	}
	public static void showAccountDetails() throws ClassNotFoundException, SQLException
	{
		Connection connection = DatabaseConnection.getConnection();//singleton Pattern
		Statement statement = connection.createStatement();

		//show BankDetails
		String queryTwo = "select * from accountDetails";
		ResultSet resultSetTwo = statement.executeQuery(queryTwo);
		while(resultSetTwo.next()) 
		{
			int customerId = resultSetTwo.getInt("Customer_Id");
			String Account_Number = resultSetTwo.getString("Account_Number");
			String Account_Type = resultSetTwo.getString("Account_Type");
			String Account_Balance = resultSetTwo.getString("Account_Balance");
			long Branch_Code = resultSetTwo.getLong("Branch_Code");

			//Print the account details
			System.out.println("Customer ID: " + customerId);
			System.out.println("Customer Account Number: " + Account_Number);
			System.out.println("Customer Account Type: " + Account_Type);
			System.out.println("Customer Account Balance: " + Account_Balance);
			System.out.println("Customer Branch Code: " + Branch_Code);

		}
	}

	public static void deposit() throws SQLException, ClassNotFoundException {
		System.out.println("Enter account Number: ");
		String accountNo = SCANNER.next();

		Connection connection = DatabaseConnection.getConnection();//singleton Pattern

		Statement statement = connection.createStatement();
		String query = "select Account_Number from accountDetails where Account_Number = " + accountNo;
		ResultSet resultAccountNo = statement.executeQuery(query);

		if (resultAccountNo.next()) {
			System.out.println("This Account Exists...");

			System.out.println("Customer Id: ");
			String customerId = SCANNER.next();
			String query1 = "select Customer_Id from accountDetails where Customer_Id = " + customerId;

			if ((statement.executeQuery(query1)).next()) {
				System.out.println("Enter Amount to Deposit: ");
				int cash = SCANNER.nextInt();

				String query2 = "update accountDetails set Account_Balance = Account_Balance + " + cash + " where Account_Number = " + accountNo;
				statement.executeUpdate(query2);

				System.out.println("Deposit Successful. New Balance: " + (getBalance(accountNo) ));
			} else {
				System.out.println("Customer ID mismatch. Please try again.");
			}
		} else {
			System.out.println("Account Does Not Exist.");
		}

		statement.close();
		connection.close();
	}
	public static void withdraw() throws SQLException, ClassNotFoundException {
		System.out.println("Enter Account Number: ");
		String accountNo = SCANNER.next();
		Connection connection = DatabaseConnection.getConnection();//singleton Pattern

		Statement statement = connection.createStatement();
		String query = "select Account_Number from accountDetails where Account_Number = " + accountNo;
		ResultSet resultAccountNo = statement.executeQuery(query);

		if (resultAccountNo.next()) {
			System.out.println("This Account Exists...");

			System.out.println("Enter Customer ID: ");
			String customerId = SCANNER.next();
			String query1 = "select Customer_Id from accountDetails where Customer_Id = " + customerId;

			if ((statement.executeQuery(query1)).next()) {
				int currentBalance = getBalance(accountNo);

				System.out.println("Enter Amount to Withdraw: ");
				int cash = SCANNER.nextInt();

				if (cash > currentBalance) {
					System.out.println("Insufficient Balance.");
				} else {
					String query2 = "update accountDetails set Account_Balance = Account_Balance - " + cash + " where Account_Number = " + accountNo;
					statement.executeUpdate(query2);

					System.out.println("Withdrawal Successful. New Balance: " + (currentBalance - cash));
				}
			} else {
				System.out.println("Customer ID mismatch. Please try again.");
			}
		} else {
			System.out.println("Account Does Not Exist.");
		}

		statement.close();
		connection.close();
	}



	// Method to get account balance
	private static int getBalance(String accountNo) throws SQLException, ClassNotFoundException {
		Connection connection = DatabaseConnection.getConnection();//singleton Pattern
		Statement statement = connection.createStatement();
		String query = "select Account_Balance from accountDetails where Account_Number = " + accountNo;
		ResultSet result = statement.executeQuery(query);

		if (result.next()) {
			return result.getInt("Account_Balance");
		} else {
			return 0;
		}
	}
}






