package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

class Utils {
   public static Connection getConnection() {
	    Connection con = null;
	  // Statement prepareStatement = null;		
      try
		{
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://localhost:3307/sportinggoods";
			con = DriverManager.getConnection(url, "root", "admin");
		//	prepareStatement = con.createStatement();
		}
		catch(Exception e)
		{
			System.out.println("Error: Failed to connect to database\n"+e.getMessage());
		}
	
      return con;
   }
}


