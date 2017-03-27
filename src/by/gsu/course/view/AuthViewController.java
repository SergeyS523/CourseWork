package by.gsu.course.view;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class AuthViewController {
	@FXML
	private TextField hostName;
	@FXML
	private TextField userName;
	@FXML
	private TextField userPassword;

	public AuthViewController() {
	}

	public TextField getHostName() {
		return this.hostName;
	}

	public TextField getUserName() {
		return this.userName;
	}

	public TextField getUserPassword() {
		return this.userPassword;
	}

	public void setHostName(final TextField hostName) {
		this.hostName = hostName;
	}

	/*
	 * public void setLauncher(final Launcher launcher) { }
	 */

	public void setUserName(final TextField userName) {
		this.userName = userName;
	}

	public void setUserPassword(final TextField userPassword) {
		this.userPassword = userPassword;
	}

	@FXML
	private void initialize() {
		this.hostName.getText();
		this.userName.getText();
		this.userPassword.getText();
	}
}
