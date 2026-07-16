package com.example.ejercicio4;

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();

        // mostrar libros iniciales
        System.out.println("Libros iniciales:");
        biblioteca.mostrarTodosLosLibros();

        // Insertar libro
        System.out.println("\nInsertando nuevo libro:");
        biblioteca.insertarLibro("El cuarto mono", "Barker");

        // Mostrar libros
        System.out.println("\nLibros después de inserción:");
        biblioteca.mostrarTodosLosLibros();

        // Actualizar autor
        System.out.println("\nActualizando autor del libro con ID 1:");
        biblioteca.actualizarAutor(1, "George Orwell segundo");

        // Mostrar libros después de actualización
        System.out.println("\nLibros después de actualización:");
        biblioteca.mostrarTodosLosLibros();
    }
}