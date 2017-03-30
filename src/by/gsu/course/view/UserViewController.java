package by.gsu.course.view;

import java.sql.ResultSet;
import java.sql.SQLException;

import by.gsu.course.mysql.MySQLConnector;
import javafx.fxml.FXML;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableView;

public class UserViewController {
	@FXML
	private TabPane tabPanel;
	@FXML
	private TableView tableView;

	private Launcher launcher;

	public UserViewController() {
	}

	public Launcher getLauncher() {
		return this.launcher;
	}

	public TabPane getTabPanel() {
		return this.tabPanel;
	}

	public void setLauncher(final Launcher launcher) {
		this.launcher = launcher;
	}

	public TabPane setTabPanel(final TabPane tempPanel) {
		return this.tabPanel = tempPanel;
	}

	@FXML
	private void initialize() throws SQLException {
		final ResultSet tables = MySQLConnector.getTables();
		while (tables.next()) {
			final String tableName = tables.getString("TABLE_NAME");
			if (!tableName.equals("sysdiagrams")) {
				this.getTabPanel().getTabs().add(new Tab(tableName));
			}
		}

	}
}
