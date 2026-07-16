package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TransferenciaDinero {
    private static final String URL = "jdbc:mysql://localhost:3306/banco";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public static void main(String[] args) {
        int cuentaOrigen = 1; // ID de Cuenta A
        int cuentaDestino = 2; // ID de Cuenta B
        double cantidad = 200.00; // Cantidad a transferir

        realizarTransferencia(cuentaOrigen, cuentaDestino, cantidad);
    }

    public static void realizarTransferencia(int cuentaOrigen, int cuentaDestino, double cantidad) {
        String sqlUpdateCtaA = "UPDATE cuentas SET saldo = saldo - ? WHERE id = ?";
        String sqlUpdateCtaB = "UPDATE cuentas SET saldo = saldo + ? WHERE id = ?";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            // Desactivar auto-commit
            connection.setAutoCommit(false);

            try (
                    PreparedStatement stmtOrigen = connection.prepareStatement(sqlUpdateCtaA);
                    PreparedStatement stmtDestino = connection.prepareStatement(sqlUpdateCtaB)) {
                // Actualizar cuenta origen
                stmtOrigen.setDouble(1, cantidad);
                stmtOrigen.setInt(2, cuentaOrigen);
                stmtOrigen.executeUpdate();

                // Actualizar cuenta destino
                stmtDestino.setDouble(1, cantidad);
                stmtDestino.setInt(2, cuentaDestino);
                stmtDestino.executeUpdate();

                // Confirmar transacción
                connection.commit();
                System.out.println("Transferencia realizada con éxito.");
            } catch (SQLException e) {
                // Deshacer cambios si hay error
                connection.rollback();
                System.out.println("Error en la transferencia. Se ha hecho rollback." + e.getMessage());
            } finally {
                // Reactivar auto-commit
                connection.setAutoCommit(true);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}