package com.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Slider;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class Ejercicio1 extends Application {
    @Override
    public void start(Stage stage) {
        Slider slider = new Slider(0, 1, 0); // min=0, max=1, inicial=0
        ProgressBar progressBar = new ProgressBar();

        // unidireccional
        progressBar.progressProperty().bind(slider.valueProperty());

        VBox root = new VBox(10, slider, progressBar);
        Scene scene = new Scene(root, 300, 100);
        stage.setTitle("Unidireccional");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}