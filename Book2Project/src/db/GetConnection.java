package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GetConnection {
	public static Connection getConnection() throws ClassNotFoundException {
		Connection connection = null;
		Class.forName("com.mysql.cj.jdbc.Driver");
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/doctor", "root", "");
			System.out.println("Connection Established...");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;

	}
}
