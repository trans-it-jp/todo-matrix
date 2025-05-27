package jp.trans_it.todo_matrix;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import jp.trans_it.todo_matrix.controller.TodoMatrixController;
import jp.trans_it.todo_matrix.loader.CustomFXMLLoader;


public class TodoApp extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		CustomFXMLLoader loader = new CustomFXMLLoader(
			TodoMatrixController.class.getResource("MainFrame.fxml")
		);

		Parent root = loader.load();
		
		primaryStage.setTitle("Todo");
		primaryStage.setScene(new Scene(root));
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
