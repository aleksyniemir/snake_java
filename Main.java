package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.Stack;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        StackPane stackPane = new StackPane();
        Button button = new Button("Przycisk");
        stackPane.getChildren().add(button);

        Scene scene = new Scene(stackPane, 400, 600);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Snake");
        primaryStage.show();
    }


    public static void main(String[] args) {

        launch(args);
        System.out.println("aa");
    }


}
