package CommandLineInterfaces;

import java.util.Scanner;
import java.io.FileNotFoundException;
import java.sql.SQLException;

import DBInterfaces.PropertiesInterface;
import Main.KeyScanner;

/**
 * This Command Line Terminal class allows setting of database user
 * and connection url.
 * @author russellfincham
 * @version 0.1
 * @since 25-06-18
 */
public class CliSettingsDbAccess {
	/**
	 * This Command Line Terminal class allows the user to configure database
	 * user ID and password along with URL for connection. DbInterface.queryDatabase
	 * class used to update specified file for these settings.
	 * @throws FileNotFoundException if PropertiesInterface.DbAccessProperties
	 * unable to access file.
	 * @throws SQLException if DbInterface.QueryDatabase unable to successfully
	 * query database
	 */
	public static void dbAccessConfig() throws FileNotFoundException, SQLException {
	
	String userInput = "";
	Scanner dbAccessConfigScanner = KeyScanner.keyInput;
	
	System.out.println("\n*****  Database Access Config Page *****");
	System.out.println();
	System.out.println("1. Database User");
	System.out.println("2. Database Password");
	System.out.println("3. Database Url");
	System.out.println();
	System.out.println("0. Main Menu");
	System.out.println("Please enter selection: ");

	while (dbAccessConfigScanner.hasNextLine()) {
		userInput = dbAccessConfigScanner.nextLine();
		if (userInput.equals("1") || userInput.equals("1.")) {
			System.out.println("Please enter user ID of the database user.");
			String newPropertyValue = dbAccessConfigScanner.nextLine();
			System.out.println(PropertiesInterface.DbAccessProperties("UserID", newPropertyValue));
			CliSettingsDbAccess.dbAccessConfig();
			}
		else if (userInput.equals("2") || userInput.equals("2.")) {
			System.out.println("Please enter password of the database user.");
			String newPropertyValue = dbAccessConfigScanner.nextLine();
			System.out.println(PropertiesInterface.DbAccessProperties("Password", newPropertyValue));
			CliSettingsDbAccess.dbAccessConfig();
	    	}
		else if (userInput.equals("3") || userInput.equals("3.")) {
			System.out.println("Please enter database Url");
			System.out.println("Example:  jdbc:mysql://server.office.local:3306/ebookstore?useSSL=FALSE");
			String newPropertyValue = dbAccessConfigScanner.nextLine();
			System.out.println(PropertiesInterface.DbAccessProperties("DbUrl", newPropertyValue));
			CliSettingsDbAccess.dbAccessConfig();
	    	}
		else if (userInput.equals("0") || userInput.equals("0.")) {
			CliMainPage.mainPage();
			}
		else {
			System.out.println("Invalid Selection:");
			System.out.println("Please enter a valid selection: ");
			}
		}
	}
}
