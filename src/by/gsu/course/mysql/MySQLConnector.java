package by.gsu.course.mysql;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MySQLConnector {
	private Connection dbConnection = null;
	private final String basename;
	private final String username;
	private final String password;

	public MySQLConnector(final String basename, final String username, final String password) {
		this.basename = basename;
		this.username = username;
		this.password = password;
	}

	public void createConnection() {
		try {
			final String url = "jdbc:sqlserver://SIARHEI-PC\\SQLEXPRESS;database=" + this.basename;
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			this.dbConnection = DriverManager.getConnection(url, this.username, this.password);
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

	public Connection getDbConnection() {
		return this.dbConnection;
	}

	public void getTable() throws SQLException {
		final DatabaseMetaData metaData = this.getDbConnection().getMetaData();
		final ResultSet result = metaData.getTables(null, null, "%", null);

		while (result.next()) {
			System.out.println(result.getString(3));
		}

		result.close();
	}
}
