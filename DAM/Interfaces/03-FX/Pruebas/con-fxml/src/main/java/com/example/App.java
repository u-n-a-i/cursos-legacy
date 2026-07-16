package com.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage ventanaPrincipal) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("vista.fxml"));
        Scene scene = new Scene(root, 300, 150);
        ventanaPrincipal.setTitle("Saludar");
        ventanaPrincipal.setScene(scene);
        ventanaPrincipal.show();
    }

    public static void main(String[] args) {
        launch();
    }

}