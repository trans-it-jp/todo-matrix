package jp.trans_it.todo_matrix.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import java.net.URL;
import java.util.ResourceBundle;
import jp.trans_it.todo_matrix.annotation.CustomController;

public class MainFrameController implements Initializable {
    @FXML
    private Parent todoList;
    @FXML
    @CustomController("To Do List")
    private TodoListController todoListController;

    @FXML
    private Parent todoMatrix;    
    @FXML
    private TodoMatrixController todoMatrixController;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.todoListController.call();
        this.todoMatrixController.call();
    }
}
