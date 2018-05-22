
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.Scanner;


public class BookStoreMain {

	public static void main(String args[]) throws FileNotFoundException {
		
		String DbUrlString = "jdbc:mysql://win81-desktop.home.local:3306/?useSSL=FALSE";
		String userName = "";
		String password = "";
		
		Scanner userLogin = new Scanner(System.in);
		System.out.println("Username:  ");
	    userName = userLogin.next();
	    System.out.println("Password:  ");
	    password = userLogin.next();
	    userLogin.close();

		try (
				Connection conn = DriverManager.getConnection(DbUrlString, userName, password);
				Statement stmt = conn.createStatement();
			) {
			
				String sqlCreateDb = "create database if not exists ebookstore";
				System.out.println("The SQL Query is: " + sqlCreateDb);
				int countCreation = stmt.executeUpdate(sqlCreateDb);
				System.out.println(countCreation + " Schemas created");
							
			} catch (SQLException ex) {
				ex.printStackTrace();
				}
			
			}
	}



