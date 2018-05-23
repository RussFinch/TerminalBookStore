import java.io.FileNotFoundException;

public class BookStoreMain {

	public static void main(String args[]) throws FileNotFoundException {
		
		String userLogin = "loggedOut";
		int loginTries = 0;
		
		for (loginTries=0; loginTries<=3; loginTries++) {
			if (userLogin.equals("loggedOut")) {
				userLogin = Login.run();
			}
			else if (userLogin.equals("loggedIn")) {
				System.out.println("\nyou've logged in.");
				UserInterface.mainPage();
				break;
			}
		}
	}
}	