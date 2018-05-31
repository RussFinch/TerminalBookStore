import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DbSearchAuthors {
	
	public static String searchAuthors (String sqlQuery) throws FileNotFoundException {
		
		String fileScanUser = "";
		String fileScanPass = "";
		String DbUrlString = "jdbc:mysql://win81-desktop.home.local:3306/ebookstore?useSSL=FALSE";
		
		File inputFile = new File("/Users/russellfincham/documents/temp/MySqlLogin.txt");
		Scanner fileScanner = new Scanner(new FileInputStream(inputFile), "UTF-8");
		
	    fileScanUser = fileScanner.nextLine();
	    fileScanPass = fileScanner.nextLine(); 
	    fileScanner.close();
		
		try (
			Connection conn = DriverManager.getConnection(DbUrlString, fileScanUser, fileScanPass);
			Statement stmt = conn.createStatement();
				
			) {
			
			System.out.println("The SQL Query is: " + sqlQuery);
			System.out.println();
			
			ResultSet rset = stmt.executeQuery(sqlQuery);
			
			int rowCount = 0;
			
			System.out.println("AUTHOR ID:\tAUTHOR NAME:\tAUTHOR SURNAME:");
			
			while (rset.next()) {
				String author_id = rset.getString("author_id");
				String author_firstname = rset.getString("author_firstname");
				String author_surname = rset.getString("author_surname");

				System.out.println(author_id + "\t\t" + author_firstname + "\t\t" + author_surname);
				++rowCount;
			}

			System.out.println("Total records = " + rowCount);

			} catch (SQLException ex) {
				ex.printStackTrace();
				}
		
		return "Executed";
	}
}