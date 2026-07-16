package com.unai.agenda.view;

import com.unai.agenda.db.ConexionBD;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage ventanaPrincipal) throws Exception {
        // Conectar a la base de datos al iniciar
        ConexionBD.conectar();

        // Vista principal
        AnchorPane layoutPrincipal = FXMLLoader.load(getClass().getResource("/com/unai/agenda/view/mainView.fxml"));

        // Crear la escena
        Scene escena = new Scene(layoutPrincipal, 1000, 500);

        // Vincular CSS - Tema oscuro por defecto
        escena.getStylesheets().add(getClass().getResource("/com/unai/agenda/css/dark-theme.css").toExternalForm());

        // Establecemos la escena, título
        ventanaPrincipal.setScene(escena);
        ventanaPrincipal.setTitle("Agenda de Contactos");
        ventanaPrincipal.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}