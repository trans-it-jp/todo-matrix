package jp.trans_it.todo_matrix.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.text.Font;
import jp.trans_it.todo_matrix.model.Todo;

public class TodoListController implements Initializable {    
	@FXML
	private Label titleLabel;
	
    @FXML
    private TextField inputField;
    
    @FXML
    private ListView<Todo> todoListView;
    
    @FXML
    private Label statsLabel;
    
    private ObservableList<Todo> todos = FXCollections.observableArrayList();
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        todoListView.setItems(todos);
        todoListView.setCellFactory(lv -> new TodoListCell());
        
        todos.addListener(
        	(ListChangeListener<Todo>) change -> {
        		updateStats();
        	}
        );
        
        updateStats();
    }    
    
    public void addTodo(Todo todo) {
        todos.add(todo);
    }
    
    public ObservableList<Todo> getTodos() {
        return todos;
    }
    
    @FXML
    private void handleAddButton() {
        String text = inputField.getText().trim();
        if (!text.isEmpty()) {
            todos.add(new Todo(text));
            inputField.clear();
        }
    }
    
	public void setListTitle(String title) {
		titleLabel.setText(title);
	}
    
    private void updateStats() {
        int completed = (int)todos.stream().filter(Todo::isCompleted).count();
        statsLabel.setText(String.format("完了: %d / 全体: %d", completed, todos.size()));
    }
    
    public void addTodo(String text) {
    	todos.add(new Todo(text));
    }
    
    private class TodoListCell extends ListCell<Todo> {
        private HBox content;
        private Label textLabel;
        private CheckBox checkBox;
        private Button deleteButton;
        
        public TodoListCell() {
            super();
            
            content = new HBox(10);
            content.setAlignment(Pos.CENTER_LEFT);
            content.setPadding(new Insets(5));
            
            checkBox = new CheckBox();
            textLabel = new Label();
            textLabel.setFont(Font.font(14));
            
            deleteButton = new Button("削除");
            deleteButton.setStyle("-fx-background-color: #f44336; -fx-text-fill: white;");
            deleteButton.setFont(Font.font(12));
            
            Region spacer = new Region();
            HBox.setHgrow(spacer, Priority.ALWAYS);
            
            content.getChildren().addAll(checkBox, textLabel, spacer, deleteButton);
        }
        
        @Override
        protected void updateItem(Todo item, boolean empty) {
            super.updateItem(item, empty);
            
            if (empty || item == null) {
                setGraphic(null);
            } 
            else {
                textLabel.setText(item.getText());
                checkBox.setSelected(item.isCompleted());
                
                if (item.isCompleted()) {
                    textLabel.setStyle("-fx-text-fill: #888; -fx-strikethrough: true;");
                } 
                else {
                    textLabel.setStyle("-fx-text-fill: #000; -fx-strikethrough: false;");
                }
                
                checkBox.setOnAction(
                	e -> {
                		item.setCompleted(checkBox.isSelected());
                		updateItem(item, false);
                		updateStats();
                	}
                );
                
                deleteButton.setOnAction(
                	e -> {
                		todos.remove(item);
                	}
                );
                
                setGraphic(content);
            }
        }
    }
}