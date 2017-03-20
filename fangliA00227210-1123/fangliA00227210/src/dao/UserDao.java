package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.User;

public enum UserDao {
	

	instance ;
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
	
	public User save(User us){
		Connection connection = Utils.getConnection();
		try{
			
			String sql = "insert into user values(null,?,?,?,?,?,?,?)";
			PreparedStatement st = connection.prepareStatement(sql);
			st.setString(1, us.getName());
			st.setString(2, us.getPassword());	
			st.setString(3, us.getGender());
			st.setString(4, us.getAddress());
			st.setString(5, us.getTelphone());
			st.setString(6, us.getEmail());
			st.setInt(7, us.getGrade());
			System.out.println(sql);
			st.execute();
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			this.closeCon();
		}
		return us;
	}
	
	public User checkLogin(String name, String password) {
		Connection connection = Utils.getConnection();
		User student=null;
		try{	
	         PreparedStatement psmt = connection.prepareStatement("SELECT * FROM USER WHERE NAME = ? AND PASSWORD = ?");
	         psmt.setString(1, name);
	         psmt.setString(2, password);
	         ResultSet rs = psmt.executeQuery();
	         if (rs.next()) {
	             student= new User(rs.getInt("id"),rs.getString("name"),rs.getString("password"),rs.getString("gender"),rs.getString("address"),rs.getString("telephone"),rs.getString("email"),rs.getInt("grade"));
	         }
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }
	      return student;
	   }

}

