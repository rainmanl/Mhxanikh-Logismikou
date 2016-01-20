package mainProgram;

import java.sql.*;

import admin.Admin;
import mainProgram.Error;
import user.User;

public class MainMethods {
	public static String user = null;
	public static String admin = null;

	/**
	 * ������� ��� ������� ������
	 * 
	 * @param usr
	 * @param pw
	 */
	public static void usrlogin(String usr, String pw) {
		Connection conn = DBconnect.connect();

		try {
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
	 * ������� ��� �������� ��� ���������� ������������ ������
	 * 
	 * @return
	 */
	public static String loggeduser() {
		return user;

	}

	/**
	 * ������� ��� ���������� ������
	 */
	public static void userlogout() {
		user = null;

	}

	/**
	 * ������� ��� ������� ��� �����������
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
	 * ������� ��� ���������� ��� �����������
	 */
	public static void adminlogout() {
		admin = null;
	}

}
