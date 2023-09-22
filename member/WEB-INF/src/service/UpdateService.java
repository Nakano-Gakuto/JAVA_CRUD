package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateService {
	public  void updateCustomer (String id,String email,String password,String name,String gender,String blood,String memo) {
		String dbName = "system_user";
		String dbPropaties = "?cvharacterEncoding=UTF-8&serverTimezone=JST";
		String dbUrl ="jdbc:mySQL://localhost:3306/" + dbName +dbPropaties;
		String dbUser =  "root";
		String dbPassword = "admin";
		String sql ="update customer set email=?, password=?, name=?, gender=?, blood=?, memo=? where id=?;";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection coon = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
			PreparedStatement ps = coon.prepareStatement(sql);
			//プリペアステートメントでマイページで選択した値を代入
			ps.setString(1, email);
			ps.setString(2, password);
			ps.setString(3, name);
			ps.setString(4, gender);
			ps.setString(5, blood);
			ps.setString(6, memo);
			ps.setString(7, id);
			ps.executeUpdate();
			ps.close();
	        coon.close();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
