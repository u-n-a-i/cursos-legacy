package com.example;

import javafx.application.Application;
import javafx.beans.binding.BooleanBinding;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Ejercicio5 extends Application {

    @Override
    public void start(Stage stage) {
        TextField tfNombre = new TextField();
        PasswordField tfPass = new PasswordField(); // PasswordField para ocultar caracteres
        Button btnEntrar = new Button("Entrar");

        // habilitar solo si ambos campos tienen texto no vacío
        BooleanBinding isEmpty = tfNombre.textProperty().isEmpty()
                .or(tfPass.textProperty().isEmpty());

        btnEntrar.disableProperty().bind(isEmpty);

        GridPane root = new GridPane();
        root.setVgap(10);
        root.setHgap(10);
        root.add(new Label("Nombre:"), 0, 0);
        root.add(tfNombre, 1, 0);
        root.add(new Label("Contraseña:"), 0, 1);
        root.add(tfPass, 1, 1);
        root.add(btnEntrar, 1, 2);

        Scene scene = new Scene(root, 300, 120);
        stage.setTitle("boolean binding");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
