package admin;

import java.sql.*;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import mainProgram.DBconnect;
import mainProgram.Error;

public class AdminMethods {

	/**
	 * μεθοδος σημιουργιας κατηγοριας
	 * 
	 * @param cat
	 */
	public static void catcreate(String cat) {
		Connection conn = DBconnect.connect();

		try {

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
	 * μεθοδος διαγραφης κατηγοριας
	 * 
	 * @param cat
	 */
	public static void catdelete(String cat) {
		Connection conn = DBconnect.connect();

		try {

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
	 * επεξεργασια κατηγοριας
	 */
	public static void catedit(String name, String newname) {
		Connection conn = DBconnect.connect();
		if (name != null) {
			try {

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
	 * μεθοδος παραμετροποιησης χρονικης διαρκειας δημοπρασιων
	 * 
	 * @param time
	 */
	public static void timeset(String time) {

		Connection conn = DBconnect.connect();

		try {

			String query = "UPDATE auctions SET time=?";
			PreparedStatement statement;

			statement = conn.prepareStatement(query);
			statement.setString(1, time);
			statement.execute();

		} catch (SQLException e1) {
			e1.printStackTrace();
			@SuppressWarnings("unused")
			Error error = new Error();

		}

		DBconnect.closeconn();
	}

	/**
	 * μεθοδος εμγανισης λιστας δημοπρασιων στο παραθυρο των στατιστικων
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
			query = "select name, category, startbid, time, creator, lastbidder, lastbid, sumofbidders from auctions";
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
	 * απο κατω ειναι οι μεθοδοι για ενεργοποιηση/απενεργοποιηση
	 * (enable/disable) της λειτουργιας βαθμολογησης πωλητη απο αλλους χρηστες
	 */
	public static boolean bool = false;

	public static void buttonenable() {

		bool = false;

	}

	public static void buttondisable() {

		bool = true;

	}

	// καλειται στο UI του χρηστη για να θεσει το κουμπι ενεργο ή ανενεργο
	public static void setratings(JButton button) {
		if (bool == true) {
			button.setEnabled(false);
		} else {
			button.setEnabled(true);
		}
	}

}
