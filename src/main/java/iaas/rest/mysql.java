package iaas.rest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class mysql {
	 public static Connection Connect() {
		 Connection c;
		try {
			c = DriverManager.getConnection("jdbc:mysql://localhost:3306/rest_db", "root", "root");
			return c;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         return null;
	 }
}
