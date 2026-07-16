package com.example;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class BarChartExample {
    public static void main(String[] args) {
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

        // Mostrar en ventana
        JFrame frame = new JFrame("Gráfico de Barras");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new ChartPanel(barChart));
        frame.setSize(800, 600);
        frame.setVisible(true);

        // Guardar como JPG
        try {
            ChartUtils.saveChartAsJPEG(new File("visitas.jpg"), barChart, 800, 600);
            System.out.println("Gráfico guardado como 'visitas.jpg'");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}