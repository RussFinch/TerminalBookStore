import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DbSearchPublishers {
	
	public static String searchPublishers (String sqlQuery) throws FileNotFoundException {
		
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
			
			System.out.println("PUBLISHER ID:\tPUBLISHER NAME:\t\tADDRESS 1:\tADDRESS 2:"
					+ "\tADDRESS 3:\tTOWN:\t\tCOUNTY:\t\tPOSTCODE:\t");
			
			while (rset.next()) {
				String publisher_id = rset.getString("publisher_id");
				String publisher_name = rset.getString("publisher_name");
				String address_1 = rset.getString("address_1");
				String address_2 = rset.getString("address_2");
				String address_3 = rset.getString("address_3");
				String address_town = rset.getString("address_town");
				String address_county = rset.getString("address_county");
				String address_postcode = rset.getString("address_postcode");

				System.out.println(publisher_id + "\t\t" + publisher_name + "\t\t" + address_1 + "\t"
											+ address_2 + "\t" + address_3 + "\t" + address_town
											+ "\t" + address_county + "\t" + address_postcode);
				++rowCount;
			}

			System.out.println("Total records = " + rowCount);

			} catch (SQLException ex) {
				ex.printStackTrace();
				}
		
		return "Executed";
	}

}
