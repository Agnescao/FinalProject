/**
 * 
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Caolei
 *
 */
public enum CategoryDAO {
	instance;
	public int getId(String categoryName) {
		Connection connection = Utils.getConnection();
		int categoryId = 0;
		try {
			String sql = "SELECT * FROM category WHERE Name = ?";
			PreparedStatement psmt = connection.prepareStatement(sql);
			psmt.setString(1, categoryName);
			ResultSet rs = psmt.executeQuery();
			rs.next();
			categoryId = rs.getInt("id");

		} catch (SQLException e) {
			System.out.println("categoryName: " + categoryName);
			e.printStackTrace();
		}

		return categoryId;
	}

}
