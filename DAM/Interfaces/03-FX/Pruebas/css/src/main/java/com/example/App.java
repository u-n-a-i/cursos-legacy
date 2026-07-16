package com.example;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("primary"), 640, 480);
        scene.getStylesheets().add(getClass().getResource("css/primary.css").toExternalForm());
        stage.setTitle("Ventana principal");
        stage.setScene(scene);
        stage.show();

        // abrir segunda ventana
        abrirVentanaSecundaria();

        // cerrar la app
        stage.setOnCloseRequest(e -> {
            Platform.exit();
            System.exit(0);
        });
    }

    private void abrirVentanaSecundaria() throws IOException {
        // crear nuevo stage
        Stage stage = new Stage();

        // cargar FXML
        scene = new Scene(loadFXML("secondary"), 320, 240);
        scene.getStylesheets().add(getClass().getResource("css/secondary.css").toExternalForm());
        stage.setTitle("Ventana secundaria");
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}