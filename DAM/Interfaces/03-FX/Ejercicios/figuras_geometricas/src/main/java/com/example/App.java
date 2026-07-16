package com.example;

import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) {

        Rectangle rectangulo = new Rectangle(600, 250);
        rectangulo.setFill(Color.RED);

        Circle circulo = new Circle(120);
        circulo.setFill(Color.GREEN);

        Polygon triangulo = new Polygon(
                0.0, 200.0, // izquierda abajo
                150.0, 0.0, // arriba
                300.0, 200.0 // derecha abajo
        );
        triangulo.setFill(Color.BLACK);

        // contenedor con borde
        HBox contenedorFiguras = new HBox(60, circulo, triangulo);
        contenedorFiguras.setPadding(new Insets(20));
        contenedorFiguras.setAlignment(Pos.CENTER);
        contenedorFiguras.setStyle("-fx-background-color: white; -fx-border-color: black;");

        // Layout general vertical
        VBox root = new VBox(20, rectangulo, contenedorFiguras);
        root.setPadding(new Insets(20));
        root.setAlignment(Pos.TOP_CENTER);
        root.setStyle("-fx-background-color: white;");

        // eventos

        rectangulo.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
            System.out.println("¡Rectángulo rojo pulsado!");
            rectangulo.setFill(Color.BLUE);

            PauseTransition pause = new PauseTransition(Duration.millis(500));
            pause.setOnFinished(ev -> rectangulo.setFill(Color.RED));
            pause.play();
        });

        circulo.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
            System.out.println("¡Círculo verde pulsado!");
            double original = circulo.getRadius();
            circulo.setRadius(original * 1.2);

            PauseTransition pause = new PauseTransition(Duration.millis(500));
            pause.setOnFinished(ev -> circulo.setRadius(original));
            pause.play();
        });

        triangulo.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
            System.out.println("¡Triángulo negro pulsado!");
            triangulo.setFill(Color.WHITE);

            PauseTransition pause = new PauseTransition(Duration.millis(500));
            pause.setOnFinished(ev -> triangulo.setFill(Color.BLACK));
            pause.play();
        });

        // ventana
        Scene scene = new Scene(root, 800, 600);
        primaryStage.setTitle("Figuras geométricas");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
