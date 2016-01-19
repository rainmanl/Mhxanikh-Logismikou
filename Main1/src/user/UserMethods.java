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
	 * μεθοδος δημιουργιας χρηστη
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

	/**
	 * μεθοδος επεξεργασιας χρηστη
	 * 
	 * @param usr
	 * @param pw
	 * @param mail
	 * @param addr
	 * @param mbl
	 */
	public static void edituser(String pw, String mail, String addr, String mbl) {

		Connection conn = DBconnect.connect();
		String user = MainMethods.loggeduser();

		if (user != null) {

			String query1 = "UPDATE users SET password=?, email=?, address=?, mobile=? WHERE username=?";

			try {
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
			;
		}

		DBconnect.closeconn();
	}

	/**
	 * μεθοδος διαγραφης χρηστη
	 * 
	 * @param usr
	 * @param pw
	 */
	public static void deleteuser(String usr, String pw) {

		Connection conn = DBconnect.connect();
		String query = "SELECT username, password FROM users WHERE username=?";

		try {

			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, usr);
			statement.setString(2, pw);
			statement.execute();

			ResultSet rs = statement.executeQuery();

			String user = null;
			@SuppressWarnings("unused")
			String pass = null;

			while (rs.next()) {

				user = rs.getString("username");
				pass = rs.getString("password");
			}

			if (user != null) {

				String query1 = "DELETE FROM users WHERE username=? AND password=?";

				try {

					PreparedStatement statement1 = conn.prepareStatement(query1);
					statement1.setString(1, usr);
					statement1.setString(2, pw);

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

		} catch (SQLException e) {
			@SuppressWarnings("unused")
			Error error = new Error();

		}

		DBconnect.closeconn();

	}

	/**
	 * μεθοδος εισαγωγης στοιχειων χρεωσης/πιστωσης
	 * 
	 * @param card
	 * @param bank
	 */
	public static void payment(String card, String bank) {
		Connection conn = DBconnect.connect();
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
	 * μεθοδος εμφανισης στοιχειων συνδεδεμενου χρηστη
	 * 
	 * @param table
	 */
	public static void viewinfo(JTable table) {
		Connection conn = DBconnect.connect();

		String[] tableColumnsName = { "Username", "Email", "Address", "Mobile", "Rating" };
		DefaultTableModel aModel = (DefaultTableModel) table.getModel();
		aModel.setColumnIdentifiers(tableColumnsName);

		String user = MainMethods.loggeduser();
		try {
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
	 * μεθοδος που αυξανει τη βαθμολογια του επιλεγμενου χρηστη κανα 1(μεγιστο
	 * 100)
	 * 
	 * @param user
	 */
	public static void rating(String user) {
		Connection conn = DBconnect.connect();

		int score = 0;

		try {

			String query = "SELECT score FROM users WHERE username = ?";
			PreparedStatement statement = conn.prepareStatement(query);

			statement.setString(1, user);
			statement.execute();

			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				score = Integer.parseInt(rs.getString("score"));
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
	 * μεθοδος που εμφανιζει λιστα με τους χρηστες και τις βαθμολογιες τους σε
	 * πινακα
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
