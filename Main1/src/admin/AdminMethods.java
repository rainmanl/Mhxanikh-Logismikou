package admin;

import java.sql.*;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import mainProgram.DBconnect;
import mainProgram.Error;

public class AdminMethods {

	/**
	 * method of creating a category
	 * 
	 * @param cat
	 */
	public static void catcreate(String cat) {

		try {

			Connection conn = DBconnect.connect();
			String query = "INSERT INTO category(name) VALUES (?)";
			PreparedStatement statement;

			statement = conn.prepareStatement(query);
			statement.setString(1, cat);
			statement.execute();

		} catch (SQLException e1) {
			e1.printStackTrace();
			@SuppressWarnings("unused")
			Error error = new Error();

		}

		DBconnect.closeconn();

	}

	/**
	 * method of category deletion
	 * 
	 * @param cat
	 */
	public static void catdelete(String cat) {

		try {
			Connection conn = DBconnect.connect();
			String query = "DELETE FROM category WHERE name = ?";
			PreparedStatement statement;

			statement = conn.prepareStatement(query);
			statement.setString(1, cat);
			statement.execute();

		} catch (SQLException e1) {
			e1.printStackTrace();
			@SuppressWarnings("unused")
			Error error = new Error();

		}

		DBconnect.closeconn();

	}

	/**
	 * method of editing a category
	 */
	public static void catedit(String name, String newname) {

		if (name != null) {
			try {

				Connection conn = DBconnect.connect();
				String query = "UPDATE category SET name=? WHERE name = ?";
				PreparedStatement statement;

				statement = conn.prepareStatement(query);
				statement.setString(1, newname);
				statement.setString(2, name);
				statement.execute();

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
	 * method of editing/setting the duration of the auctions
	 * 
	 * @param time
	 */
	public static void timeset(long date) {

		try {
			Connection conn = DBconnect.connect();
			String query = "UPDATE auctions SET time=?";
			PreparedStatement statement;

			statement = conn.prepareStatement(query);
			statement.setLong(1, date);
			statement.execute();

		} catch (SQLException e1) {
			e1.printStackTrace();
			@SuppressWarnings("unused")
			Error error = new Error();

		}

		DBconnect.closeconn();
	}

	/**
	 * method that shows full auction list
	 * 
	 * @param table
	 */
	public static void auctionlist(JTable table) {

		Connection conn = null;
		String query = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		String[] tableColumnsName = { "Auction Names", "Category", "Start Bid", "Time", "Creator", "Last Bidder",
				"Last Bid", "Sum" };
		DefaultTableModel aModel = (DefaultTableModel) table.getModel();
		aModel.setColumnIdentifiers(tableColumnsName);

		try {
			conn = DBconnect.connect();
			query = "SELECT name, category, startbid, time, creator, lastbidder, lastbid, sumofbidders FROM auctions";

			statement = conn.prepareStatement(query);

			statement.execute();
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

	/**
	 * here are the methods for enabling/disabling the rating function on users
	 * practically this method, enables or disables the "Rate User" button in
	 * user.User.java
	 *
	 */
	public static String bool = null;

	public static void getbuttonstate() {
		Connection conn = null;
		String query = null;
		PreparedStatement statement = null;
		ResultSet rs = null;

		try {
			conn = DBconnect.connect();
			query = "SELECT state FROM ratingonoff WHERE id = ?";
			statement = conn.prepareStatement(query);
			statement.setString(1, "1");
			statement.execute();

			rs = statement.executeQuery();

			while (rs.next()) {
				bool = rs.getString("state");
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
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
	}

	public static void enablerate() {
		Connection conn = null;
		String query = null;
		PreparedStatement statement = null;
		ResultSet rs = null;

		try {
			conn = DBconnect.connect();
			query = "SELECT state FROM ratingonoff WHERE id = ?";
			statement = conn.prepareStatement(query);
			statement.setString(1, "1");
			statement.execute();

			rs = statement.executeQuery();

			while (rs.next()) {
				bool = rs.getString("state");
			}

			if (bool.equals("false")) {
				String query1 = null;
				PreparedStatement statement1 = null;
				try {

					query1 = "UPDATE ratingonoff SET state = ?  WHERE id = ?";

					statement1 = conn.prepareStatement(query1);
					statement1.setString(1, "true");
					statement1.setString(2, "1");
					statement1.execute();

					bool = "true";
				} catch (SQLException e1) {
					e1.printStackTrace();
					@SuppressWarnings("unused")
					Error error = new Error();
				} finally {
					if (statement1 != null)
						try {
							statement.close();
						} catch (Exception e) {
						}
				}

			} else {
				@SuppressWarnings("unused")
				Error error = new Error();
			}

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

	}

	public static void disablerate() {
		Connection conn = null;
		String query = null;
		PreparedStatement statement = null;
		ResultSet rs = null;

		try {
			conn = DBconnect.connect();
			query = "SELECT state FROM ratingonoff WHERE id = ?";
			statement = conn.prepareStatement(query);
			statement.setString(1, "1");
			statement.execute();

			rs = statement.executeQuery();

			while (rs.next()) {
				bool = rs.getString("state");
			}

			if (bool.equals("true")) {
				String query1 = null;
				PreparedStatement statement1 = null;
				try {

					query1 = "UPDATE ratingonoff SET state = ?  WHERE id = ?";

					statement1 = conn.prepareStatement(query1);
					statement1.setString(1, "false");
					statement1.setString(2, "1");
					statement1.execute();

					bool = "false";
				} catch (SQLException e1) {
					e1.printStackTrace();
					@SuppressWarnings("unused")
					Error error = new Error();
				} finally {
					if (statement1 != null)
						try {
							statement.close();
						} catch (Exception e) {
						}
				}

			} else {
				@SuppressWarnings("unused")
				Error error = new Error();
			}

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

	}

	public static void buttonset(JButton button) {
		if (bool.equals("true")) {
			button.setEnabled(true);
		} else {
			button.setEnabled(false);
		}
	}
}
