package by.gsu.course.view;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Launcher extends Application {

	private Stage primaryStage;
	private BorderPane rootView;

	public static void main(final String[] args) {
		Application.launch(args);
	}

	public Stage getPrimaryStage() {
		return this.primaryStage;
	}

	public BorderPane getRootView() {
		return this.rootView;
	}

	public void initRootView() {
		try {
			final FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Launcher.class.getResource("RootView.fxml"));

			this.rootView = (BorderPane) loader.load();
			final Scene scene = new Scene(this.rootView);

			this.primaryStage.setScene(scene);
			this.primaryStage.show();
		} catch (final IOException e) {
			e.printStackTrace();
		}
	}

	public void setPrimaryStage(final Stage primaryStage) {
		this.primaryStage = primaryStage;
	}

	public void setRootView(final BorderPane rootView) {
		this.rootView = rootView;
	}

	public void showAuthView() {
		try {
			final FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Launcher.class.getResource("AuthView.fxml"));
			final AnchorPane authView = (AnchorPane) loader.load();
			this.rootView.getChildren().setAll(authView);

			final AuthViewController controller = loader.getController();
			controller.setLauncher(this);
		} catch (final IOException e) {
			e.printStackTrace();
		}
	}

	public void showUserView() {
		try {
			final FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Launcher.class.getResource("UserView.fxml"));

			final AnchorPane userView = (AnchorPane) loader.load();
			this.rootView.getChildren().setAll(userView);
			this.primaryStage.setWidth(800);

			final UserViewController controller = loader.getController();
			controller.setLauncher(this);
		} catch (final IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void start(final Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("CourseWork");

		this.initRootView();
		this.showAuthView();
	}
}
