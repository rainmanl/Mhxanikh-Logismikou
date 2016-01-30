import java.sql.*;

public class User {
	private String myUsername, myCreditCard, myBankAccount;

	private User(String usernname, String creditCard, String bankAccount) {
		myUsername = usernname;
		myCreditCard = creditCard;
		myBankAccount = bankAccount;
	}

	public String getUsername() {
		return myUsername;
	}

	public String getCreditCard() {
		return myCreditCard;
	}

	public String getBankAccount() {
		return myBankAccount;
	}

	private static User loadUser(ResultSet resultSet) throws SQLException { // loads
																			// a
																			// User
																			// from
																			// a
																			// ResultSet
																			// (the
																			// result
																			// of
																			// a
																			// query)
																			// into
																			// a
																			// User
																			// object
		User user = null;
		while (resultSet.next()) {
			String username = resultSet.getString("username");
			String creditCard = resultSet.getString("cardnumber");
			String bankAccount = resultSet.getString("bankaccnumber");

			user = new User(username, creditCard, bankAccount);
		}
		return user;
	}

	public static User retrieve(String username) { // finds the user in the
													// database and with the
													// help of loadUser returns
													// a User object

		User user = null;
		Connection conn = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		try {
			conn = DbConnector.connection();

			String query = "SELECT * FROM paymentinfo WHERE username = ?;";
			statement = conn.prepareStatement(query);
			statement.setString(1, username);
			resultSet = statement.executeQuery();

			user = User.loadUser(resultSet);

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
		return user;
	}

}
