package com.example.ejercicio1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Ejercicio1 {

    public static void guardarPeliculas(List<String> listaPeliculas, String nombreArchivo, boolean anadir) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo, anadir))) {
            for (String pelicula : listaPeliculas) {
                bw.write(pelicula);
                bw.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error escribiendo en '" + nombreArchivo + "': " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        List<String> peliculas = new ArrayList<>();
        peliculas.add("Inception");
        peliculas.add("The Matrix");
        peliculas.add("Interstellar");

        // Sobrescribir el archivo peliculas.txt
        guardarPeliculas(peliculas, "peliculas.txt", false);

        // Añadir nuevas películas al final del archivo
        List<String> nuevasPeliculas = new ArrayList<>();
        nuevasPeliculas.add("Avatar");
        nuevasPeliculas.add("The Lord of the Rings");
        guardarPeliculas(nuevasPeliculas, "peliculas.txt", true);

        System.out.println("Guardado");
    }
}