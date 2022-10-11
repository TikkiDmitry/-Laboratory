package com.example.lab2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class lab_app_3 extends Application {

    Stage stage = new Stage();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("3_lab_view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 880, 643);
        stage.setTitle("Шифрование текста");
        stage.setScene(scene);
        stage.show();
    }
}
