package CommandLineInterfaces;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.Scanner;

import DBInterfaces.DbSetupManager;
import Main.KeyScanner;

public class CliSettings {

	public static void setupPage() throws FileNotFoundException, SQLException {
		
		String userInput = "";
		Scanner setupPageScanner = KeyScanner.keyInput;
		
		System.out.println("\n*****  Settings Page *****");
		System.out.println();
		System.out.println("1. Database Access");
		System.out.println("2. Build Database Schema");
		System.out.println("3. Upload Data");
		System.out.println("4. Users  -  Needs Completing");
		System.out.println();
		System.out.println("0. Main Menu");
		System.out.println("Please enter selection: ");

		while (setupPageScanner.hasNextLine()) {
			userInput = setupPageScanner.nextLine();
			if (userInput.equals("1") || userInput.equals("1.")) {
				CliSettingsDbAccess.dbAccessConfig();
				}
			else if (userInput.equals("2") || userInput.equals("2.")) {
				System.out.println(DbSetupManager.dbSetup());
				CliSettings.setupPage();
		    	}
			else if (userInput.equals("3") || userInput.equals("3.")) {
				CliSettingDataUpload.uploadPage();
		    	}
//			else if (userInput.equals("4") || userInput.equals("4.")) {
//				CliSettingsDbAccess.dbAccessConfig();
//		    	}
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
