package by.gsu.course.mysql;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySQLConnector {
	public static Connection getConnection(final String baseName, final String username, final String password) {
		try {
			final String url = "jdbc:sqlserver://localhost:1433;database=SSivagin;integratedSecurity=true;";

			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			final Connection dbConnection = DriverManager.getConnection(url, username, password);

			return dbConnection;
		} catch (final Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
