package com.example.examen;

import java.sql.*;

public class Ejercicio5 {

    private static final String URL_BASE = "jdbc:mysql://localhost:3306/";
    private static final String URL_BANCO = "jdbc:mysql://localhost:3306/banco";
    private static final String USER = "root";
    private static final String PASS = "root";

    public static void main(String[] args) {
        // 1. Crear BD y datos iniciales
        crearBaseDeDatosYDatosIniciales();

        // 2. Realizar transferencia
        int cuentaOrigen = 1;
        int cuentaDestino = 2;
        double cantidad = 200.00;

        realizarTransferencia(cuentaOrigen, cuentaDestino, cantidad);
    }

    // Realizar transferencia
    public static void realizarTransferencia(int cuentaOrigen, int cuentaDestino, double cantidad) {
        Connection conn = null;
        String sqlUpdateCtaA = "UPDATE cuentas SET saldo = saldo - ? WHERE id = ?";
        String sqlUpdateCtaB = "UPDATE cuentas SET saldo = saldo + ? WHERE id = ?";

        try {
            conn = DriverManager.getConnection(URL_BANCO, USER, PASS);
            conn.setAutoCommit(false); // Iniciar transacción

            // Verificar saldo
            if (!tieneSaldoSuficiente(conn, cuentaOrigen, cantidad)) {
                System.out.println("Error: Saldo insuficiente en la cuenta origen.");
                conn.rollback();
                return;
            }

            // Restar de cuenta
            try (PreparedStatement pstmtA = conn.prepareStatement(sqlUpdateCtaA)) {
                pstmtA.setDouble(1, cantidad);
                pstmtA.setInt(2, cuentaOrigen);
                int filasA = pstmtA.executeUpdate();
                if (filasA == 0) {
                    throw new SQLException("No se encontró la cuenta origen con ID: " + cuentaOrigen);
                }
            }

            // Sumar a cuenta destino
            try (PreparedStatement pstmtB = conn.prepareStatement(sqlUpdateCtaB)) {
                pstmtB.setDouble(1, cantidad);
                pstmtB.setInt(2, cuentaDestino);
                int filasB = pstmtB.executeUpdate();
                if (filasB == 0) {
                    throw new SQLException("No se encontró la cuenta destino con ID: " + cuentaDestino);
                }
            }

            // confirmar
            conn.commit();
            System.out.println("Transferencia de " + cantidad + " realizada con éxito.");

            // Mostrar saldos finales
            mostrarSaldos(conn);

        } catch (SQLException e) {
            System.out.println("Error en la transferencia: " + e.getMessage());
            if (conn != null) {
                try {
                    conn.rollback();
                    System.out.println("Transacción revertida (rollback).");
                } catch (SQLException ex) {
                    System.err.println("Error al hacer rollback: " + ex.getMessage());
                }
            }
        } finally {
            if (conn != null) {
                try {
                    conn.setAutoCommit(true); // Restaurar modo normal
                    conn.close();
                } catch (SQLException ex) {
                    System.err.println("Error al cerrar conexión: " + ex.getMessage());
                }
            }
        }
    }

    // Verificar
    private static boolean tieneSaldoSuficiente(Connection conn, int cuentaId, double cantidad) throws SQLException {
        String sql = "SELECT saldo FROM cuentas WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, cuentaId);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    double saldo = rs.getDouble("saldo");
                    return saldo >= cantidad;
                }
            }
        }
        return false;
    }

    // Mostrar saldo
    private static void mostrarSaldos(Connection conn) throws SQLException {
        String sql = "SELECT id, nombre, saldo FROM cuentas ORDER BY id";
        try (PreparedStatement pstmt = conn.prepareStatement(sql);
                ResultSet rs = pstmt.executeQuery()) {

            System.out.println("\n--- SALDOS ACTUALES ---");
            while (rs.next()) {
                System.out.printf("ID: %d | %s | Saldo: %.2f%n",
                        rs.getInt("id"), rs.getString("nombre"), rs.getDouble("saldo"));
            }
            System.out.println("------------------------\n");
        }
    }

    // Crear bd
    public static void crearBaseDeDatosYDatosIniciales() {
        try (Connection conn = DriverManager.getConnection(URL_BASE, USER, PASS)) {

            // Crear BD
            try (PreparedStatement stmt = conn.prepareStatement("CREATE DATABASE IF NOT EXISTS banco")) {
                stmt.executeUpdate();
                System.out.println("Base de datos 'banco' verificada/creada.");
            }

            // Usar BD
            try (PreparedStatement stmt = conn.prepareStatement("USE banco")) {
                stmt.executeUpdate();
            }

            // Crear tabla
            String crearTabla = """
                    CREATE TABLE IF NOT EXISTS cuentas (
                        id INT AUTO_INCREMENT PRIMARY KEY,
                        nombre VARCHAR(100) NOT NULL,
                        saldo DECIMAL(10, 2) NOT NULL
                    )
                    """;
            try (PreparedStatement stmt = conn.prepareStatement(crearTabla)) {
                stmt.executeUpdate();
                System.out.println("Tabla 'cuentas' verificada/creada.");
            }

            // Insertar datos iniciales (solo si no existen)
            String insertarA = """
                    INSERT INTO cuentas (nombre, saldo)
                    SELECT 'Cuenta A', 1000.00
                    WHERE NOT EXISTS (SELECT 1 FROM cuentas WHERE nombre = 'Cuenta A')
                    """;
            String insertarB = """
                    INSERT INTO cuentas (nombre, saldo)
                    SELECT 'Cuenta B', 500.00
                    WHERE NOT EXISTS (SELECT 1 FROM cuentas WHERE nombre = 'Cuenta B')
                    """;

            try (PreparedStatement stmt1 = conn.prepareStatement(insertarA);
                    PreparedStatement stmt2 = conn.prepareStatement(insertarB)) {
                int filas1 = stmt1.executeUpdate();
                int filas2 = stmt2.executeUpdate();
                if (filas1 + filas2 > 0) {
                    System.out.println("Datos iniciales insertados.");
                }
            }

        } catch (SQLException e) {
            System.err.println("Error en setup: " + e.getMessage());
            e.printStackTrace();
        }
    }
}