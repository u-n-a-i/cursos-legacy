package com.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.fx.ChartViewer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.chart.plot.PlotOrientation;

public class BarChartApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Crear dataset
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        String sitio1 = "www.sitio1.com";
        String sitio2 = "www.sitio2.com";

        String[] dias = { "Lunes", "Martes", "Miércoles", "Jueves", "Viernes" };
        int[] visitas1 = { 62, 60, 61, 63, 66 };
        int[] visitas2 = { 100, 120, 110, 103, 108 };

        for (int i = 0; i < dias.length; i++) {
            dataset.addValue(visitas1[i], sitio1, dias[i]);
            dataset.addValue(visitas2[i], sitio2, dias[i]);
        }

        // Crear gráfico
        JFreeChart barChart = ChartFactory.createBarChart(
                "Visitas por día",
                "Día",
                "Número de visitas",
                dataset,
                PlotOrientation.VERTICAL,
                true, true, false);

        // Embeber en JavaFX
        ChartViewer viewer = new ChartViewer(barChart);

        StackPane root = new StackPane(viewer);
        Scene scene = new Scene(root, 800, 600);

        primaryStage.setTitle("Gráfico de Barras - JavaFX + JFreeChart");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}