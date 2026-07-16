package com.example.examen;

import java.sql.*;

public class Ejercicio4 {

    // Configuración de la conexión
    private static final String URL_BASE = "jdbc:mysql://localhost:3306/";
    private static final String URL_ESCUELA = "jdbc:mysql://localhost:3306/Escuela";
    private static final String USER = "root";
    private static final String PASS = "root";

    // Insertar alumno
    public static void insertarAlumno(String nombre, int edad, String email) {
        String sql = "INSERT INTO Alumnos (nombre, edad, email) VALUES (?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(URL_ESCUELA, USER, PASS);
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, nombre);
            pstmt.setInt(2, edad);
            pstmt.setString(3, email);

            int filas = pstmt.executeUpdate();
            System.out.println("Alumno insertado. Filas afectadas: " + filas);

        } catch (SQLException e) {
            System.err.println("Error al insertar: " + e.getMessage());
        }
    }

    // mostrar todos
    public static void mostrarTodosLosAlumnos() {
        String sql = "SELECT nombre, edad FROM Alumnos";

        try (Connection conn = DriverManager.getConnection(URL_ESCUELA, USER, PASS);
                PreparedStatement pstmt = conn.prepareStatement(sql);
                ResultSet rs = pstmt.executeQuery()) {

            System.out.println("--- ALUMNOS ---");
            boolean hayDatos = false;
            while (rs.next()) {
                hayDatos = true;
                System.out.println("Nombre: " + rs.getString("nombre") +
                        ", Edad: " + rs.getInt("edad"));
            }
            if (!hayDatos) {
                System.out.println("No hay alumnos.");
            }
            System.out.println("-------------------");

        } catch (SQLException e) {
            System.err.println("Error al consultar: " + e.getMessage());
        }
    }

    // Actualizar edad
    public static void actualizarEdad(int id, int nuevaEdad) {
        String sql = "UPDATE Alumnos SET edad = ? WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(URL_ESCUELA, USER, PASS);
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, nuevaEdad);
            pstmt.setInt(2, id);

            int filas = pstmt.executeUpdate();
            if (filas > 0) {
                System.out.println("Edad actualizada (ID " + id + "). Filas: " + filas);
            } else {
                System.out.println("No se encontró alumno con ID: " + id);
            }

        } catch (SQLException e) {
            System.err.println("Error al actualizar: " + e.getMessage());
        }
    }

    // Crear BD Escuela y Tabla Alumnos
    public static void crearBaseDeDatosYTabla() {
        try (Connection conn = DriverManager.getConnection(URL_BASE, USER, PASS)) {

            // Crear BD
            try (PreparedStatement stmt = conn.prepareStatement("CREATE DATABASE IF NOT EXISTS Escuela")) {
                stmt.executeUpdate();
                System.out.println("Base de datos Escuela creada.");
            }

            // Usar BD
            try (PreparedStatement stmt = conn.prepareStatement("USE Escuela")) {
                stmt.executeUpdate();
            }

            // Crear tabla
            String crearTabla = """
                    CREATE TABLE IF NOT EXISTS Alumnos (
                        id INT AUTO_INCREMENT PRIMARY KEY,
                        nombre VARCHAR(100),
                        edad INT,
                        email VARCHAR(100)
                    )
                    """;
            try (PreparedStatement stmt = conn.prepareStatement(crearTabla)) {
                stmt.executeUpdate();
                System.out.println("Tabla Alumnos creada.");
            }

            // Insertar datos iniciales
            String insertar = """
                    INSERT INTO Alumnos (nombre, edad, email)
                    SELECT * FROM (SELECT 'Alberto', 20, 'a.fernandez@colegiojosefinos.com') AS tmp
                    WHERE NOT EXISTS (SELECT nombre FROM Alumnos WHERE nombre = 'Alberto')
                    LIMIT 1
                    """;
            try (PreparedStatement stmt = conn.prepareStatement(insertar)) {
                stmt.executeUpdate();
            }

            String insertar2 = """
                    INSERT INTO Alumnos (nombre, edad, email)
                    SELECT * FROM (SELECT 'Susana', 19, 's.perez@colegiojosefinos.com') AS tmp
                    WHERE NOT EXISTS (SELECT nombre FROM Alumnos WHERE nombre = 'Susana')
                    LIMIT 1
                    """;
            try (PreparedStatement stmt = conn.prepareStatement(insertar2)) {
                int filas = stmt.executeUpdate();
                if (filas > 0) {
                    System.out.println("Datos iniciales insertados.");
                }
            }

        } catch (SQLException e) {
            System.err.println("Error en setup de BD: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        // 1. Crear base de datos y tabla
        crearBaseDeDatosYTabla();

        // 2. Probar métodos CRUD
        insertarAlumno("Juan Pérez", 22, "juan.perez@colegiojosefinos.com");
        mostrarTodosLosAlumnos();
        actualizarEdad(1, 55);
        mostrarTodosLosAlumnos();
    }
}