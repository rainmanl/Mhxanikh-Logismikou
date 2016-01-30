import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnector {

	public static Connection connection() throws SQLException {
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mixaniki", "pro", "mixaniki");
		return conn;
	}

}
