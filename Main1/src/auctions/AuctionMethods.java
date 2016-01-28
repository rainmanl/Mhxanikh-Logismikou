package auctions;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import mainProgram.DBconnect;
import mainProgram.Error;
import mainProgram.MainMethods;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class AuctionMethods {

	/**
	 * method of auction creation
	 * 
	 * @param itemname
	 * @param startbid
	 * @param category
	 */
	public static void createauction(String itemname, String startbid, String category, long date) {
		Connection conn = null;
		PreparedStatement statement = null;
		PreparedStatement statement1 = null;
		String user = MainMethods.loggeduser();

		try {
			conn = DBconnect.connect();
			statement1 = conn.prepareStatement("SELECT * FROM auctions");

			statement1.execute();

			String query = "INSERT INTO auctions (name, category, startbid, creator, time) VALUES (?,?,?,?,?)";
			statement = conn.prepareStatement(query);

			statement.setString(1, itemname);
			statement.setString(2, category);
			statement.setString(3, startbid);
			statement.setString(4, user);
			statement.setLong(5, date);

			statement.execute();

		} catch (SQLException e) {
			e.printStackTrace();
			@SuppressWarnings("unused")
			Error error = new Error();
		} finally {
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
	 * method of auction editing
	 * 
	 * @param name
	 * @param newname
	 * @param bid
	 * @param cat
	 */
	public static void editauction(String name, String newname, String bid, String cat) {
		try {
			Connection conn = DBconnect.connect();
			String name1 = null;

			String query = "SELECT name FROM auctions WHERE name=? ";
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, name);

			statement.execute();

			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				name1 = rs.getString("name");
			}

			if (name.equals(name1)) {
				String query1 = "UPDATE auctions SET name=?, startbid=?, category=?, lastbid=? WHERE name=?";

				try {

					PreparedStatement statement1 = conn.prepareStatement(query1);

					statement1.setString(1, newname);
					statement1.setString(2, bid);
					statement1.setString(3, cat);
					statement1.setString(4, name);
					statement1.setString(5, bid);

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
	 * method of auction deleting
	 * 
	 * @param name
	 */
	public static void deleteauction(String name) {
		try {

			Connection conn = DBconnect.connect();

			String name1 = null;
			String user = MainMethods.loggeduser();

			String query = "SELECT name FROM auctions WHERE name=? ";
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, name);

			statement.execute();

			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				name1 = rs.getString("name");
			}

			if (name.equals(name1)) {

				String query1 = "DELETE FROM auctions WHERE name=? and creator = ?";

				try {

					PreparedStatement statement1 = conn.prepareStatement(query1);
					statement1.setString(1, name);
					statement1.setString(2, user);

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
			e.printStackTrace();
			@SuppressWarnings("unused")
			Error error = new Error();
		}
		DBconnect.closeconn();
	}

	/**
	 * method that shows categories list on a table
	 * 
	 * @param table
	 */
	public static void catlist(JTable table) {

		Connection conn = null;
		String query = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		String[] tableColumnsName = { "Category Names" };
		DefaultTableModel aModel = (DefaultTableModel) table.getModel();
		aModel.setColumnIdentifiers(tableColumnsName);

		try {
			conn = DBconnect.connect();
			query = "SELECT * FROM category";
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

	/**
	 * method that shows on a table, the auctions created by connected user
	 * 
	 * @param table
	 */
	public static void showmyauction(JTable table) {
		Connection conn = null;
		String query = null;
		PreparedStatement statement = null;
		ResultSet rs = null;

		String[] tableColumnsName = { "Name", "category", "Starting Bid" };
		DefaultTableModel aModel = (DefaultTableModel) table.getModel();
		aModel.setColumnIdentifiers(tableColumnsName);

		String user = MainMethods.loggeduser();

		try {
			conn = DBconnect.connect();
			query = "SELECT name, category, startbid FROM auctions WHERE creator =?";
			statement = conn.prepareStatement(query);
			statement.setString(1, user);
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
	 * 
	 * method that searches auctions via category or/and via price range and
	 * shows it in a table
	 * 
	 * @param table
	 * @param category
	 * @param above
	 * @param below
	 */
	public static void search(JTable table, String category, String lowprice, String highprice) {

		Connection conn = null;

		String[] tableColumnsName = { "Auction names", "Starting Bid", "Time Remaining", "Creator", "Higher Bid" };
		DefaultTableModel aModel = (DefaultTableModel) table.getModel();
		aModel.setColumnIdentifiers(tableColumnsName);

		if (highprice.isEmpty() && lowprice.isEmpty()) {

			try {
				conn = DBconnect.connect();
				String query = "SELECT name, startbid, time, creator, lastbid FROM auctions WHERE category = ?";
				PreparedStatement statement = conn.prepareStatement(query);
				statement.setString(1, category);
				statement.execute();

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

		} else if (highprice.isEmpty()) {
			highprice = "999999";
			try {
				conn = DBconnect.connect();
				String query = "SELECT name, startbid, time, creator, lastbid FROM auctions WHERE category = ? AND startbid BETWEEN ? AND ?";
				PreparedStatement statement = conn.prepareStatement(query);
				statement.setString(1, category);
				statement.setString(2, lowprice);
				statement.setString(3, highprice);
				statement.execute();

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
		} else if (lowprice.isEmpty()) {
			lowprice = "0";
			try {
				conn = DBconnect.connect();
				String query = "SELECT name, startbid, time, creator, lastbid FROM auctions WHERE category = ? AND startbid BETWEEN ? AND ?";
				PreparedStatement statement = conn.prepareStatement(query);
				statement.setString(1, category);
				statement.setString(2, lowprice);
				statement.setString(3, highprice);
				statement.execute();

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
		} else {
			try {
				conn = DBconnect.connect();
				String query = "SELECT name, startbid, time, creator, lastbid FROM auctions WHERE category = ? AND startbid BETWEEN ? AND ?";
				PreparedStatement statement = conn.prepareStatement(query);
				statement.setString(1, category);
				statement.setString(2, lowprice);
				statement.setString(3, highprice);
				statement.execute();

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

	}

	/**
	 * 
	 * method that saves the last bidder in the selected auction and also saves
	 * the bid price
	 * 
	 * @param auction
	 */
	public static void bid(String auction, String bid) {
		try {
			Connection conn = DBconnect.connect();
			String user = MainMethods.loggeduser();
			int higher = 0;
			int newbid = Integer.parseInt(bid);

			String query = "SELECT lastbid FROM auctions WHERE name=? ";
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, auction);

			statement.execute();

			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				higher = rs.getInt("lastbid");
			}

			if (higher < newbid) {
				try {
					String query1 = "UPDATE auctions SET lastbidder=?, lastbid = ?, sumofbidders=sumofbidders+1 WHERE name=? ";
					PreparedStatement statement1 = conn.prepareStatement(query1);
					statement1.setString(1, user);
					statement1.setString(2, bid);
					statement1.setString(3, auction);

					statement1.execute();

				} catch (SQLException e1) {
					e1.printStackTrace();
					@SuppressWarnings("unused")
					Error error = new Error();
					DBconnect.closeconn();
				}
			} else {
				@SuppressWarnings("unused")
				Error error = new Error();
			}

		} catch (SQLException e) {
			e.printStackTrace();
			@SuppressWarnings("unused")
			Error error = new Error();
			DBconnect.closeconn();
		}
		DBconnect.closeconn();

	}

}
