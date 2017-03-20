package dao;

import model.Book;
import model.Order;
import model.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public enum OrderDAO {
	  instance;
	  
	public void submitorder(myCart mycart,User user){
		 Connection connection = Utils.getConnection();
		  try { PreparedStatement psmt = connection.prepareStatement(
               "INSERT INTO USERORDER VALUES (null,?,?,0)",
               Statement.RETURN_GENERATED_KEYS);
         psmt.setInt(1, user.getId());
		 psmt.setDouble(2, mycart.getTotalPrice());		
         psmt.executeUpdate();
         ResultSet rs = psmt.getGeneratedKeys();
         rs.next();
         int orderid = rs.getInt(1);
		 ArrayList al=mycart.showMyCart();
		 for(int i=0;i<al.size();i++){
			 Book book=(Book)al.get(i);
			 PreparedStatement psmt1 = connection.prepareStatement(
					 "insert into ORDERDETAILS values(null,?,?,?)",
		               Statement.RETURN_GENERATED_KEYS);
			 psmt1.setInt(1, orderid);
		     psmt1.setInt(2, book.getId());	
             psmt1.setInt(3, book.getShoppingnums());				 
             psmt1.executeUpdate();
		 }

      } catch (SQLException e) {
         e.printStackTrace();
      }
		  //throw new RuntimeExceotion(e.getMessage());
      //return mycart;
   }
	public List<Order > checkorder(int userid) {
	      Connection connection = Utils.getConnection();

	      List<Order> orders = new ArrayList<Order>();
	      try {
	         PreparedStatement psmt = connection
	               .prepareStatement("SELECT * FROM USERORDER where user_id=?");
	         psmt.setInt(1, userid);
	         ResultSet rs = psmt.executeQuery();

	         while (rs.next()) {
	        	 
	            Order p = new Order(rs.getInt("id"), rs.getInt("user_id"), rs.getDouble("totalprice"), rs.getInt("payornot"));
	            orders.add(p);
	         }
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }
	      return orders;
	   }

}
