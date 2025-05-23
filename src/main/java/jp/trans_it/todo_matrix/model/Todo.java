package jp.trans_it.todo_matrix.model;

public class Todo {
	private String text;
	private boolean completed;
	
	public Todo(String text) {
		this.text = text;
		this.completed = false;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}
}
