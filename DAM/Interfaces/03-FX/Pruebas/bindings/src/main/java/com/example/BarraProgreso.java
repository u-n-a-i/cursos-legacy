package com.example;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BarraProgreso extends Application {

    @Override
    public void start(Stage stage) {
        VBox root = new VBox(20);
        root.setAlignment(Pos.CENTER);

        ProgressBar progressBar = new ProgressBar(0);
        Label label = new Label("Procesando...");
        DoubleProperty progressBarValue = new SimpleDoubleProperty(0);

        progressBar.progressProperty().bind(progressBarValue);

        root.getChildren().addAll(progressBar, label);

        Scene scene = new Scene(root, 400, 300);
        stage.setTitle("Barra progreso");
        stage.setScene(scene);
        stage.show();

        new Thread(() -> {
            for (int i = 0; i <= 100; i++) {
                progressBarValue.set(i / 100.0);

                if (i == 100) {
                    Platform.runLater(() -> {
                        label.setText("Completado");
                        progressBar.setStyle("-fx-accent: green");
                    });
                }

                try {
                    Thread.sleep(100);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }).start();
    }

    public static void main(String[] args) {
        launch();
    }
}
