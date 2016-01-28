package mainProgram;

import java.sql.*;

import admin.Admin;
import mainProgram.Error;
import user.User;

public class MainMethods {
	public static String user = null;
	public static String admin = null;

	/**
	 * method of connecting the user
	 * 
	 * @param usr
	 * @param pw
	 */
	public static void usrlogin(String usr, String pw) {
		try {
			Connection conn = DBconnect.connect();

			String query = "SELECT username, password FROM users WHERE username = ? AND password = ?";

			PreparedStatement statement = conn.prepareStatement(query);

			statement.setString(1, usr);
			statement.setString(2, pw);
			statement.execute();

			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				user = rs.getString("username");
			}

			if (user != null) {
				@SuppressWarnings("unused")
				User userwin = new User();

			} else {
				@SuppressWarnings("unused")
				Error error = new Error();
			}

		} catch (SQLException e) {

			e.printStackTrace();
			@SuppressWarnings("unused")
			Error error = new Error();

		}
		DBconnect.closeconn();
	}

	/**
	 * method which saves the connected username
	 * 
	 * @return
	 */
	public static String loggeduser() {
		return user;

	}

	/**
	 * method that disconnects the user
	 */
	public static void userlogout() {
		user = null;

	}

	/**
	 * method that connects the administrator
	 * 
	 * @param usr
	 * @param pw
	 */
	public static void adminlogin(String usr, String pw) {

		if (usr.equals("admin") && pw.equals("admin")) {

			@SuppressWarnings("unused")
			Admin Admin = new Admin();
		} else {
			@SuppressWarnings("unused")
			Error error = new Error();

		}
	}

	/**
	 * method that disconnects the administrator
	 */
	public static void adminlogout() {
		admin = null;
	}

	/**
	 * method of user creation
	 * 
	 * @param usr
	 * @param pw
	 * @param mail
	 * @param addr
	 * @param mbl
	 */
	public static void createuser(String usr, String pw, String mail, String addr, String mbl) {

		Connection conn = null;
		String query = null;
		String query1 = null;
		PreparedStatement statement = null;
		PreparedStatement statement1 = null;

		try {
			conn = DBconnect.connect();
			query = "INSERT INTO users (username, password, email, address, mobile, score) VALUES (?, ?, ?, ?, ?, 0)";
			query1 = "INSERT INTO paymentinfo (username) VALUES (?)";

			statement = conn.prepareStatement(query);
			statement.setString(1, usr);
			statement.setString(2, pw);
			statement.setString(3, mail);
			statement.setString(4, addr);
			statement.setString(5, mbl);

			statement.execute();

			statement1 = conn.prepareStatement(query1);
			statement1.setString(1, usr);
			statement1.execute();

		} catch (SQLException e) {

			e.printStackTrace();
			@SuppressWarnings("unused")
			Error error = new Error();

		} finally {

			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {

					e.printStackTrace();
				}
			}

			if (conn != null) {
				DBconnect.closeconn();
			}

		}

	}

}
