package com.example.examen;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Ejercicio2 {
    public static void escribirAlumnosEnArchivo(List<Alumno> listaAlumnos, String nombreArchivo) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nombreArchivo))) {
            oos.writeObject(listaAlumnos);
            System.out.println("Archivo escrito correctamente en " + nombreArchivo);
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // Crear una lista de alumnos
        List<Alumno> listaAlumnos = new ArrayList<>();

        // Añadir 3 alumnos
        listaAlumnos.add(new Alumno("Pedro", 21, "DAM2"));
        listaAlumnos.add(new Alumno("Laura", 23, "DAM2"));
        listaAlumnos.add(new Alumno("Marta", 20, "DAM2"));

        // Llamar al método para escribir en archivo binario
        escribirAlumnosEnArchivo(listaAlumnos, "alumnos.dat");
    }
}
