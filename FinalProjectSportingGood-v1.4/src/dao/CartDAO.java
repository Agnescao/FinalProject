package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import model.Cart;
import model.Order;

public enum CartDAO {
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
		
		
	
		public Cart save(Cart cart) {
			// TODO Auto-generated method stub
			Connection connection = Utils.getConnection();

		      try {
		         PreparedStatement psmt = connection.prepareStatement(
		               "INSERT INTO Cart (NAME) VALUES (?)",
		               Statement.RETURN_GENERATED_KEYS);
		         psmt.setString(1, cart.getName());
		         psmt.executeUpdate();
		         ResultSet rs = psmt.getGeneratedKeys();
		         rs.next();
		         int id = rs.getInt(1);
		         cart.setId(id);

		      } catch (SQLException e) {
		         e.printStackTrace();
		      }
		     return cart;
		}
		public Cart get(int cartId) {
		      Cart cart = null;

		      Connection connection = Utils.getConnection();
		      try {
		         String sql = "SELECT * FROM Cart WHERE ID = ?";
		         PreparedStatement psmt = connection.prepareStatement(sql);
		         psmt.setInt(1, cartId);

		         ResultSet rs = psmt.executeQuery();
		         rs.next();
		         String name = rs.getString("name");
		         cart = new Cart(cartId, name);
		        

		      } catch (SQLException e) {
		         e.printStackTrace();
		      }
		      return cart;
		   }
	
		public model.Cart getFromUserId(int id) {
			Cart cart = null;

		      Connection connection = Utils.getConnection();
		      try {
		         String sql = "SELECT * FROM Customer_cart WHERE Customer_id = ?";
		         PreparedStatement psmt = connection.prepareStatement(sql);
		         psmt.setInt(1, id);

		         ResultSet rs = psmt.executeQuery();
		         rs.next();
		         int cartId = rs.getInt("CART_ID");
		         cart = this.get(cartId);
		      } catch (SQLException e) {
		         e.printStackTrace();
		      }
		      return cart;
		}
	

		public String getCartNameByUserId(int userId) {
			// TODO Auto-generated method stub
		String cartName = null;

		      Connection connection = Utils.getConnection();
		      try {
		         String sql = "SELECT * FROM Customer_cart WHERE Customer_id = ?";
		         PreparedStatement psmt = connection.prepareStatement(sql);
		         psmt.setInt(1, userId);

		         ResultSet rs = psmt.executeQuery();
		         rs.next();
		         int cartId = rs.getInt("CART_ID");
		         cartName = this.getName(cartId);
		      } catch (SQLException e) {
		         e.printStackTrace();
		      }
			return cartName;
		}


		private String getName(int cartId) {
			// TODO Auto-generated method stub
			String cartName = null;

		      Connection connection = Utils.getConnection();
		      try {
		         String sql = "SELECT * FROM cart WHERE id = ?";
		         PreparedStatement psmt = connection.prepareStatement(sql);
		         psmt.setInt(1, cartId);

		         ResultSet rs = psmt.executeQuery();
		         rs.next();
		       ;
		     cartName = rs.getString("name");
		      } catch (SQLException e) {
		         e.printStackTrace();
		      }
			return cartName;
			
		}
}
