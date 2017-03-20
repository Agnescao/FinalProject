package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Book;

public enum ProductDAO {
   instance;

   public Book save(Book product) {
      Connection connection = Utils.getConnection();

      try {
         PreparedStatement psmt = connection.prepareStatement(
               "INSERT INTO BOOK (name, price) VALUES (?,?)",
               Statement.RETURN_GENERATED_KEYS);
         psmt.setString(1, product.getBookname());
         psmt.setDouble(2, product.getPrice());
         psmt.executeUpdate();

         ResultSet rs = psmt.getGeneratedKeys();
         rs.next();
         int id = rs.getInt(1);
         product.setId(id);
      } catch (SQLException e) {
         e.printStackTrace();
      }
      return product;
   }

   public List<Book> list() {
      Connection connection = Utils.getConnection();

      List<Book> productList = new ArrayList<Book>();
      try {
         PreparedStatement psmt = connection
               .prepareStatement("SELECT * FROM BOOK");

         ResultSet rs = psmt.executeQuery();

         while (rs.next()) {
            Book p = new Book(rs.getInt("id"), rs.getString("bookname"), rs.getDouble("price"), rs.getString("author"), rs.getString("publish"), rs.getInt("amount"));
            productList.add(p);
         }
      } catch (SQLException e) {
         e.printStackTrace();
      }
      return productList;
   }
   
   public List<Book> checklist(String n) {
	      Connection connection = Utils.getConnection();

	      List<Book> productList = new ArrayList<Book>();
	      try {
	         PreparedStatement psmt = connection
	               .prepareStatement("SELECT * FROM BOOK");
	       //  psmt.setString(1, n);
	         ResultSet rs = psmt.executeQuery();

	         while (rs.next()) {
	        	 if(rs.getString("bookname").contains(n)){
	            Book p = new Book(rs.getInt("id"), rs.getString("bookname"), rs.getDouble("price"), rs.getString("author"), rs.getString("publish"), rs.getInt("amount"));
	            productList.add(p);}
	         }
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }
	      return productList;
	   }

   public Book get(int bookId) {
      Book book = null;

      Connection connection = Utils.getConnection();
      try {
         String sql = "SELECT * FROM Book WHERE ID = ?";
         PreparedStatement psmt = connection.prepareStatement(sql);
         psmt.setInt(1, bookId);
         ResultSet rs = psmt.executeQuery();
         rs.next();

         String name = rs.getString("BOOKNAME");
         Double price = rs.getDouble("PRICE");
         String author= rs.getString("author");
         String publish=rs.getString("publish");
         int amount=rs.getInt("amount");
         book = new Book(bookId,name,price,author,publish,amount);
      } catch (SQLException e) {
         e.printStackTrace();
      }
      return book;
   }

}
