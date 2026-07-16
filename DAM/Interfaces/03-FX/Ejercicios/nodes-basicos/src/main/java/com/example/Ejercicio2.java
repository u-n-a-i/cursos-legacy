package com.example;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Ejercicio2 extends Application {

    @Override
    public void start(Stage stage) {
        // Elementos
        Label labelOperando1 = new Label("Operando 1");
        TextField CampoOperador1 = new TextField();
        Label labelOperando2 = new Label("Operando 2");
        TextField campoOperando2 = new TextField();
        Button btnOperar = new Button("Operar");
        Label labelResultado = new Label("Resultado");
        TextField campoResultado = new TextField();
        campoResultado.setEditable(false);

        RadioButton rbSuma = new RadioButton("Suma");
        RadioButton rbResta = new RadioButton("Resta");
        RadioButton rbDivision = new RadioButton("Division");
        RadioButton rbMultiplicacion = new RadioButton("Multiplicacion");

        // agrupar en un ToggleGroup para evitar selección multiple
        ToggleGroup grupoOperaciones = new ToggleGroup();
        rbSuma.setToggleGroup(grupoOperaciones);
        rbResta.setToggleGroup(grupoOperaciones);
        rbDivision.setToggleGroup(grupoOperaciones);
        rbMultiplicacion.setToggleGroup(grupoOperaciones);
        rbSuma.setSelected(true);

        // colocar en dos filas
        HBox row1 = new HBox(20, rbSuma, rbDivision);
        HBox row2 = new HBox(20, rbResta, rbMultiplicacion);

        // Grid
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20));
        grid.setAlignment(Pos.CENTER);
        grid.add(labelOperando1, 0, 0);
        grid.add(CampoOperador1, 1, 0);
        grid.add(labelOperando2, 0, 1);
        grid.add(campoOperando2, 1, 1);
        grid.add(btnOperar, 1, 2);
        grid.add(row1, 1, 3);
        grid.add(row2, 1, 4);
        grid.add(labelResultado, 0, 5);
        grid.add(campoResultado, 1, 5);

        // Panel principal
        VBox root = new VBox(grid);
        root.setPadding(new Insets(10));

        // Escena y ventana
        Scene scene = new Scene(root, 400, 350);
        stage.setTitle("Calculadora");
        stage.setScene(scene);
        // stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}