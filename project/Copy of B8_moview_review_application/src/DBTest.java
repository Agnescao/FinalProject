import junit.framework.TestCase;


public class DBTest extends TestCase {
	
	// Test no.: 1
	// Test Objective: Test database connection
	// Input(s): none
	// Expected Outputs: connected to database successfully (boolean true)
	public void testConnection(){
		// Create DB object
		DB db = new DB();
		// Test the method
		assertTrue(db.initiate_db_conn());		
	}
	
	
	// Test no.: 2
	// Test Objective: Test user login (check database username and passowrd) valid values
	// Input(s): String username, String password
	// Expected Outputs: connected to database successfully (boolean true)
	public void testLogin(){
		// Create DB object
		DB db = new DB();
		// connect to the db
		db.initiate_db_conn();
		// Test the method
		assertTrue(db.check_login("jonny", "b33b0p"));	
	}
	
	
	// Test no.: 3
	// Test Objective: Test user login (check database username and passowrd) invalid values
	// Input(s): Invalid String username, String password
	//				Invalid values = String null or String > 20 chars
	// Expected Outputs: Exception, with message sent to user console
	public void testLoginInvalid(){
		// Create DB object
		DB db = new DB();
		// connect to the db
		db.initiate_db_conn();
		// Test the method
		assertFalse(db.check_login("", ""));		
	}
	

	// Test no.: 4
	// Test Objective: Test database insert for register feature
	// Input(s): String, String, String, int, String
	// Expected Outputs: true
	public void testInsert(){
		// Create Login object
		DB db = new DB();
		// Test the method
		db.initiate_db_conn();
		assertTrue(db.DBregister("dd","123","ss",21,"ww"));		
	}
	 

}
