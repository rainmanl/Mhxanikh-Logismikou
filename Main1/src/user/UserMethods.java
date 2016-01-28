package user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import mainProgram.*;
import mainProgram.Error;

public class UserMethods {

	/**
	 * method of editing user
	 * 
	 * @param usr
	 * @param pw
	 * @param mail
	 * @param addr
	 * @param mbl
	 */
	public static void edituser(String pw, String mail, String addr, String mbl) {

		Connection conn = null;
		try {
			conn = DBconnect.connect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String user = MainMethods.loggeduser();

		if (user != null) {

			try {

				String query1 = "UPDATE users SET password=?, email=?, address=?, mobile=? WHERE username=?";
				PreparedStatement statement1 = conn.prepareStatement(query1);

				statement1.setString(1, pw);
				statement1.setString(2, mail);
				statement1.setString(3, addr);
				statement1.setString(4, mbl);
				statement1.setString(5, user);

				statement1.execute();

			} catch (SQLException e1) {

				e1.printStackTrace();

				@SuppressWarnings("unused")
				Error error = new Error();

			}
		} else {
			@SuppressWarnings("unused")
			Error error = new Error();
		}

		DBconnect.closeconn();
	}

	/**
	 * method of deleting a user
	 * 
	 * @param usr
	 * @param pw
	 */
	public static void deleteuser(String usr, String pw) {

		try {
			Connection conn = DBconnect.connect();
			String query = "SELECT username, password FROM users WHERE username=?";
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, usr);
			statement.execute();

			ResultSet rs = statement.executeQuery();

			String user = null;
			String pass = null;

			while (rs.next()) {

				user = rs.getString("username");
				pass = rs.getString("password");
			}

			if (user != null) {

				String query1 = "DELETE FROM users WHERE username=? AND password=?";
				String query2 = "DELETE FROM paymentinfo WHERE username = ?";

				try {

					PreparedStatement statement1 = conn.prepareStatement(query1);
					PreparedStatement statement2 = conn.prepareStatement(query2);

					statement1.setString(1, user);
					statement1.setString(2, pass);

					statement2.setString(1, user);

					statement1.execute();
					statement2.execute();

				} catch (SQLException e) {

					e.printStackTrace();
					@SuppressWarnings("unused")
					Error error = new Error();
				}
			} else {
				@SuppressWarnings("unused")
				Error error = new Error();
			}

		} catch (SQLException e) {
			@SuppressWarnings("unused")
			Error error = new Error();

		}

		DBconnect.closeconn();

	}

	/**
	 * method of inserting payment information
	 * 
	 * @param card
	 * @param bank
	 */
	public static void payment(String card, String bank) {
		Connection conn = null;
		try {
			conn = DBconnect.connect();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String user = MainMethods.loggeduser();
		if (user != null) {

			String query1 = "UPDATE paymentinfo SET cardnumber=?, bankaccnumber=? WHERE username=?";

			try {

				PreparedStatement statement1 = conn.prepareStatement(query1);
				statement1.setString(1, card);
				statement1.setString(2, bank);
				statement1.setString(3, user);

				statement1.execute();

			} catch (SQLException e) {

				e.printStackTrace();
				@SuppressWarnings("unused")
				Error error = new Error();
			}
		} else {
			@SuppressWarnings("unused")
			Error error = new Error();

		}
		DBconnect.closeconn();
	}

	/**
	 * χρηστη method that shows the connected user information
	 * 
	 * @param table
	 */
	public static void viewinfo(JTable table) {

		String[] tableColumnsName = { "Username", "Email", "Address", "Mobile", "Rating" };
		DefaultTableModel aModel = (DefaultTableModel) table.getModel();
		aModel.setColumnIdentifiers(tableColumnsName);

		try {

			Connection conn = DBconnect.connect();
			String user = MainMethods.loggeduser();
			String query = "SELECT username, email, address, mobile, score FROM users WHERE username =?";
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, user);
			ResultSet rs = statement.executeQuery();

			ResultSetMetaData meta = rs.getMetaData();
			int colNo = meta.getColumnCount();

			while (rs.next()) {
				Object[] objects = new Object[colNo];
				for (int i = 0; i < colNo; i++) {
					objects[i] = rs.getObject(i + 1);
				}
				aModel.addRow(objects);
			}

			table.setModel(aModel);
		} catch (SQLException e) {
			e.printStackTrace();
			@SuppressWarnings("unused")
			Error error = new Error();
		}
		DBconnect.closeconn();
	}

	/**
	 * method that increases the score of selected user by 1(max 100)
	 * 
	 * @param user
	 */
	public static void rating(String user) {

		int score = 0;

		try {

			Connection conn = DBconnect.connect();
			String query = "SELECT score FROM users WHERE username = ?";
			PreparedStatement statement = conn.prepareStatement(query);

			statement.setString(1, user);
			statement.execute();

			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				score = rs.getInt("score");
			}

			if (user != null && score < 100) {

				String query1 = "UPDATE users SET score=score+1 WHERE username=?";

				try {

					PreparedStatement statement1 = conn.prepareStatement(query1);
					statement1.setString(1, user);
					statement1.execute();

				} catch (SQLException e1) {

					e1.printStackTrace();
					@SuppressWarnings("unused")
					Error error = new Error();
				}
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
	 * method that shows the user list and their scores on a table
	 * 
	 * @param table
	 */
	public static void showusers(JTable table) {
		Connection conn = null;
		String query = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		String[] tableColumnsName = { "User Names", "Ratings" };
		DefaultTableModel aModel = (DefaultTableModel) table.getModel();
		aModel.setColumnIdentifiers(tableColumnsName);

		try {
			conn = DBconnect.connect();
			query = "select username,score from users";
			statement = conn.prepareStatement(query);
			rs = statement.executeQuery();

			ResultSetMetaData meta = rs.getMetaData();
			int colNo = meta.getColumnCount();

			while (rs.next()) {
				Object[] objects = new Object[colNo];
				for (int i = 0; i < colNo; i++) {
					objects[i] = rs.getObject(i + 1);
				}
				aModel.addRow(objects);
			}

			table.setModel(aModel);
		} catch (SQLException e) {
			e.printStackTrace();
			@SuppressWarnings("unused")
			Error error = new Error();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (Exception e) {
				}
			if (statement != null)
				try {
					statement.close();
				} catch (Exception e) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (Exception e) {
					DBconnect.closeconn();
				}
		}
		DBconnect.closeconn();
	}

}
