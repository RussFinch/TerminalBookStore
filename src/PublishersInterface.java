import java.io.FileNotFoundException;
import java.util.Scanner;

public class PublishersInterface {
	
	public static void PublishersPage() throws FileNotFoundException {
		
		String userInput = "";
		Scanner PublishersPageScanner = BookStoreMain.keyInput;
		
		System.out.println("\n*****  Publishers Page *****");
		System.out.println();
		System.out.println("1. Enter Publisher");
		System.out.println("2. Update Publisher");
		System.out.println("3. Delete Publisher");
		System.out.println("4. Search");
		System.out.println();
		System.out.println("0. Main Menu");
		System.out.println("Please enter selection: ");

		while (PublishersPageScanner.hasNextLine()) {
			userInput = PublishersPageScanner.nextLine();
			if (userInput.equals("1") || userInput.equals("1.")) {
				EnterPublisher.enterPublisherMenu();
		    	}
			else if (userInput.equals("2") || userInput.equals("2.")) {
				UpdatePublisher.updatePublisherMenu();
		    	}
			else if (userInput.equals("3") || userInput.equals("3.")) {
				DeletePublisher.deletePublisherMenu();
		    	}
			else if (userInput.equals("4") || userInput.equals("4.")) {
				Search.searchMenu();
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