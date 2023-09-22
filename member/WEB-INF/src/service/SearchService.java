package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import data.Customer;

public class SearchService {
	public List<Customer> searchCustomer (String gender,String blood) {
		String dbName = "system_user";
		String dbPropaties = "?cvharacterEncoding=UTF-8&serverTimezone=JST";
		String dbUrl ="jdbc:mySQL://localhost:3306/" + dbName +dbPropaties;
		String dbUser =  "root";
		String dbPassword = "admin";
		//先程作成したcustomerテーブルのレコードを取得するためのSQL文
		String sql = "select * from customer where gender =? and blood=?;";
		//取得したレコードを件数ぶん格納するためのList<customer>型の変数coustomerListを生成
		List<Customer>customerList = new ArrayList<Customer>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection coon = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
			PreparedStatement ps = coon.prepareStatement(sql);
			//プリペアステートメントでマイページで選択した値を代入
			ps.setString(1, gender);
			ps.setString(2, blood);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Customer customer = new Customer();
				customer.setId(rs.getInt("id"));
				customer.setPassword(rs.getString("password"));
				customer.setEmail(rs.getString("email"));
				customer.setName(rs.getString("name"));
				customer.setGender(rs.getString("gender"));
				customer.setBlood(rs.getString("blood"));
				customer.setOld(rs.getInt("old"));
				customer.setMemo(rs.getString("memo"));
				//レコードの件数分customerListに追加する
				customerList.add(customer);
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return customerList;
	}

public List<Customer> searchCustomer (String id) {
	// idをキーに顧客情報DBから習得する    DBにアクセスしIDをキーにレコードを取得する
			String dbName = "system_user";
			String dbPropaties = "?cvharacterEncoding=UTF-8&serverTimezone=JST";
			String dbUrl ="jdbc:mySQL://localhost:3306/" + dbName +dbPropaties;
			String dbUser =  "root";
			String dbPassword = "admin";
			//先程作成したcustomerテーブルのレコードを取得するためのSQL文
			String sql = "select * from customer where id=?;";
			List<Customer>customerList = new ArrayList<Customer>();
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection coon = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
				PreparedStatement ps = coon.prepareStatement(sql);
				//プリペアステートメントでマイページで選択した値を代入
				ps.setString(1, id);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					Customer customer = new Customer();
					customer.setId(rs.getInt("id"));
					customer.setEmail(rs.getString("email"));
					customer.setPassword(rs.getString("password"));
					customer.setName(rs.getString("name"));
					customer.setGender(rs.getString("gender"));
					customer.setBlood(rs.getString("blood"));
					customer.setOld(rs.getInt("old"));
					customer.setMemo(rs.getString("memo"));
					//レコードの件数分customerListに追加する
					customerList.add(customer);
				}
			} catch (SQLException | ClassNotFoundException e) {
				e.printStackTrace();
			}
			return customerList;
		}


public List<Customer> searchallCustomer() {
	// idをキーに顧客情報DBから習得する    DBにアクセスしIDをキーにレコードを取得する
			String dbName = "system_user";
			String dbPropaties = "?cvharacterEncoding=UTF-8&serverTimezone=JST";
			String dbUrl ="jdbc:mySQL://localhost:3306/" + dbName +dbPropaties;
			String dbUser =  "root";
			String dbPassword = "admin";
			//先程作成したcustomerテーブルのレコードを取得するためのSQL文
			List<Customer>customerList = new ArrayList<Customer>();
			Connection coon = null;
			try {
				Class.forName("com.mysql.jdbc.Driver");
				coon = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
				Statement ps = coon.createStatement();
				String sql = "select * from customer;";
				ResultSet rs = ps.executeQuery(sql);
				while (rs.next()) {
					Customer customer = new Customer();
					customer.setId(rs.getInt("id"));
					customer.setEmail(rs.getString("email"));
					customer.setPassword(rs.getString("password"));
					customer.setName(rs.getString("name"));
					customer.setGender(rs.getString("gender"));
					customer.setBlood(rs.getString("blood"));
					customer.setOld(rs.getInt("old"));
					customer.setMemo(rs.getString("memo"));
					//レコードの件数分customerListに追加する
					customerList.add(customer);
				}
			} catch (SQLException | ClassNotFoundException e) {
				e.printStackTrace();
			}
			return customerList;
		}
}
