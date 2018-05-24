import java.io.FileNotFoundException;

public class BookStoreMain {

	public static void main(String args[]) throws FileNotFoundException {
		
		String userState = "loggedOut";
		int loginTries = 0;
		
		for (loginTries=0; loginTries<=2; loginTries++) {
			if (userState.equals("loggedOut")) {
				userState = Login.run();
				}
			else if (userState.equals("loggedIn")) {
				System.out.println("You've logged in");
				UserInterface.mainPage();
				break;
				}
		}
	}	
}