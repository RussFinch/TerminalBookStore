package DBInterfaces;
 
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesInterface {
  
	public static String DbAccessProperties (String newPropertyValue, String value) throws FileNotFoundException {
		
		FileInputStream in = new FileInputStream("/Users/russellfincham/documents/temp/MySqlLogin.txt");
		Properties properties = new Properties();
		
		try {
			properties.load(in);
			in.close();

			FileOutputStream out = new FileOutputStream("/Users/russellfincham/documents/temp/MySqlLogin.txt");
			
			properties.setProperty(newPropertyValue, value);
			properties.store(out, null);
			out.close();
		
		} catch (IOException e) {
			e.printStackTrace();
			}
		
		return "Configuration Updated...";
	}
}
