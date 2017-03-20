
import java.sql.*;


public class DB {
	
	// DB Connectivity Attributes
	private Connection con = null;
	private Statement stmt = null;
	private ResultSet rs = null;
	
	
	// Method to initiate the db connection
	public boolean initiate_db_conn()
	{
		try
		{
			// Load the JConnector Driver
			Class.forName("com.mysql.jdbc.Driver");
			//Specify the DB Name
			String url="jdbc:mysql://localhost:3307/B8_agile_assignment";
			//Connect to DB using DB URL, Username and password
			con = DriverManager.getConnection(url, "root", "admin");
			//Create a generic statement which is passed to the TestInternalFrame1
			stmt = con.createStatement();
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Error: Failed to connect to database\n"+e.getMessage());
		}
			return false;		
	}
	
	// Method to make an insertion into the db - this method will be implemented as part of the 
	// * Registration feature - Jonny 06/11/2015
	
	
	
	// Method to check the database when the user enters their username and password to log in to their account
	public boolean check_login(String uname, String pwd)
	{
		try
		{	
			// (READ) Execute the SQL statement "select" for username and password
			// passed into the method and get the results		
			String query= "Select customer_id from details where userName = '" + uname + "' and password = '" + pwd + "';";
			rs = stmt.executeQuery(query);// execute query
			System.out.println(query);
			if(rs.next()){
				System.out.println(rs.getInt("customer_id"));
				return true;// return true for username and password success
			}	
			// Uh-oh, there was an issue! make the user aware of this by printing message to terminal
			else 
				System.out.println("There was an issue with your username or password."
						+ " Please try to log in again or register with us if you do not have an account.");
				return false;// return false for issue with username and/or password
											
		}
		catch(Exception e)
		{
			System.out.println("Error: Failed to connect to database\n"+e.getMessage());
		}	
		return false;// return false
		
	}
	
	public boolean DBregister(String username,String password,String personName ,int age,String address){
		
		//throw new RuntimeException();
	 
	DB db = new DB();
	boolean res=db.check_login(username, password);
	if(res==false){
		try		
		{		
			String updateTemp ="INSERT INTO details VALUES("+null +",'"+username+"','"+password+"','"+personName+"',"+age+",'"+address + "');" ;
            System.out.println(updateTemp);
			stmt.executeUpdate(updateTemp);
			return true;

		}
		catch (SQLException sqle)
		{
			System.err.println("Error with  insert:\n"+sqle.toString());
			return false;
		}
	}
	else
	{
		System.out.println("You have same account exists in database");
		return false;
	}
	}
}




