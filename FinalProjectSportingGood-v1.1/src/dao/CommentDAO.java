package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Comment;
import model.Order;
import model.Product;

public enum CommentDAO {
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
	public void create(String m){
		Connection connection = Utils.getConnection();
		 try { 
			 PreparedStatement psmt = connection .prepareStatement(
		  "INSERT INTO comments (comments) VALUES (?)"); 
		 psmt.setString(1,m); 
		
		  psmt.executeUpdate();
		  System.out.println("save message !");
		  }
		 catch (SQLException e) 
		 { e.printStackTrace();
		  }
		 
	}

	public List<Comment> getComments(int userid){
		List<Comment> c = new ArrayList<Comment>();

		Connection connection = Utils.getConnection();
		try {
			String sql = "SELECT * FROM Comments where userid=?;";
			PreparedStatement psmt = connection.prepareStatement(sql);
			psmt.setInt(1, userid);

			ResultSet rs = psmt.executeQuery();
			while (rs.next()) {
				int Id = rs.getInt("id");
				
				String m = rs.getString("comments");
				String d=rs.getString("date");
				Comment line=new Comment(Id,m,d);
				c.add(line);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return c;
	}	
	
      public void delete(int id){
    	  Connection connection = Utils.getConnection(); 
    	  try {
  			String sql = "DELETE FROM comments WHERE  id= ? ;";
  			System.out.println(sql);
  			PreparedStatement psmt = connection.prepareStatement(sql);
  			psmt.setInt(1, id);
  			psmt.executeUpdate(); 
    	  }catch (SQLException e) {
    			e.printStackTrace();
    		}
      }
}
