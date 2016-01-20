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
	 * μεθοδος δημιουργιας δημοπρασιας
	 * 
	 * @param itemname
	 * @param startbid
	 * @param category
	 */
	public static void createauction(String itemname, String startbid, String category) {
		Connection conn = null;
		PreparedStatement statement = null;
		PreparedStatement statement1 = null;
		ResultSet rs = null;
		String user = MainMethods.loggeduser();

		int counter = 0;
		// μετραει ποσες σειρες υπαρχουν στον πινακα ωστε καθε νεα δημοπρασια να
		// περνει σωστο id(primary key)

		try {
			conn = DBconnect.connect();
			statement1 = conn.prepareStatement("SELECT * FROM auctions");

			statement1.execute();

			rs = statement1.executeQuery();

			while (rs.next()) {
				counter++;
			}

			String query = "INSERT INTO auctions (id, name, category, startbid, creator) VALUES (?,?,?,?,?)";
			statement = conn.prepareStatement(query);
			statement.setInt(1, counter);
			statement.setString(2, itemname);
			statement.setString(3, category);
			statement.setString(4, startbid);
			statement.setString(5, user);

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
			if (rs != null)
				try {
					rs.close();
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
	 * μεθοδος επεξεργασιας δημοπρασιας
	 * 
	 * @param name
	 * @param newname
	 * @param bid
	 * @param cat
	 */
	public static void auctionedit(String name, String newname, String bid, String cat) {
		Connection conn = DBconnect.connect();
		String name1 = null;

		try {
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
	 * μεθοδος διαγραφης δημοπρασιας
	 * 
	 * @param name
	 */
	public static void deleteauction(String name) {
		Connection conn = DBconnect.connect();

		String name1 = null;
		String user = MainMethods.loggeduser(); 
				
		try {
			String query = "SELECT name FROM auctions WHERE name=? ";
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, name);

			statement.execute();

			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				name1 = rs.getString("name");
			}

			if (name.equals(name1) ){

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
	 * εμφανιση λιστας κατηγοριων σε πινακα
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
			query = "select * from category";
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
	 * μεθοδος που εμφανιζει σε εναν πινακα τις δημοπρασιες του συνδεδεμενου
	 * χρηστη
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
	 * μεθοδος αναζητησης δημοπρασιας βαση κατηγοριας ή/και βαση οριων τιμης και
	 * εμφανιση σε πινακα
	 * 
	 * @param table
	 * @param category
	 * @param above
	 * @param below
	 */
	public static void search(JTable table, String category, String lowprice, String highprice) {
		Connection conn = DBconnect.connect();

		String[] tableColumnsName = { "Auction names", "Starting Bid", "Time Remaining", "Creator", "Higher Bid" };
		DefaultTableModel aModel = (DefaultTableModel) table.getModel();
		aModel.setColumnIdentifiers(tableColumnsName);
		if (lowprice.isEmpty() && highprice.isEmpty()) {
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

		} else {
			try {
				conn = DBconnect.connect();
				String query = "SELECT name, startbid, time, creator, lastbid FROM auctions WHERE category = ? AND startbid >= ? AND startbid <= ?";
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
	 * μεθοδος αποθηκευσης του τελευταιου συμμετεχοντα στην επιλεγμενη
	 * δημοπρασια καθως και του ποσου συμμετοχης
	 * 
	 * @param auction
	 */
	public static void bid(String auction, String bid) {
		Connection conn = DBconnect.connect();
		String user = MainMethods.loggeduser();
		int higher = 0;
		int newbid = Integer.parseInt(bid);
		try {
			String query = "SELECT lastbid FROM auctions WHERE name=? ";
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, auction);

			statement.execute();

			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				higher = Integer.parseInt(rs.getString("lastbid"));
			}

			if (higher <= newbid) {
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
