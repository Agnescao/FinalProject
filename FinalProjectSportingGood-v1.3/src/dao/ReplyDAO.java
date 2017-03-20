package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Order;
import model.Reply;

public enum ReplyDAO {
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
		public void addReply(int commnetId, String reply) {
			Connection connection = Utils.getConnection();
	          
			 try { 
				 PreparedStatement psmt = connection .prepareStatement(
			  "INSERT INTO REPLY (CommentID,reply) VALUES ( ?, ?)"); 
			 psmt.setInt(1,commnetId); 
			 psmt.setString(2,reply); 
			
			 
			  psmt.executeUpdate();
			  }
			 catch (SQLException e) 
			 { e.printStackTrace();
			  }
			 
		}
		public List<Reply> getReply(int commentId) {
			List<Reply> replys = new ArrayList<Reply>();

			Connection connection = Utils.getConnection();
			try {
				String sql = "SELECT * FROM REPLY where CommentID=?;";
				PreparedStatement psmt = connection.prepareStatement(sql);
				psmt.setInt(1, commentId);
				ResultSet rs = psmt.executeQuery();
				while (rs.next()) {
					int id=rs.getInt("id");
					int commentID=rs.getInt("CommentID");
					String reply=rs.getString("reply");
					Reply r=new Reply(id, commentID,reply);
					replys.add(r);
					
					
				}
				}catch (SQLException e) {
					e.printStackTrace();
				}
		
			 return replys;
		}
             
              
}
