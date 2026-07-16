package com.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Ejercicio2 extends Application {
    @Override
    public void start(Stage stage) {
        TextField tf1 = new TextField();
        TextField tf2 = new TextField();

        // bidireccional
        tf1.textProperty().bindBidirectional(tf2.textProperty());

        VBox root = new VBox(10, tf1, tf2);
        Scene scene = new Scene(root, 300, 100);
        stage.setTitle("bidireccional");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
