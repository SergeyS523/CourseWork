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

	public void showAuthView() {
		try {
			final FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Launcher.class.getResource("AuthView.fxml"));

			final AnchorPane authView = (AnchorPane) loader.load();
			this.rootView.setCenter(authView);

			loader.getController();
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
