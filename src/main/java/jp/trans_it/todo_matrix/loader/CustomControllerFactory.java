package jp.trans_it.todo_matrix.loader;

import javafx.util.Callback;
import jp.trans_it.todo_matrix.controller.TodoListController;

public class CustomControllerFactory implements Callback<Class<?>, Object> {
    @Override
    public Object call(Class<?> type) {
        Object controller = null;

        try {
            if(type == TodoListController.class) {
                controller = type.getDeclaredConstructor(Object.class).newInstance("Title specified in CustomControllerFactory");
            }
            else {
                controller = type.getDeclaredConstructor().newInstance();
            }
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }

        return controller;
    }

}
