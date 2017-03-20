package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public enum CustomerDAO {
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
		public String getName(int userId) {
			Connection connection = Utils.getConnection();
			String name="Lei";
			
			try {
				String sql = "SELECT * FROM Customer where id=?;";
				PreparedStatement psmt = connection.prepareStatement(sql);
				psmt.setInt(1, userId);

				ResultSet rs = psmt.executeQuery();
				if(rs.next()){
					name=rs.getString("Name");
					}else
					{System.err.println("The customer doesn't have any comment!");
					}
				}catch(Exception e){System.err.println("something wrong in database!");}
				return name;
		}

}
