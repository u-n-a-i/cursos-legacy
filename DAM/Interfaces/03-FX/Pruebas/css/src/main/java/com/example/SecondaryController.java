package com.example;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class SecondaryController {

    @FXML
    private Button btnCerrar;

    @FXML
    public void cerrarVentana() {
        Stage ventanaActual = (Stage) btnCerrar.getScene().getWindow();
        ventanaActual.close();
    }
}