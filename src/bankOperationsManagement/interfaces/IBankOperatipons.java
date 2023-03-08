package bankOperationsManagement.interfaces;
/*
 * Author: SOUMYA SOURAV BEHERA
 * Date: MARCH 8, 2023
 *
 * Description: This program is a demo for bank operations
 */
import java.sql.SQLException;

public interface IBankOperatipons {
	
	void showUserDetails() throws ClassNotFoundException, SQLException;
	void showAccountDetails() throws ClassNotFoundException, SQLException;
	void deposit() throws SQLException, ClassNotFoundException;
	void withdraw() throws SQLException, ClassNotFoundException;
	

}
