package com.example;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class Ejercicio1 extends Application {

    @Override
    public void start(Stage stage) {
        // Nodos(elementos)
        Label labelOperando1 = new Label("Operando 1");
        TextField campoOperando1 = new TextField();

        Label labelOperando2 = new Label("Operando 2");
        TextField campoOperando2 = new TextField();

        Button btnSumar = new Button("Sumar");

        Label labelResultado = new Label("Resultado");
        TextField campoResultado = new TextField();
        campoResultado.setEditable(false);

        // Panel
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20));
        grid.setAlignment(Pos.CENTER);

        // grid.add(componente, columna, fila);
        grid.add(labelOperando1, 0, 0);
        grid.add(campoOperando1, 1, 0);
        grid.add(labelOperando2, 0, 1);
        grid.add(campoOperando2, 1, 1);
        grid.add(btnSumar, 1, 2);
        grid.add(labelResultado, 0, 3);
        grid.add(campoResultado, 1, 3);

        // Contenedor principal
        VBox root = new VBox(grid);
        root.setPadding(new Insets(10));

        // Escena y ventana
        Scene scene = new Scene(root, 400, 250);
        stage.setTitle("Sumar");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }

}