package sample;

import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Controller {

    static public Button Btn = new Button();
    static public TextField TextInput1 = new TextField();

    public void updateText(Application actionEvent) {
        Btn.setText("10");
        TextInput1.setText("10");
    }
}


