package CommandLineInterfaces;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.Scanner;

import DBInterfaces.DbInterface;
import Main.KeyScanner;

/**
 * This Command Line Terminal class allows the user to enter a new publisher.
 * @author russellfincham
 * @version 0.1
 * @since 25-06-18
 */

public class CliPublisherEnter {
	/**
	 * This Command Line Terminal class allows the user to enter a new publisher.
	 * It then supplies the correct SQL query to DbInterface.queryDatabase for
	 * record addition to the database.
	 * @throws FileNotFoundException if DbInterface.DbLogin unable to access user file.
	 * @throws SQLException if DbInterface.QueryDatabase unable to successfully
	 * query database
	 */
	public static void enterPublisherMenu() throws FileNotFoundException, SQLException {
	
		//  Scanner Variable
		String userInput = "";
		Scanner enterPublisherScanner = KeyScanner.keyInput;
		
		//SQL Delete Publisher variables
		String publisher_id = "";
		String publisher_name = "";
		String address_1 = "";
		String address_2 = "";
		String address_3 = "";
		String address_town = "";
		String address_county = "";
		String address_postcode = "";
		
		//Interface output and navigation
		System.out.println("\n*****  Enter Publisher *****");
		System.out.println("0.  Main Menu - at any time");
		System.out.println("\n1 of 10 - Enter Publisher ID:");
		while (enterPublisherScanner.hasNextLine()) {
			userInput = enterPublisherScanner.nextLine();
			if (userInput.equals("0") || userInput.equals("0.")) {
				CliMainPage.mainPage();
		    	}
			else if (userInput.equals("")) {
				System.out.println("Publisher ID cannot be blank.  Please enter.");
				}
			else {
				publisher_id = userInput;
				break;
				}
		}
		System.out.println("2 of 10 - Enter Publisher Name:");
		while (enterPublisherScanner.hasNextLine()) {
			userInput = enterPublisherScanner.nextLine();
			if (userInput.equals("0") || userInput.equals("0.")) {
				CliMainPage.mainPage();
		    	}
			else if (userInput.equals("")) {
				System.out.println("Publisher Name cannot be blank.  Please enter.");
				}
			else {
				publisher_name = userInput;
				break;
				}
		}
		System.out.println("3 of 10 - Enter 1st line of address:");
		while (enterPublisherScanner.hasNextLine()) {
			userInput = enterPublisherScanner.nextLine();
			if (userInput.equals("0") || userInput.equals("0.")) {
				CliMainPage.mainPage();
		    	}
			else {
				address_1 = userInput;
				break;
				}
		}
		System.out.println("4 of 10 - Enter 2nd line of address:");
		while (enterPublisherScanner.hasNextLine()) {
			userInput = enterPublisherScanner.nextLine();
			if (userInput.equals("0") || userInput.equals("0.")) {
				CliMainPage.mainPage();
		    	}
			else {
				address_2 = userInput;
				break;
				}
		}
		System.out.println("5 of 10 - Enter 3rd line of address:");
		while (enterPublisherScanner.hasNextLine()) {
			userInput = enterPublisherScanner.nextLine();
			if (userInput.equals("0") || userInput.equals("0.")) {
				CliMainPage.mainPage();
		    	}
			else {
				address_3 = userInput;
				break;
				}
		}
		System.out.println("6 of 10 - Enter address town:");
		while (enterPublisherScanner.hasNextLine()) {
			userInput = enterPublisherScanner.nextLine();
			if (userInput.equals("0") || userInput.equals("0.")) {
				CliMainPage.mainPage();
		    	}
			else {
				address_town = userInput;
				break;
				}
		}
		System.out.println("7 of 10 - Enter address county:");
		while (enterPublisherScanner.hasNextLine()) {
			userInput = enterPublisherScanner.nextLine();
			if (userInput.equals("0") || userInput.equals("0.")) {
				CliMainPage.mainPage();
		    	}
			else {
				address_county = userInput;
				break;
				}
		}
		System.out.println("8 of 10 - Enter Publisher postcode:");
		while (enterPublisherScanner.hasNextLine()) {
			userInput = enterPublisherScanner.nextLine();
			if (userInput.equals("0") || userInput.equals("0.")) {
				CliMainPage.mainPage();
		    	}
			else {
				address_postcode = userInput;
				break;
				}
		}
		
		String sqlEnterPublisher = "INSERT INTO publishers VALUES "
				+ "('" + publisher_id + "', '"
				+ publisher_name + "', '"
				+ address_1 + "', '"
				+ address_2 + "', '"
				+ address_3 + "', '"
				+ address_town + "', '"
				+ address_county + "', '"
				+ address_postcode + "');";
		System.out.println("Publisher entry " 
				+ DbInterface.queryDatabase(sqlEnterPublisher));

		CliMainPage.mainPage();
	}
}