package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Cart;
import model.User;
import model.Cart;

public enum UserDAO {
  instance;

  public Connection connection = null;
	private void closeCon(){
		try{
			if(connection!=null){
				connection.close();
				connection=null;
			}
		}catch(Exception e){
			
		}
	}

  public User save(User user) {
	  Connection connection = Utils.getConnection();
     if(user.getName()!="Administrator")
     { try {
      PreparedStatement psmt = connection
          .prepareStatement("INSERT INTO CUSTOMER (name, password, email,phone,address,city_region) VALUES (?, ?, ?,?,?,?)");
      psmt.setString(1, user.getName());
      psmt.setString(2, user.getPassword());
      psmt.setString(3, user.getEmail());
      psmt.setString(4, user.getPhone());
      psmt.setString(5, user.getAddress());
      psmt.setString(6, user.getCity());

      psmt.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
     }else{
    	System.err.println("you are not allowed to create a account with name equal to Administrator !");
    }
     return user;
  }

  public User checkLogin(String name, String password) {
	  Connection connection = Utils.getConnection();
    User user = null ;

    try {
      PreparedStatement psmt = connection
          .prepareStatement("SELECT *FROM customer WHERE NAME = ? AND PASSWORD = ?");
      psmt.setString(1, name);
      psmt.setString(2, password);
      ResultSet rs = psmt.executeQuery();
      if (rs.next()) {
        user = new User(rs.getInt("id"), rs.getString("Name"), rs.getString("Password")) ;
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return user ;
  }
  public void linkCart(User user, Cart cart) {
     /* user.setCart(cart);*/

      Connection connection = Utils.getConnection();
      try {
         PreparedStatement psmt = connection.prepareStatement(
               "INSERT INTO USER_CART (USER_ID, CART_ID) VALUES (?, ?)"
               /*Statement.RETURN_GENERATED_KEYS*/);
         psmt.setInt(1, user.getId());
         psmt.setInt(2, cart.getId());

         psmt.executeUpdate();

      } catch (SQLException e) {
         e.printStackTrace();
      }
      
   }

}
