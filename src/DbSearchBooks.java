import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DbSearchBooks {

	public static String searchBooks (String sqlQuery) throws FileNotFoundException {
		
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
			
			System.out.println("BOOK ID:\tTITLE:\t\tDESCRIPTION:\tGENRE:\tPRICE:\tAUTHOR ID:"
					+ "\tPUBLISHER ID:\tPUBLISH DATE:\t\tEDITION:\t\tQUANTITY:\t");
			
			while (rset.next()) {
				String id = rset.getString("id");
				String title = rset.getString("title");
				String description = rset.getString("description");
				String genre = rset.getString("genre");
				String price = rset.getString("price");
				String author_id = rset.getString("author_id");
				String publisher_id = rset.getString("publisher_id");
				String publish_date = rset.getString("publish_date");
				String edition = rset.getString("edition");
				String qty = rset.getString("qty");

				System.out.println(id + "\t\t" + title + "\t\t" + description + "\t"
											+ genre + "\t" + price + "\t" + author_id
											+ "\t" + publisher_id + "\t" + publish_date
											+ "\t" + edition + "\t" + qty);
				++rowCount;
			}

			System.out.println("Total records = " + rowCount);

			} catch (SQLException ex) {
				ex.printStackTrace();
				}
		
		return "Executed";
	}
}