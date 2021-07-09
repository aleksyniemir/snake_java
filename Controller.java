package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;


public class Controller {
    @FXML
    private Button button;

    public Controller() {
        System.out.println("Konstruktor");
    }

    @FXML
    void initialize () {
        button.setText("New button");
    }
}
