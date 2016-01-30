import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

public class Auction {
	@SuppressWarnings("unused")
	private String myItemName, myCategory;
	@SuppressWarnings("unused")
	private float myBid;
	private int myId;
	@SuppressWarnings("unused")
	private java.util.Date myExpDate;
	private User myCreator, myHighestBidder;

	private Auction(String itemName, float bid, String category, Date expDate, int id, String creator,
			String highestBidder) {
		myItemName = itemName;
		myBid = bid;
		myCategory = category;
		myExpDate = expDate;
		myId = id;
		myCreator = User.retrieve(creator);
		myHighestBidder = User.retrieve(highestBidder);
	}

	private static Auction[] loadAuctions(ResultSet resultSet) throws SQLException {
		// loads every Auction from a ResultSet (the result of a query) into
		// Auction objects

		ArrayList<Auction> auctionList = new ArrayList<Auction>();
		while (resultSet.next()) {
			String itemName = resultSet.getString("name");
			float bid = resultSet.getFloat("lastbid");
			String category = resultSet.getString("category");
			Date expDate = new Date(resultSet.getLong("time"));
			int id = resultSet.getInt("id");
			String creator = resultSet.getString("creator");
			String highestBidder = resultSet.getString("lastbidder");

			auctionList.add(new Auction(itemName, bid, category, expDate, id, creator, highestBidder));
		}
		Auction[] auctionArray = auctionList.toArray(new Auction[auctionList.size()]);
		// converts ArrayList to Array which then returns

		return auctionArray;
	}

	public static Auction[] checkTimeout() { // checks which auctions have
												// expired and returns them

		Auction[] auctionArray = null;
		Connection conn = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		try {
			conn = DbConnector.connection();

			String query = "SELECT * FROM auctions WHERE time < ?";
			statement = conn.prepareStatement(query);
			statement.setLong(1, (new Date()).getTime());
			resultSet = statement.executeQuery();

			auctionArray = Auction.loadAuctions(resultSet);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (resultSet != null)
				try {
					resultSet.close();
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
				}
		}
		return auctionArray;
	}

	public static void delete(int id) { // delete auction entry from db

		Connection conn = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		try {
			conn = DbConnector.connection();

			String query = "DELETE FROM auctions WHERE id = ?";
			statement = conn.prepareStatement(query);
			statement.setInt(1, id);
			statement.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (statement != null)
				try {
					statement.close();
				} catch (Exception e) {
				}
			if (resultSet != null)
				try {
					resultSet.close();
				} catch (Exception e) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (Exception e) {
				}
		}
	}

	public void processAuction() { // processed expired actions
		@SuppressWarnings("unused")
		boolean sold = false;
		if (myHighestBidder != null) {
			sold = Payment.process(myCreator.getBankAccount(), myHighestBidder.getCreditCard());
		}
		delete(myId);
	}
}