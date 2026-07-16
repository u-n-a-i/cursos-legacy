package com.example;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;

public class PrimaryController {
    @FXML
    private int btnEstilo = 0;

    @FXML
    private Button btn1;
    @FXML
    private Button btn2;

    @FXML
    public void saludar() {
        Alert alerta = new Alert(AlertType.INFORMATION);
        alerta.setTitle("Saludo");
        alerta.setHeaderText(null);
        alerta.setContentText("Hola, bienvenido");
        alerta.show();
    }

    @FXML
    public void modificarEstilo() {
        if (btnEstilo % 2 == 0) {
            btn1.getStyleClass().remove("btn1");
            btn1.getStyleClass().add("btn2");

            btn2.getStyleClass().remove("btn1");
            btn2.getStyleClass().add("btn2");
        } else {
            btn1.getStyleClass().remove("btn2");
            btn1.getStyleClass().add("btn1");

            btn2.getStyleClass().remove("btn2");
            btn2.getStyleClass().add("btn1");
        }
        btnEstilo++;
    }

}
