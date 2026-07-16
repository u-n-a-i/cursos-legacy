package com.example;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.DoubleBinding;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Ejercicio4 extends Application {
    /*
     * Pies (en Slider de 0 a 100)
     * Metros = pies × 0.3048
     * Pulgadas = pies × 12
     */

    @Override
    public void start(Stage stage) {
        Slider slider = new Slider(0, 100, 0);
        slider.setShowTickMarks(true);
        slider.setShowTickLabels(true);
        slider.setMajorTickUnit(25);
        slider.setBlockIncrement(1);

        TextField tfPies = new TextField();
        Label lblMetros = new Label("En metros: 0.0");
        Label lblPulgadas = new Label("En pulgadas: 0.0");

        // enlazar TextField con Slider
        tfPies.textProperty().bind(Bindings.format("%.0f", slider.valueProperty()));

        // Binding personalizado para metros y pulgadas
        DoubleBinding metrosBinding = slider.valueProperty().multiply(0.3048);
        DoubleBinding pulgadasBinding = slider.valueProperty().multiply(12);

        lblMetros.textProperty().bind(Bindings.format("En metros: %.2f", metrosBinding));
        lblPulgadas.textProperty().bind(Bindings.format("En pulgadas: %.2f", pulgadasBinding));

        VBox root = new VBox(10,
                new Label("Conversor de longitud"),
                new Label("En pies:"), slider, tfPies,
                lblMetros,
                lblPulgadas);
        root.setPadding(new Insets(10));

        Scene scene = new Scene(root, 300, 200);
        stage.setTitle("Conversor de unidades");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
