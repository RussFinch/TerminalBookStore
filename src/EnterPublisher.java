import java.io.FileNotFoundException;
import java.util.Scanner;

public class EnterPublisher {
	
	public static void enterPublisherMenu() throws FileNotFoundException {
	
		//  This needs completing
		
		//  Scanner Variable
		String userInput = "";
		Scanner enterPublisherScanner = BookStoreMain.keyInput;
		
		System.out.println("\n*****  Enter Publisher  *****");
		System.out.println("0.  Main Menu - at any time");
		while (enterPublisherScanner.hasNextLine()) {
			userInput = enterPublisherScanner.nextLine();
			if (userInput.equals("0") || userInput.equals("0.")) {
				MainInterface.mainPage();
		    	}
			else {
				System.out.println("Publisher ID cannot be blank.  Please enter.");
			}
		}
	}
}