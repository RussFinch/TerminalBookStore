import java.util.Scanner;

public class UserInterface {
	
	public static void mainPage() {
		
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("\n1. Enter book");
		System.out.println("2. Update book");
		System.out.println("3. Delete book");
		System.out.println("4. Search books");
		System.out.println("0. Exit");
		System.out.println("\nPlease enter selection:\n");

		while (keyboard.hasNextLine()) {
			String userInput = keyboard.nextLine();
		
		if (userInput.equals("1") || userInput.equals("1.")) {
		    System.out.println("Enter Book:");
		    }
		if (userInput.equals("2") || userInput.equals("2.")) {
		    System.out.println("Update Book:");
		    }
		if (userInput.equals("3") || userInput.equals("3.")) {
		    System.out.println("Delete Book:");
		    }
		if (userInput.equals("4") || userInput.equals("4.")) {
		    System.out.println("Search Book:");
		    }
		if (userInput.equals("0") || userInput.equals("0.")) {
		    System.out.println("Exit:");
		    }
		else {
		    System.out.println("Invalid Selection:");
		    }
		keyboard.close();
		}
	}
}
