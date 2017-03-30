package by.gsu.course.view;

import com.microsoft.sqlserver.jdbc.SQLServerException;

import by.gsu.course.mysql.MySQLConnector;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class AuthViewController {
	@FXML
	private TextField hostname;
	@FXML
	private TextField username;
	@FXML
	private TextField password;
	@FXML
	private Label message;
	@FXML
	private ImageView logotype;
	@FXML
	private Button authButton;
	@FXML
	private ComboBox database;

	private Launcher launcher = null;

	public TextField getHostName() {
		return this.hostname;
	}

	public TextField getUserName() {
		return this.hostname;
	}

	public TextField getUserPassword() {
		return this.password;
	}

	public void setHostName(final TextField hostName) {
		this.hostname = hostName;
	}

	public void setLauncher(final Launcher launcher) {
		this.launcher = launcher;
	}

	public void setUserName(final TextField userName) {
		this.username = userName;
	}

	public void setUserPassword(final TextField userPassword) {
		this.password = userPassword;
	}

	@FXML
	private void handleButtonAction(final ActionEvent event) throws SQLServerException {
		if (this.database.getSelectionModel().getSelectedIndex() != -1) {
			MySQLConnector.basename = this.database.getSelectionModel().getSelectedItem().toString();
			MySQLConnector.username = this.username.getText();
			MySQLConnector.password = this.password.getText();
			MySQLConnector.createConnection();

			if (MySQLConnector.dbConnection != null) {
				this.launcher.showUserView();
			} else {
				this.message.setText("Connection error");
				if (!this.message.isVisible()) {
					this.message.setVisible(true);
				}
			}
		} else {
			this.message.setText("Select database");
			if (!this.message.isVisible()) {
				this.message.setVisible(true);
			}
		}
	}

	@FXML
	private void initialize() {
		this.database.getItems().add("SSivagin");
		this.database.getItems().add("VKrupnik");
		this.database.getItems().add("ETrushkova");
	}
}
