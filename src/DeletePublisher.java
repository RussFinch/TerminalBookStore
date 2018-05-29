import java.io.FileNotFoundException;
import java.util.Scanner;

public class DeletePublisher {
	
	public static void deletePublisherMenu() throws FileNotFoundException {
	
		//  This needs completing
		
		//  Scanner Variable
		String userInput = "";
		Scanner deletePublisherScanner = BookStoreMain.keyInput;
		
		System.out.println("\n*****  Delete Publisher  *****");
		System.out.println("0.  Main Menu - at any time");
		while (deletePublisherScanner.hasNextLine()) {
			userInput = deletePublisherScanner.nextLine();
			if (userInput.equals("0") || userInput.equals("0.")) {
				MainInterface.mainPage();
		    	}
			else {
				System.out.println("Publisher ID cannot be blank.  Please enter.");
			}
		}
	}
}
