package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Cart;
import model.Product;
import model.User;
import model.Order;

public enum OrderDAO {
	instance;
	public Connection connection = null;

	private void closeCon() {
		try {
			if (connection != null) {
				connection.close();
				connection = null;
			}
		} catch (Exception e) {

		}
	}

	public void addtocart(int productID,int quantity,int userID) {
		Connection connection = Utils.getConnection();
          
		 try { 
			 PreparedStatement psmt = connection .prepareStatement(
		  "INSERT INTO customer_order (productID,Amount,Customer_id) VALUES (?, ?, ?)"); 
		 psmt.setInt(1,productID); 
		 psmt.setInt(2,quantity); 
		 psmt.setInt(3, userID);
		 
		  psmt.executeUpdate();
		  }
		 catch (SQLException e) 
		 { e.printStackTrace();
		  }
		 
	}

	public List<Order> getOrders(int userId) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		List<Order> orders = new ArrayList<Order>();

		Connection connection = Utils.getConnection();
		try {
			String sql = "SELECT * FROM Customer_order WHERE Customer_id = ?";
			PreparedStatement psmt = connection.prepareStatement(sql);
			psmt.setInt(1, userId);

			ResultSet rs = psmt.executeQuery();
			while (rs.next()) {
				int orderId = rs.getInt("id");
				int amount = rs.getInt("Amount");
                int productId=rs.getInt("productID");
				String ProductName = ProductDAO.instance
						.getProductName(productId);
				double ProductPrice = ProductDAO.instance
						.getProductPrice(productId);
				double totalPrice = amount * ProductPrice;
				Product product = ProductDAO.instance.get(productId);
				Order line = new Order(orderId,amount,totalPrice, product);
				//Order line = OrderDAO.instance.getOrder(orderId);
				orders.add(line);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return orders;
	}
	
	public void RemoveItems(int orderID,int userId) {
		Connection connection = Utils.getConnection();
		try {
			String sql = "DELETE FROM Customer_order WHERE Customer_id = ? and id= ? ";
			System.out.println(sql);
			PreparedStatement psmt = connection.prepareStatement(sql);
			psmt.setInt(1, userId);
			psmt.setInt(2, orderID);
			psmt.executeUpdate(); 
			
	}catch (SQLException e) {
		e.printStackTrace();
	}



	}

	public void updateQuantity(int id, int quantity) {
		
		Connection connection = Utils.getConnection();
		try {
			String sql = "UPDATE Customer_order SET Amount= ? WHERE id= ? ";
			System.out.println(sql);
			PreparedStatement psmt = connection.prepareStatement(sql);
			psmt.setInt(1, quantity);
			psmt.setInt(2, id);
			psmt.executeUpdate(); 
			
	}catch (SQLException e) {
		e.printStackTrace();
	}

	}

	public void RemoveAllItems(int userId) {
		Connection connection = Utils.getConnection();
		try {
			String sql = "DELETE FROM Customer_order WHERE Customer_id = ? ";
			System.out.println(sql);
			PreparedStatement psmt = connection.prepareStatement(sql);
			psmt.setInt(1, userId);
			
			psmt.executeUpdate(); 
			
	}catch (SQLException e) {
		e.printStackTrace();
	}

		
	}

}
