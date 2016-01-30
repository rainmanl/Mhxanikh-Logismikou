package mainProgram;

import java.sql.*;

public class DBconnect {

	static Connection conn = null;

	/**
	 * method of connecting to the db
	 * 
	 * @return
	 * @throws SQLException
	 */
	public static Connection connect() throws SQLException {

		conn = DriverManager.getConnection("jdbc:mysql://192.168.2.6:3306/mixaniki", "pro", "mixaniki");
		// 91.138.136.187 public server ip | 192.168.2.6 subnet server ip

		return conn;
	}

	/**
	 * method of disconnecting from the db
	 */
	public static void closeconn() {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
