package com.example;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        // contenedor con un rectángulo
        VBox vbox = new VBox();
        vbox.setAlignment(Pos.CENTER);
        Rectangle rectangulo = new Rectangle(100, 50, Color.GOLD);
        vbox.getChildren().addAll(rectangulo);

        // Context menu para el raton
        ContextMenu contextMenu = new ContextMenu();
        MenuItem menuItem1 = new MenuItem("btn azul");
        MenuItem menuItem2 = new MenuItem("btn verde");
        contextMenu.getItems().addAll(menuItem1, menuItem2);

        // eventos
        rectangulo.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
            System.out.println("Evento del rectángulo");
        });

        vbox.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
            if (e.getButton() == MouseButton.SECONDARY) {
                System.out.println("BTN derecho");
            } else {
                System.out.println("BTN izquierdo");
            }
        });

        // Filtrar click derecho
        vbox.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
            if (e.getButton() == MouseButton.SECONDARY) {
                System.out.println("Mostrar menú contextual");
                contextMenu.show(vbox, e.getScreenX(), e.getSceneY());
            } else {
                System.out.println("Click izquierdo filtrado");
            }
        });

        // acciones menú contextual
        menuItem1.setOnAction(e -> rectangulo.setFill(Color.DODGERBLUE));
        menuItem2.setOnAction(e -> rectangulo.setFill(Color.PALEGREEN));

        // Scena y Ventana
        Scene scene = new Scene(vbox, 400, 400);
        stage.setTitle("Eventos");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }

}