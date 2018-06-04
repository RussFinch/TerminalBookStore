import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.Scanner;

public class SetupInterface {

	public static void setupPage() throws FileNotFoundException, SQLException {
		
		String userInput = "";
		Scanner setupPageScanner = BookStoreMain.keyInput;
		
		System.out.println("\n*****  Setup Page *****");
		System.out.println();
		System.out.println("1. Build Database");
		System.out.println("2. Upload Data");
		System.out.println();
		System.out.println("0. Main Menu");
		System.out.println("Please enter selection: ");

		while (setupPageScanner.hasNextLine()) {
			userInput = setupPageScanner.nextLine();
			if (userInput.equals("1") || userInput.equals("1.")) {
				System.out.println(DbSetupManager.dbSetup());
		    	}
			else if (userInput.equals("2") || userInput.equals("2.")) {
				UploadDataInterface.uploadPage();
		    	}
			else if (userInput.equals("0") || userInput.equals("0.")) {
				MainInterface.mainPage();
				}
			else {
				System.out.println("Invalid Selection:");
				System.out.println("Please enter a valid selection: ");
			}
		}
	}
}
