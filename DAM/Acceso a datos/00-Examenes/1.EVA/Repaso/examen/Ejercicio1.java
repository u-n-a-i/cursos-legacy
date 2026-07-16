package com.example.examen;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Ejercicio1 {
    public static void escribirNombres(List<String> nombres, String nombreArchivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo))) {
            for (String nombre : nombres) {
                writer.write(nombre);
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // Lista de nombres de ejemplo
        List<String> nombresSeries = new ArrayList<>();
        nombresSeries.add("Stranger Things");
        nombresSeries.add("Outer Banks");
        nombresSeries.add("One Tree Hill");

        // Llamar al método para escribir en el archivo de texto
        escribirNombres(nombresSeries, "series.txt");
    }
}
