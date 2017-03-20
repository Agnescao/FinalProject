/**
 * 
 */
package dao;

import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import model.Order;
import model.Product;

/**
 * @author Caolei
 *
 */
public enum ProductDAO {
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
		
		public void uploadProduct(Product product) {
			// TODO Auto-generated method stub
			Connection connection = Utils.getConnection();
			
			String message = null;  // message will be sent back to client
		    try {
		      PreparedStatement psmt = connection
		          .prepareStatement("INSERT INTO PRODUCT (name, price, description,category_id,photo) VALUES (?, ?, ?,?,?)");
		      psmt.setString(1,product.getName());
		      psmt.setDouble(2,product.getPrice());
		      psmt.setString(3,product.getDescription());
		      psmt.setInt(4,product.getCid());
		      // fetches input stream of the upload file for the blob column
		      psmt.setString(5, product.getImagepath());
	           
		     // psmt.executeUpdate();
		      int row = psmt.executeUpdate();
	            if (row > 0) {
	                message = "File uploaded and saved into database";
	                System.out.println(message);
	            }
		      
		    } catch (SQLException e) {
		    	message = "ERROR: " + e.getMessage();
		        e.printStackTrace();
		    }
		}

		

		public String getProductName(int productId) {
			Connection connection = Utils.getConnection();
			
			String ProductName=null;
			 try {
				 
		         String sql2 = "SELECT * FROM Product WHERE id = ?";
		         PreparedStatement psmt2 = connection.prepareStatement(sql2);
		         psmt2.setInt(1, productId);

		         ResultSet rs2 = psmt2.executeQuery();
		         rs2.next();
		         ProductName = rs2.getString("Name");
		          
		         
		      }  catch (SQLException e) {
		         e.printStackTrace();
		      }
			return ProductName;
		}

		public Product get(int productId) throws IOException, ClassNotFoundException {
			Connection connection = Utils.getConnection();
			Product product=null;
			 int BUFFER_SIZE = 4096;
			try {
				String sql = "SELECT * FROM Product WHERE id = ?";
				PreparedStatement psmt = connection.prepareStatement(sql);
				psmt.setInt(1, productId);

				ResultSet rs = psmt.executeQuery();
				
	            
				if(rs.next()){
					String name=rs.getString("Name");
					String description=rs.getString("Description");
					double price=rs.getDouble("Price");
					 
					
					
					product =new Product(productId,name,description,price);
					
					
					}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
          
			return product;
		}

		/*public int getProductId(int orderId) {
			Connection connection = Utils.getConnection();
			int ProductId=0;
			try {
				 String sql = "SELECT * FROM ordered_product WHERE Customer_order_id = ?";
		         PreparedStatement psmt = connection.prepareStatement(sql);
		         psmt.setInt(1, orderId);

		         ResultSet rs = psmt.executeQuery();
		         rs.next();
		         ProductId = rs.getInt("Product_id");
			} catch (SQLException e) {
			e.printStackTrace();
		}
			return ProductId;
		}*/

		public double getProductPrice(int productId) {
			
			Connection connection = Utils.getConnection();
			double ProductPrice=0;
			try {
				 String sql = "SELECT * FROM Product WHERE id = ?";
		         PreparedStatement psmt = connection.prepareStatement(sql);
		         psmt.setInt(1, productId);

		         ResultSet rs = psmt.executeQuery();
		         rs.next();
		         ProductPrice = rs.getDouble("Price");
			} catch (SQLException e) {
			e.printStackTrace();
		}
			return ProductPrice;
		}

		public List<Product> getGearProduct() {
			List<Product> products = new ArrayList<Product>();

			Connection connection = Utils.getConnection();
			try {
				String sql = "SELECT * FROM PRODUCT WHERE Category_id = 1";
				PreparedStatement psmt = connection.prepareStatement(sql);
				

				ResultSet rs = psmt.executeQuery();
				while (rs.next()) {
					int ProductId = rs.getInt("id");
					String  Name = rs.getString("Name");
	                Double price=rs.getDouble("Price");
	                String description=rs.getString("Description");
	                InputStream image = rs.getBinaryStream("photo");
	               // byte[] image= rs.getBytes("photo");
	                
	                
					Product line =new Product(ProductId,Name,price,description,image);
					products.add(line);
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}

			return products;
		}

		public List<Product> getMenProduct() {
			
			List<Product> products = new ArrayList<Product>();

			Connection connection = Utils.getConnection();
			try {
				String sql = "SELECT * FROM PRODUCT WHERE Category_id = 3";
				PreparedStatement psmt = connection.prepareStatement(sql);
				

				ResultSet rs = psmt.executeQuery();
				while (rs.next()) {
					int ProductId = rs.getInt("id");
					String  Name = rs.getString("Name");
	                Double price=rs.getDouble("Price");
	                String description=rs.getString("Description");
	                InputStream image = rs.getBinaryStream("photo");
	               // byte[] image= rs.getBytes("photo");
	                
	                
					Product line =new Product(ProductId,Name,price,description,image);
					products.add(line);
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}

			return products;
		}

		public List<Product> getWomenProduct() {
			List<Product> products = new ArrayList<Product>();

			Connection connection = Utils.getConnection();
			try {
				String sql = "SELECT * FROM PRODUCT WHERE Category_id = 2";
				PreparedStatement psmt = connection.prepareStatement(sql);
				

				ResultSet rs = psmt.executeQuery();
				while (rs.next()) {
					int ProductId = rs.getInt("id");
					String  Name = rs.getString("Name");
	                Double price=rs.getDouble("Price");
	                String description=rs.getString("Description");
	                InputStream image = rs.getBinaryStream("photo");
	               // byte[] image= rs.getBytes("photo");
	                
	                
					Product line =new Product(ProductId,Name,price,description,image);
					products.add(line);
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}

			return products;
		}

		public List<Product> getProducts(String name) {
			Connection connection = Utils.getConnection();
			List<Product> products = new ArrayList<Product>();

			try {
				PreparedStatement psmt = connection
						.prepareStatement("SELECT * FROM PRODUCT;");

				ResultSet rs = psmt.executeQuery();
				while (rs.next()) {
					if (rs.getString("Name").contains(name)) {
						Product m = new Product(rs.getInt("id"),
								rs.getString("Name"),rs.getString("Description"),rs.getDouble("Price"));
						
						
						products.add(m);
					}

				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
			return products;
		
		}

	

}
