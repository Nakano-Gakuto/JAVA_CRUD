package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteService {
	public  void deleteCustomer (String id) {
        String dbName = "system_user";
        String dbPropaties = "?cvharacterEncoding=UTF-8&serverTimezone=JST";
        String dbUrl ="jdbc:mySQL://localhost:3306/" + dbName +dbPropaties;
        String dbUser =  "root";
        String dbPassword = "admin";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection coon = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
            String sql = "delete from customer where id=?;";
            PreparedStatement ps = coon.prepareStatement(sql);
            ps.setString(1, id);
            ps.executeUpdate();
            ps.close();
            coon.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
	}
}
