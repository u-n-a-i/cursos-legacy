package com.example;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.AreaRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.awt.*;

public class AreaChartExample {
    public static void main(String[] args) {
        // Crear dataset
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        String serie = "Compras realizadas, 2026";

        String[] meses = { "Enero", "Febrero", "Marzo", "Abril", "Mayo" };
        double[] compras = { 10.5, 9.0, 8.5, 7.0, 6.0 };

        for (int i = 0; i < meses.length; i++) {
            dataset.addValue(compras[i], serie, meses[i]);
        }

        // Crear gráfico
        JFreeChart areaChart = ChartFactory.createAreaChart(
                "Compras realizadas",
                "Mes",
                "Cantidad",
                dataset);

        // Personalizar colores
        CategoryPlot plot = (CategoryPlot) areaChart.getPlot();
        AreaRenderer renderer = (AreaRenderer) plot.getRenderer();
        renderer.setSeriesPaint(0, new Color(100, 180, 255));

        // Mostrar en ventana
        JFrame frame = new JFrame("Gráfico de Área");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new ChartPanel(areaChart));
        frame.setSize(800, 600);
        frame.setVisible(true);
    }
}