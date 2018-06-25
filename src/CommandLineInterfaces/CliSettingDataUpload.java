package CommandLineInterfaces;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.Scanner;

import DBInterfaces.DbDataUploadManager;
import Main.KeyScanner;

public class CliSettingDataUpload {

	public static void uploadPage() throws FileNotFoundException, SQLException {
		
		String userInput = "";
		Scanner uploadPageScanner = KeyScanner.keyInput;
		
		System.out.println("\n*****  Data Upload Page *****");
		System.out.println();
		System.out.println("1. Upload Books");
		System.out.println("2. Upload Authors");
		System.out.println("3. Upload Publishers");
		System.out.println("4. Upload Genre");
		System.out.println("5. Upload Users");
		System.out.println("6. Upload System Settings");
		System.out.println();
		System.out.println("7. Settings");
		System.out.println("0. Main Page");
		System.out.println();
		System.out.println("Please enter selection: ");

		while (uploadPageScanner.hasNextLine()) {
			userInput = uploadPageScanner.nextLine();
			if (userInput.equals("1") || userInput.equals("1.")) {
				System.out.println(DbDataUploadManager.booksDataUpload());
				CliSettingDataUpload.uploadPage();
		    	}
			else if (userInput.equals("2") || userInput.equals("2.")) {
				System.out.println(DbDataUploadManager.authorsDataUpload());
				CliSettingDataUpload.uploadPage();
		    	}
			else if (userInput.equals("3") || userInput.equals("3.")) {
				System.out.println(DbDataUploadManager.publishersDataUpload());
				CliSettingDataUpload.uploadPage();
		    	}
			else if (userInput.equals("4") || userInput.equals("4.")) {
				System.out.println(DbDataUploadManager.genreDataUpload());
				CliSettingDataUpload.uploadPage();
		    	}
			else if (userInput.equals("5") || userInput.equals("5.")) {
				System.out.println(DbDataUploadManager.userDataUpload());
				CliSettingDataUpload.uploadPage();
		    	}
			else if (userInput.equals("6") || userInput.equals("6.")) {
				System.out.println(DbDataUploadManager.settingsDataUpload());
				CliSettingDataUpload.uploadPage();
		    	}
			else if (userInput.equals("7") || userInput.equals("7.")) {
				CliSettingsDataUploadSettings.uploadSettingsPage();
				CliSettingDataUpload.uploadPage();
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
