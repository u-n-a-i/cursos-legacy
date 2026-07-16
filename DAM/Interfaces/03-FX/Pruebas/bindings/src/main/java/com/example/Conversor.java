package com.example;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.DoubleBinding;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Conversor extends Application {

    @Override
    public void start(Stage stage) {
        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(20));

        TextField campoEuros = new TextField();
        Label etiquetaDolares = new Label();

        DoubleProperty euros = new SimpleDoubleProperty();
        DoubleProperty tasaCambio = new SimpleDoubleProperty(1.08);

        euros.bind(Bindings.createDoubleBinding(() -> {
            try {
                return Double.parseDouble(campoEuros.getText());
            } catch (NumberFormatException e) {
                return 0.0;
            }
        }, campoEuros.textProperty()));

        DoubleBinding dolares = euros.multiply(tasaCambio);
        etiquetaDolares.textProperty().bind(Bindings.format("En dolares: %.2f", dolares));
        vbox.getChildren().addAll(new Label("Euros"), campoEuros, etiquetaDolares);

        Scene scene = new Scene(vbox, 300, 200);
        stage.setTitle("Conversor");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }

}
