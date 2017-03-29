package by.gsu.course.view;

import java.sql.SQLException;

import com.microsoft.sqlserver.jdbc.SQLServerException;

import by.gsu.course.mysql.MySQLConnector;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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

	public AuthViewController() {
	}

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

	public void setUserName(final TextField userName) {
		this.username = userName;
	}

	public void setUserPassword(final TextField userPassword) {
		this.password = userPassword;
	}

	@FXML
	private void handleButtonAction(final ActionEvent event) throws SQLServerException {
		final MySQLConnector connector = new MySQLConnector("SSivagin", this.username.getText(),
				this.password.getText());
		connector.createConnection();
		if (connector.getDbConnection() != null) {
			this.message.setText("Success connection");
			this.message.setVisible(true);
			try {
				connector.getTable();
			} catch (final SQLException e) {
				e.printStackTrace();
			}
		} else {
			this.message.setText("Connection error");
			this.message.setVisible(true);
		}
	}

	@FXML
	private void initialize() {
	}
}
