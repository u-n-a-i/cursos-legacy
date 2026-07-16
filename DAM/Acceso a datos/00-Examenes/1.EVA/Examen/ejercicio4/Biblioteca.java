package com.example.ejercicio4;

import java.sql.*;

public class Biblioteca {
    private static final String URL = "jdbc:mysql://localhost:3306/Biblioteca";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public void insertarLibro(String titulo, String autor) {
        String sql = "INSERT INTO Libros (titulo, autor) VALUES (?, ?)";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, titulo);
            pstmt.setString(2, autor);

            int filasAfectadas = pstmt.executeUpdate();
            System.out.println("Filas afectadas: " + filasAfectadas);

        } catch (SQLException e) {
            System.err.println("Error al insertar libro: " + e.getMessage());
        }
    }

    public void mostrarTodosLosLibros() {
        String sql = "SELECT * FROM Libros";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                System.out.println("Título: " + rs.getString("titulo") +
                        ", Autor: " + rs.getString("autor"));
            }

        } catch (SQLException e) {
            System.err.println("Error al mostrar libros: " + e.getMessage());
        }
    }

    public void actualizarAutor(int id, String nuevoAutor) {
        String sql = "UPDATE Libros SET autor = ? WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, nuevoAutor);
            pstmt.setInt(2, id);

            int filasAfectadas = pstmt.executeUpdate();
            System.out.println("Filas afectadas: " + filasAfectadas);

        } catch (SQLException e) {
            System.err.println("Error al actualizar autor: " + e.getMessage());
        }
    }
}
