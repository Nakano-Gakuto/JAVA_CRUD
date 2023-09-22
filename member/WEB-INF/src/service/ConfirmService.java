package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConfirmService {
	public void confirmCustomer (String email,String password,String name,String gender,String blood,String old,String memo) {
		String dbName = "system_user";
		String dbPropaties = "?cvharacterEncoding=UTF-8&serverTimezone=JST";
		String dbUrl ="jdbc:mySQL://localhost:3306/" + dbName +dbPropaties;
		String dbUser =  "root";
		String dbPassword = "admin";
		//先程作成したcustomerテーブルのレコードを取得するためのSQL文
		String sql = "insert into customer (email,password,name,gender,blood,old,memo)value (?,?,?,?,?,?,?);";
		try {
			//MySQL に接続する
			Class.forName("com.mysql.jdbc.Driver");
			//データベースに接続
			Connection coon = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
			//変数sqlのクエスチョンマークに？代入する値をセットする
			PreparedStatement ps = coon.prepareStatement(sql);
			//プリペアステートメントでマイページで選択した値を代入
			ps.setString(1, email);
			ps.setString(2, password);
			ps.setString(3, name);
			ps.setString(4, gender);
			ps.setString(5, blood);
			ps.setString(6, old);
			ps.setString(7, memo);
			ps.executeUpdate();
			ps.close();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
