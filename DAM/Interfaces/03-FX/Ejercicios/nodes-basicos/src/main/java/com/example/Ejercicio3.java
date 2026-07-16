package com.example;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Ejercicio3 extends Application {

    @Override
    public void start(Stage stage) {
        // Etiquetas y campos de texto
        Label labelNombre = new Label("Nombre");
        TextField campoNombre = new TextField();

        Label labelApellidos = new Label("Apellidos");
        TextField campoApellidos = new TextField();

        Label labelEdad = new Label("Edad");
        TextField campoEdad = new TextField();

        Button btnAgregar = new Button("Agregar persona");

        // Tabla con encabezados
        TableView<String> tabla = new TableView<>();
        TableColumn<String, String> colNombre = new TableColumn<>("Nombre");
        TableColumn<String, String> colApellidos = new TableColumn<>("Apellidos");
        TableColumn<String, String> colEdad = new TableColumn<>("Edad");

        tabla.getColumns().addAll(colNombre, colApellidos, colEdad);
        // Texto cuando no hay datos
        tabla.setPlaceholder(new Label("Tabla sin contenido"));

        // Layout izquierdo: formulario
        VBox formBox = new VBox(10);
        formBox.getChildren().addAll(
                labelNombre, campoNombre,
                labelApellidos, campoApellidos,
                labelEdad, campoEdad,
                btnAgregar);
        formBox.setPadding(new Insets(20));
        formBox.setAlignment(Pos.TOP_LEFT);

        // Contenedor principal(agrega form->izq y tabla->derecha)
        HBox root = new HBox(20);
        root.setPadding(new Insets(10));
        root.getChildren().addAll(formBox, tabla);

        // Escena y ventana
        Scene scene = new Scene(root, 600, 400);
        stage.setTitle("Formulario y Tabla");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
