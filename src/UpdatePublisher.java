import java.io.FileNotFoundException;
import java.util.Scanner;

public class UpdatePublisher {
	
	public static void updatePublisherMenu() throws FileNotFoundException {
	
		//  This needs completing
		
		//  Scanner Variable
		String userInput = "";
		Scanner updatePublisherScanner = BookStoreMain.keyInput;
		
		System.out.println("\n*****  Update Publisher  *****");
		System.out.println("0.  Main Menu - at any time");
		while (updatePublisherScanner.hasNextLine()) {
			userInput = updatePublisherScanner.nextLine();
			if (userInput.equals("0") || userInput.equals("0.")) {
				MainInterface.mainPage();
		    	}
			else {
				System.out.println("Publisher ID cannot be blank.  Please enter.");
			}
		}
	}
}