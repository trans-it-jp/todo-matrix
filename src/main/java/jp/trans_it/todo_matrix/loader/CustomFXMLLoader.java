package jp.trans_it.todo_matrix.loader;

import java.net.URL;
import javafx.fxml.FXMLLoader;


public class CustomFXMLLoader extends FXMLLoader {
    public CustomFXMLLoader(URL location) {
        super(location);
        setControllerFactory(new CustomControllerFactory());
    }
}
