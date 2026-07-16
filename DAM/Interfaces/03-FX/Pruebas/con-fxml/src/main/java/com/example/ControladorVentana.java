package com.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class ControladorVentana {
    @FXML
    private TextField texto;
    @FXML
    private Button btn;

    @FXML
    public void saludar(ActionEvent e) {
        Button btnPulsado = (Button) e.getSource();
        btnPulsado.setStyle("-fx-background-color: #afe77bff");

        String nombre = texto.getText();
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Saludo");
        alert.setHeaderText(null);
        alert.setContentText("Hola " + nombre);
        alert.show();
    }
}
