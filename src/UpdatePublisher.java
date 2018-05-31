import java.io.FileNotFoundException;
import java.util.Scanner;

public class UpdatePublisher {
	
	public static void updatePublisherMenu() throws FileNotFoundException {
	
		//  Scanner Variable
		String userInput = "";
		Scanner updatePublisherScanner = BookStoreMain.keyInput;
		
		// SQL Update Author Variables
		String id = "";
		String updateVariable = ""; 
					
		System.out.println("\n*****  Update Publisher  *****");
		System.out.println();
		System.out.println("What would you like to update?");
		System.out.println();
		System.out.println("1.  ID");
		System.out.println("2.  Publisher Name");
		System.out.println("3.  Address 1");
		System.out.println("4.  Address 2");
		System.out.println("5.  Address 3");
		System.out.println("6.  Address Town");
		System.out.println("7.  Address County");
		System.out.println("8.  Postcode");
		System.out.println();
		System.out.println("0.  Main Menu");
		System.out.println("Please enter selection");
		
		while (updatePublisherScanner.hasNextLine()) {
			userInput = updatePublisherScanner.nextLine();
			if (userInput.equals("0") || userInput.equals("0.")) {
				MainInterface.mainPage();
		    	}
			else if (userInput.equals("1") || userInput.equals("1.")) {
				System.out.println("Enter Publisher ID of record to be updated");
				id = updatePublisherScanner.nextLine();
				System.out.println();
				System.out.println("Enter New Publisher ID");
				updateVariable = updatePublisherScanner.nextLine();
				String sqlUpdatePublisherID = "UPDATE Publishers SET publisher_id = '" + updateVariable 
						+ "' WHERE publisher_id = '" + id + "';";
				System.out.println("Publisher ID update "
						+ DbConnection.queryDatabase(sqlUpdatePublisherID));
				MainInterface.mainPage();
		    	}
			else if (userInput.equals("2") || userInput.equals("2.")) {
				System.out.println("Enter Book ID of record to be updated");
				id = updatePublisherScanner.nextLine();
				System.out.println();
				System.out.println("Enter New Publisher Name");
				updateVariable = updatePublisherScanner.nextLine();
				String sqlUpdatePublisherName = "UPDATE Publishers SET publisher_name = '" + updateVariable 
						+ "' WHERE publisher_id = '" + id + "';";
				System.out.println("Publisher Name update "
						+ DbConnection.queryDatabase(sqlUpdatePublisherName));
				MainInterface.mainPage();
				}
			else if (userInput.equals("3") || userInput.equals("3.")) {
				System.out.println("Enter Book ID of record to be updated");
				id = updatePublisherScanner.nextLine();
				System.out.println();
				System.out.println("Enter New Address 1");
				updateVariable = updatePublisherScanner.nextLine();
				String sqlUpdatePubliserAddress1 = "UPDATE Publishers SET address_1 = '" + updateVariable 
						+ "' WHERE publisher_id = '" + id + "';";
				System.out.println("Publisher Address 1 update "
						+ DbConnection.queryDatabase(sqlUpdatePubliserAddress1));
				MainInterface.mainPage();
		    	}
			else if (userInput.equals("4") || userInput.equals("4.")) {
				System.out.println("Enter Book ID of record to be updated");
				id = updatePublisherScanner.nextLine();
				System.out.println();
				System.out.println("Enter New Address 2");
				updateVariable = updatePublisherScanner.nextLine();
				String sqlUpdatePubliserAddress2 = "UPDATE Publishers SET address_2 = '" + updateVariable 
						+ "' WHERE publisher_id = '" + id + "';";
				System.out.println("Publisher Address 2 update "
						+ DbConnection.queryDatabase(sqlUpdatePubliserAddress2));
				MainInterface.mainPage();
		    	}
			else if (userInput.equals("5") || userInput.equals("5.")) {
				System.out.println("Enter Book ID of record to be updated");
				id = updatePublisherScanner.nextLine();
				System.out.println();
				System.out.println("Enter New Address 3");
				updateVariable = updatePublisherScanner.nextLine();
				String sqlUpdatePubliserAddress3 = "UPDATE Publishers SET address_3 = '" + updateVariable 
						+ "' WHERE publisher_id = '" + id + "';";
				System.out.println("Publisher Address 3 update "
						+ DbConnection.queryDatabase(sqlUpdatePubliserAddress3));
				MainInterface.mainPage();
		    	}
			else if (userInput.equals("6") || userInput.equals("6.")) {
				System.out.println("Enter Book ID of record to be updated");
				id = updatePublisherScanner.nextLine();
				System.out.println();
				System.out.println("Enter New Address Town");
				updateVariable = updatePublisherScanner.nextLine();
				String sqlUpdatePublisherAddressTown = "UPDATE Publishers SET address_town = '" + updateVariable 
						+ "' WHERE publisher_id = '" + id + "';";
				System.out.println("Publisher Address Town update "
						+ DbConnection.queryDatabase(sqlUpdatePublisherAddressTown));
				MainInterface.mainPage();
		    	}
			else if (userInput.equals("7") || userInput.equals("7.")) {
				System.out.println("Enter Book ID of record to be updated");
				id = updatePublisherScanner.nextLine();
				System.out.println();
				System.out.println("Enter New Publisher Address County");
				updateVariable = updatePublisherScanner.nextLine();
				String sqlUpdatePublisherAddressCounty = "UPDATE Publishers SET address_county = '" + updateVariable 
						+ "' WHERE publisher_id = '" + id + "';";
				System.out.println("Publisher AddressCounty update "
						+ DbConnection.queryDatabase(sqlUpdatePublisherAddressCounty));
				MainInterface.mainPage();
		    	}
			else if (userInput.equals("8") || userInput.equals("8.")) {
				System.out.println("Enter Book ID of record to be updated");
				id = updatePublisherScanner.nextLine();
				System.out.println();
				System.out.println("Enter New Publisher Postcode");
				updateVariable = updatePublisherScanner.nextLine();
				String sqlUpdatePublisherPostcode = "UPDATE Publishers SET address_postcode = '" + updateVariable 
						+ "' WHERE publisher_id = '" + id + "';";
				System.out.println("Book Publisher Postcode update "
						+ DbConnection.queryDatabase(sqlUpdatePublisherPostcode));
				MainInterface.mainPage();
		    	}
			else {
				System.out.println("Please make a valid selection.");
			}
		}
	}
}