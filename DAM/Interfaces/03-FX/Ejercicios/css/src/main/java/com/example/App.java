package com.example;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {

        @Override
        public void start(Stage primaryStage) {
                // componentes

                // Botón verde
                Button btnPulsa = new Button("Pulsa");
                btnPulsa.getStyleClass().add("button-verde");

                // Etiqueta normal
                Label lblNormal = new Label("Soy normal");
                lblNormal.getStyleClass().add("label-normal");

                // Etiqueta especial
                Label lblEspecial = new Label("Soy especial");
                lblEspecial.getStyleClass().add("label-especial");

                // Botones
                Button btnPulsa1 = new Button("Pulsa1");
                Button btnPulsa2 = new Button("Pulsa2");
                Button btnPulsa3 = new Button("Pulsa3");
                Button btnPulsa4 = new Button("Pulsa4");

                // usando setStyle()
                btnPulsa1.setStyle(
                                "-fx-background-color: red; -fx-text-fill: white; -fx-font-weight: bold; -fx-padding: 10px 20px; -fx-border-radius: 5px;");
                btnPulsa2.setStyle(
                                "-fx-background-color: blue; -fx-text-fill: white; -fx-font-weight: bold; -fx-padding: 10px 20px; -fx-border-radius: 5px;");
                btnPulsa3.setStyle(
                                "-fx-background-color: blue; -fx-text-fill: white; -fx-font-weight: bold; -fx-padding: 10px 20px; -fx-border-radius: 5px;");
                btnPulsa4.setStyle(
                                "-fx-background-color: green; -fx-text-fill: white; -fx-font-weight: bold; -fx-padding: 10px 20px; -fx-border-radius: 5px;");

                // Layout vertical
                VBox root = new VBox(15, btnPulsa, lblNormal, lblEspecial, btnPulsa1, btnPulsa2, btnPulsa3, btnPulsa4);
                root.setPadding(new Insets(20));
                root.setAlignment(javafx.geometry.Pos.CENTER);

                // Escena y CSS
                Scene scene = new Scene(root, 300, 400);
                scene.getStylesheets().add(getClass().getResource("/fichero.css").toExternalForm());

                primaryStage.setTitle("Pruebas CSS");
                primaryStage.setScene(scene);
                primaryStage.show();
        }

        public static void main(String[] args) {
                launch(args);
        }
}