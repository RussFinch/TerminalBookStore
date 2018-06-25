package CommandLineInterfaces;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.Scanner;

import DBInterfaces.DbInterface;
import Main.KeyScanner;

public class CliSettingsDataUploadSettings {
	
	public static void uploadSettingsPage() throws FileNotFoundException, SQLException {
		
		String userInput = "";
		Scanner uploadPageScanner = KeyScanner.keyInput;
		
		System.out.println("\n*****  Upload Settings Page *****");
		System.out.println();
		System.out.println("1. Upload Books File Location");
		System.out.println("2. Upload Authors File Location");
		System.out.println("3. Upload Publishers File Location");
		System.out.println("4. Upload Genre File Location");
		System.out.println("5. Upload Users File Location");
		System.out.println("6. Upload System Settings File Location");
		System.out.println();
		System.out.println("0. Main Page");
		System.out.println("Please enter selection: ");

		while (uploadPageScanner.hasNextLine()) {
			userInput = uploadPageScanner.nextLine();
			if (userInput.equals("1") || userInput.equals("1.")) {	
				System.out.println("Enter the filesystem location for your Books file:");
				System.out.println("Example: /Users/username/documents/temp/BooksInput.txt");
				String booksFile = uploadPageScanner.nextLine();
				String sqlQuery = "UPDATE settings SET value = '" + booksFile +"' WHERE setting_name = 'booksUpload'";
				System.out.println(DbInterface.queryDatabase(sqlQuery));
				CliSettingDataUpload.uploadPage();
		    	}
			else if (userInput.equals("2") || userInput.equals("2.")) {
				System.out.println("Enter the filesystem location for your Authors file:");
				System.out.println("Example: /Users/username/documents/temp/AuthorsInput.txt");
				String authorsFile = uploadPageScanner.nextLine();
				String sqlQuery = "UPDATE settings SET value = '" + authorsFile +"' WHERE setting_name = 'authorsUpload'";
				System.out.println(DbInterface.queryDatabase(sqlQuery));
				CliSettingDataUpload.uploadPage();
		    	}
			else if (userInput.equals("3") || userInput.equals("3.")) {
				System.out.println("Enter the filesystem location for your Publishers file:");
				System.out.println("Example: /Users/username/documents/temp/PublishersInput.txt");
				String publishersFile = uploadPageScanner.nextLine();
				String sqlQuery = "UPDATE settings SET value = '" + publishersFile +"' WHERE setting_name = 'publishersUpload'";
				System.out.println(DbInterface.queryDatabase(sqlQuery));
				CliSettingDataUpload.uploadPage();
		    	}
			else if (userInput.equals("4") || userInput.equals("4.")) {
				System.out.println("Enter the filesystem location for your Genre file:");
				System.out.println("Example: /Users/username/documents/temp/GenreInput.txt");
				String GenreFile = uploadPageScanner.nextLine();
				String sqlQuery = "UPDATE settings SET value = '" + GenreFile +"' WHERE setting_name = 'genreUpload'";
				System.out.println(DbInterface.queryDatabase(sqlQuery));
				CliSettingDataUpload.uploadPage();
		    	}
			else if (userInput.equals("5") || userInput.equals("5.")) {
				System.out.println("Enter the filesystem location for your Users file:");
				System.out.println("Example: /Users/username/documents/temp/UsersInput.txt");
				String UsersFile = uploadPageScanner.nextLine();
				String sqlQuery = "UPDATE settings SET value = '" + UsersFile +"' WHERE setting_name = 'usersUpload'";
				System.out.println(DbInterface.queryDatabase(sqlQuery));
				CliSettingDataUpload.uploadPage();
		    	}
			else if (userInput.equals("6") || userInput.equals("6.")) {
				System.out.println("Enter the filesystem location for your Settings file:");
				System.out.println("Example: /Users/username/documents/temp/SettingsInput.txt");
				String settingsFile = uploadPageScanner.nextLine();
				String sqlQuery = "UPDATE settings SET value = '" + settingsFile +"' WHERE setting_name = 'settingsUpload'";
				System.out.println(DbInterface.queryDatabase(sqlQuery));
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
