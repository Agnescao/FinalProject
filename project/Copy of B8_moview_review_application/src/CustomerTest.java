import junit.framework.TestCase;


public class CustomerTest extends TestCase {
	
	// Test no.: 1
	// Test Objective: Test user login (correct user name and password entered)
	// Input(s): String username = jonny, String password = b33b0p
	// Expected Outputs: login success (boolean true)
	public void testLogin(){
		// Create customer object
		Customer customer = new Customer();
		// Test the method
		assertTrue(customer.userLogin("jonny", "b33b0p"));	
	}
	 // Test no.: 2
	// Test Objective: Test user Register (correct user name and password entered)
	// Input(s): String username = lei1,String password = 123,String personName=agnes,
	// int age=21,String address=36 glen
	// Expected Outputs: Register failed (boolean false,product code has not been written yet)
	public void testRegister()
	{

		// Create customer object
		Customer customer = new Customer();
		// Test the method
		assertTrue(customer.userRegister("lei1", "123", "agnes", 21, "36 glen"));
	}
	

	
	
}
