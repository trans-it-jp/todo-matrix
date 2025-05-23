package jp.trans_it.todo_matrix.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;

public class TodoMatrixController implements Initializable {
    
    @FXML
    private Parent urgentImportant;
    @FXML
    private TodoListController urgentImportantController;
    
    @FXML
    private Parent notUrgentImportant;    
    @FXML
    private TodoListController notUrgentImportantController;
    
    @FXML
    private Parent urgentNotImportant;
    @FXML
    private TodoListController urgentNotImportantController;
    
    @FXML
    private Parent notUrgentNotImportant;
    @FXML
    private TodoListController notUrgentNotImportantController;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        urgentImportantController.setListTitle("第1象限: 緊急かつ重要");
        notUrgentImportantController.setListTitle("第2象限: 緊急ではないが重要");
        urgentNotImportantController.setListTitle("第3象限: 緊急だが重要でない");
        notUrgentNotImportantController.setListTitle("第4象限: 緊急でも重要でもない");
        
        addSampleData();
    }
    
    private void addSampleData() {
        urgentImportantController.addTodo("クライアントへの緊急対応");
        urgentImportantController.addTodo("システム障害の修正");
        
        notUrgentImportantController.addTodo("スキルアップのための勉強");
        notUrgentImportantController.addTodo("健康管理・運動");
        
        urgentNotImportantController.addTodo("急な会議への参加");
        urgentNotImportantController.addTodo("メールの返信");

        notUrgentNotImportantController.addTodo("SNSのチェック");
        notUrgentNotImportantController.addTodo("雑談");
    }
}
