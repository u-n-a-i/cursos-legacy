package com.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.fx.ChartViewer;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.AreaRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

import java.awt.Color;

public class AreaChartApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Crear dataset
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        String serie = "Compras realizadas, 2007";

        String[] meses = { "Enero", "Febrero", "Marzo", "Abril", "Mayo" };
        double[] compras = { 10.5, 9.0, 8.5, 7.0, 6.0 };

        for (int i = 0; i < meses.length; i++) {
            dataset.addValue(compras[i], serie, meses[i]);
        }

        // Crear gráfico de área
        JFreeChart areaChart = ChartFactory.createAreaChart(
                "Compras realizadas",
                "Mes",
                "Cantidad",
                dataset);

        // Personalizar color
        CategoryPlot plot = (CategoryPlot) areaChart.getPlot();
        AreaRenderer renderer = (AreaRenderer) plot.getRenderer();
        renderer.setSeriesPaint(0, new Color(100, 180, 255)); // Azul claro

        // Embeber en JavaFX
        ChartViewer viewer = new ChartViewer(areaChart);

        StackPane root = new StackPane(viewer);
        Scene scene = new Scene(root, 800, 600);

        primaryStage.setTitle("Gráfico de Área - JavaFX + JFreeChart");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}