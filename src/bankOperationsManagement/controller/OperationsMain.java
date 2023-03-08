package bankOperationsManagement.controller;


/*
 * Author: SOUMYA SOURAV BEHERA
 * Date: MARCH 8, 2023
 *
 * Description: This program is a demo for bank operations
 */

// Actual code starts here...
import java.sql.SQLException;


import java.util.Scanner;

import bankOperationsManagement.services.BankConnections;



public class OperationsMain {


	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		System.out.println("Welcome To SBI bank");
		byte choice=0;
		do
		{
		System.out.println("Press 1 for Show all bank Customers details ::Bank Management Staffs Only::");
		System.out.println("Press 2 for show all account Details :: Bank Management Staffs only");
		System.out.println("Press 3 for deposite ammount");
		System.out.println("Press 4 for Withdrawl amount");
		Scanner scanner = new Scanner(System.in);
		byte userchoice = scanner.nextByte();

		BankConnections bankConnections = new BankConnections();
	
		switch (userchoice) {
		case 1:
			bankConnections.showUserDetails();
			break;
		case 2:
			bankConnections.showAccountDetails();
			break;
		case 3:
			bankConnections.deposit();
			break;
		case 4:
			bankConnections.withdraw();
			break;
		default:
		{
			System.out.println("Wrong Input");
		}
		break;
		}
		System.out.println("Press 1 to continue "+'\n'+"Press any number to exit");
		choice=scanner.nextByte();
		}
		while(choice ==1);
	
	}
}
