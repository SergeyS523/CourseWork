package by.gsu.course.view;

import by.gsu.course.mysql.MySQLConnector;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class AuthViewController {
	@FXML
	private TextField hostname;
	@FXML
	private TextField username;
	@FXML
	private TextField password;
	@FXML
	private Label message;

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
	private void handleButtonAction(final ActionEvent event) {
		if ((MySQLConnector.getConnection("SSivagin", this.username.getText(), this.password.getText())) != null) {
			this.message.setText("Success connection");
			this.message.setVisible(true);
		} else {
			this.message.setText("Connection error");
			this.message.setVisible(true);
		}
	}

	@FXML
	private void initialize() {
	}
}
