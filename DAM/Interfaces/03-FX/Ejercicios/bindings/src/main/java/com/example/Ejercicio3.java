package com.example;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Ejercicio3 extends Application {
    @Override
    public void start(Stage stage) {
        ObservableList<Integer> items = FXCollections.observableArrayList(1, 2, 3, 4, 5);
        ListView<Integer> listView = new ListView<>(items);
        Label label = new Label("Elemento seleccionado: ");

        // enlazar num text
        label.textProperty().bind(
                Bindings.concat("Elemento seleccionado: ", listView.getSelectionModel().selectedItemProperty()));

        VBox root = new VBox(10, label, listView);
        Scene scene = new Scene(root, 200, 200);
        stage.setTitle("binding entre tipos");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}