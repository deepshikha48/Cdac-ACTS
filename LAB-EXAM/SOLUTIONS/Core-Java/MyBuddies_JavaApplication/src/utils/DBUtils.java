package utils;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DBUtils {

	// add static method to get FIXED DB connection from D.M
		public static Connection fetchDBConnection() throws Exception {
			// To avoid hard coding of DB specific config details
			Properties p = new Properties();
			try (FileReader fin = new FileReader("db.properties")) {
				p.load(fin);
			}
			// load
			Class.forName(p.getProperty("jdbc.driver"));
			// connection
			return DriverManager.getConnection(p.getProperty("jdbc.url"), p.getProperty("jdbc.userName"),
					p.getProperty("jdbc.password"));
		}


}
