package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
	public static Connection con = null;
	private static Database instance = new Database();

	public static Database getInstance() {
		return instance;
	}

	public static void connect() {
		String url = "jdbc:sqlserver://localhost:50333 ;databasename=QuanLyBangDia";
		String user = "sa";
		String password = "1";
		try {
			con = DriverManager.getConnection(url, user, password);
		} catch (SQLException s) {
			s.printStackTrace();
		}
	}

	public static void disconnect() {
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static Connection getConnection() {
		connect();

		return con;
	}

}

