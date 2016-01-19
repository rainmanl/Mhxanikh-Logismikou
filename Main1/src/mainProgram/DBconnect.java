package mainProgram;

import java.sql.*;

public class DBconnect {

	static Connection conn = null;

	/**
	 * μεθοδος συνδεσης στη βαση
	 * 
	 * @return
	 */
	public static Connection connect() {
		try {

			conn = DriverManager.getConnection("jdbc:mysql://192.168.2.6:3306/mixaniki", "pro", "mixaniki");
			// 91.138.136.187 public server ip | 192.168.2.6 subnet server ip

		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	/**
	 * μεθοδος για κλεισιμο συνδεσης
	 */
	public static void closeconn() {
		try {
			conn.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

}
