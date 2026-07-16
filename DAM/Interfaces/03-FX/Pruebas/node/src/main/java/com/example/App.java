package com.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        Button btn1 = new Button("Botón 1");
        btn1.setTranslateX(50);
        btn1.setTranslateY(50);
        btn1.setRotate(45);

        Button btn2 = new Button("Botón 2");
        btn1.setTranslateX(10);
        btn1.setTranslateY(50);
        btn2.setRotate(45);

        VBox vbox = new VBox();
        vbox.getChildren().addAll(btn1, btn2);
        vbox.setTranslateY(100);
        vbox.setTranslateX(225);

        Scene scene = new Scene(vbox, 500, 500);
        stage.setTitle("Clases Node");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}