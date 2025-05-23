package jp.trans_it.todo_matrix;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import jp.trans_it.todo_matrix.controller.TodoMatrixController;

public class TodoApp extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader loader = new FXMLLoader(TodoMatrixController.class.getResource("TodoMatrix.fxml"));
		Parent root = loader.load();
		
		primaryStage.setTitle("Todo Matrix");
		primaryStage.setScene(new Scene(root));
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
