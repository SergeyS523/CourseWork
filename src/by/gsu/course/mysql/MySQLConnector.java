package by.gsu.course.mysql;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLConnector {
	public static String basename;
	public static String username;
	public static String password;
	public static Connection dbConnection;

	public static void createConnection() {
		try {
			final String url = "jdbc:sqlserver://SIARHEI-PC\\SQLEXPRESS;database=" + MySQLConnector.basename;
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			MySQLConnector.dbConnection = DriverManager.getConnection(url, MySQLConnector.username,
					MySQLConnector.password);
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

	public static ResultSet getColums(final String tableName) throws SQLException {
		final Statement connectStatement = MySQLConnector.dbConnection.createStatement();
		final String query = "SELECT * FROM dbo." + tableName + ";";
		final ResultSet result = connectStatement.executeQuery(query);

		while (result.next()) {
			final int workerKey = result.getInt("Код");
			final String workerName = result.getString("Наименование");

			System.out.println("Код - " + workerKey + "\n");
			System.out.println("Наименование - " + workerName + "\n");
		}
		return result;
	}

	public static ResultSet getTables() throws SQLException {
		final DatabaseMetaData metaData = MySQLConnector.dbConnection.getMetaData();
		final ResultSet result = metaData.getTables(null, "dbo", null, new String[] { "TABLE" });

		return result;
	}
}
