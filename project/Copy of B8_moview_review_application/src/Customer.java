
public class Customer {

	public void main (String[] args) {
		DB db = new DB();
		db.initiate_db_conn();	
	}
	
	public boolean userLogin(String uname, String pword){
		
		DB db = new DB();// create the DB object
		db.initiate_db_conn();// initiate connection to the DB
		// Validate inputs. Neither username or password can be null
		if ((uname != "") && (pword != ""))
		{
			// If valid inputs - check DB
			if(db.check_login(uname, pword))
				return true;			
		}
		// return false
		return false;
	}
	public boolean userRegister(String uname,String pword,String personName,int age ,String address)
	{
	
		throw new RuntimeException() ;}

}
