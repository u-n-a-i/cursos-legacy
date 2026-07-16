package com.example;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Layouts extends Application {

    @Override
    public void start(Stage stage) {
        // Contenedor principal
        BorderPane root = new BorderPane();
        root.setPadding(new Insets(20));

        // Parte superior
        HBox topBox = new HBox(10);
        topBox.setAlignment(Pos.CENTER);
        Button btnInsertar = new Button("Insertar");
        Button btnModificar = new Button("Modificar");
        Button btnListar = new Button("Listar");
        topBox.getChildren().addAll(btnInsertar, btnModificar, btnListar);

        // Centro
        VBox centerBox = new VBox(15);
        centerBox.setAlignment(Pos.CENTER);
        Label label = new Label("Esto es una etiqueta dentro de un VBox");
        Image image = new Image(getClass().getResourceAsStream("/img/javafx.png"));
        ImageView imageView = new ImageView(image);
        imageView.setPreserveRatio(true);

        centerBox.getChildren().addAll(label, imageView);

        // Parte inferior
        HBox bottomBox = new HBox(10);
        bottomBox.setAlignment(Pos.CENTER);
        Button btnBorrar = new Button("Borrar");
        Button btnReiniciar = new Button("Reiniciar");
        bottomBox.getChildren().addAll(btnBorrar, btnReiniciar);

        // Asignar los paneles
        root.setTop(topBox);
        root.setCenter(centerBox);
        root.setBottom(bottomBox);

        // La escena y la ventana
        Scene scene = new Scene(root, 900, 600);
        stage.setTitle("Ejemplos Layouts");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}