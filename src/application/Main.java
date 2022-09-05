package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import javafx.event.EventHandler;
import javafx.stage.StageStyle;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;

//--module-path="C:\Program Files\Java\javafx-sdk-18.0.2" --add-modules=javafx.controls,javafx.fxml

public class Main extends Application {

	private double xOffset = 0;
	private double yOffset = 0;

	@Override
	public void start(Stage primaryStage) throws IOException {

		Parent root=FXMLLoader.load(getClass().getResource("link to view file (fxml)"));
		primaryStage.initStyle(StageStyle.UNDECORATED); //hides windows default border

		root.setOnMouseDragged(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				primaryStage.setX(event.getScreenX() - xOffset);
				primaryStage.setY(event.getScreenY() - yOffset);
			}
		}); //window dragging
		
		root.setOnMousePressed(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				xOffset = event.getSceneX();
				yOffset = event.getSceneY();
			}
		}); //dragging stuff


		primaryStage.setTitle("Name");
		primaryStage.setScene(new Scene(root,0,0));//window size
		primaryStage.show(); 

	}

	public static void main(String[] args) {
		launch(args);
	}
}