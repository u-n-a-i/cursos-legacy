package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class VuelosPasajeros {
    private static final String URL = "jdbc:mysql://localhost:3306/vuelospasajeros";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public static void main(String[] args) {
        insertarPasajeros();
    }

    public static void insertarPasajeros() {
        String sqlInsert1 = "INSERT INTO Pasajeros (cod_vuelo, tipo_plaza, fumador) VALUES (?, ?, ?)";
        String sqlInsert2 = "INSERT INTO Pasajeros (cod_vuelo, tipo_plaza, fumador) VALUES (?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            conn.setAutoCommit(false);

            try (
                    PreparedStatement ps1 = conn.prepareStatement(sqlInsert1);
                    PreparedStatement ps2 = conn.prepareStatement(sqlInsert2)) {
                // Primer INSERT
                ps1.setString(1, "IB100");
                ps1.setString(2, "Turista");
                ps1.setBoolean(3, false);
                ps1.executeUpdate();

                // Simulación de un fallo antes de la segunda operación
                if (true) {
                    throw new SQLException("Error simulado antes del segundo INSERT.");
                }

                // Segundo INSERT
                ps2.setString(1, "IB200");
                ps2.setString(2, "Primera clase");
                ps2.setBoolean(3, true);
                ps2.executeUpdate();

                conn.commit();
                System.out.println("Transacción completada con éxito.");
            } catch (SQLException e) {
                conn.rollback();
                System.out.println("Error en la transacción. Rollback: " + e.getMessage());
            } finally {
                conn.setAutoCommit(true);
            }
        } catch (SQLException e) {
            System.out.println("Error de conexión: " + e.getMessage());
        }
    }
}
