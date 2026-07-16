package com.example.dml;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DML {
    // Configuración de la conexión
    private static final String URL = "jdbc:mysql://localhost:3306/empresa";
    private static final String USER = "root";
    private static final String PASS = "root";

    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }

    // 1. Insertar datos en las tablas
    public static void insertarDepartamentos() {
        String sql = "INSERT INTO departamento (nombre, ubicacion) VALUES (?, ?)";

        try (Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // Insertar Contabilidad
            pstmt.setString(1, "contabilidad");
            pstmt.setString(2, "PB0");
            pstmt.executeUpdate();

            // Insertar Marketing
            pstmt.setString(1, "marketing");
            pstmt.setString(2, "PB0");
            pstmt.executeUpdate();

            // Insertar RRHH
            pstmt.setString(1, "RRHH");
            pstmt.setString(2, "PB1");
            pstmt.executeUpdate();

            System.out.println("Departamentos insertados correctamente");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertarEmpleados() {
        String sql = "INSERT INTO empleado (nombre, fecha_nacimiento, activo, id_departamento) VALUES (?, ?, ?, ?)";
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try (Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // Insertar empleados
            pstmt.setString(1, "Alvaro");
            pstmt.setDate(2, new Date(sdf.parse("25/11/1979").getTime()));
            pstmt.setBoolean(3, true);
            pstmt.setInt(4, 1);
            pstmt.executeUpdate();

            pstmt.setString(1, "Juan");
            pstmt.setDate(2, new Date(sdf.parse("07/07/2001").getTime()));
            pstmt.setBoolean(3, true);
            pstmt.setInt(4, 2);
            pstmt.executeUpdate();

            pstmt.setString(1, "Marta");
            pstmt.setDate(2, new Date(sdf.parse("25/12/1997").getTime()));
            pstmt.setBoolean(3, false);
            pstmt.setInt(4, 3);
            pstmt.executeUpdate();

            pstmt.setString(1, "Silvia");
            pstmt.setDate(2, new Date(sdf.parse("01/04/1992").getTime()));
            pstmt.setBoolean(3, false);
            pstmt.setInt(4, 2);
            pstmt.executeUpdate();

            System.out.println("Empleados insertados correctamente");
        } catch (SQLException | ParseException e) {
            e.printStackTrace();
        }
    }

    // 2. Recuperar empleados con sus departamentos
    public static void mostrarEmpleadosConDepartamentos() {
        String sql = "SELECT e.id, e.nombre, e.fecha_nacimiento, e.activo, d.nombre as departamento " +
                "FROM empleado e " +
                "JOIN departamento d ON e.id_departamento = d.id";

        try (Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql);
                ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                System.out.printf("ID: %d, Nombre: %s, Fecha: %s, Activo: %b, Departamento: %s%n",
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getDate("fecha_nacimiento"),
                        rs.getBoolean("activo"),
                        rs.getString("departamento"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 3. Recuperar usuarios ordenados por fecha de nacimiento
    public static void mostrarEmpleadosPorFecha() {
        String sql = "SELECT * FROM empleado ORDER BY fecha_nacimiento DESC";

        try (Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql);
                ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                System.out.printf("Nombre: %s, Fecha: %s%n",
                        rs.getString("nombre"),
                        rs.getDate("fecha_nacimiento"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 4. Editar fecha de nacimiento de Marta
    public static void actualizarFechaMarta() {
        String sql = "UPDATE empleado SET fecha_nacimiento = ? WHERE nombre = ?";
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try (Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setDate(1, new Date(sdf.parse("04/03/2002").getTime()));
            pstmt.setString(2, "Marta");
            int filasAfectadas = pstmt.executeUpdate();

            System.out.println("Filas actualizadas: " + filasAfectadas);
        } catch (SQLException | ParseException e) {
            e.printStackTrace();
        }
    }

    // 5. Eliminar usuario con ID 1
    public static void eliminarEmpleado() {
        String sql = "DELETE FROM empleado WHERE id = ?";

        try (Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, 1);
            int filasAfectadas = pstmt.executeUpdate();

            System.out.println("Filas eliminadas: " + filasAfectadas);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Primero creamos las tablas si no existen
        crearTablas();

        // Ejecutamos todas las operaciones en orden
        insertarDepartamentos();
        insertarEmpleados();
        System.out.println("\nEmpleados con sus departamentos:");
        mostrarEmpleadosConDepartamentos();
        System.out.println("\nEmpleados ordenados por fecha:");
        mostrarEmpleadosPorFecha();
        actualizarFechaMarta();
        eliminarEmpleado();

        System.out.println("\nEstado final de los empleados:");
        mostrarEmpleadosConDepartamentos();
    }

    private static void crearTablas() {
        try (Connection conn = getConnection();
                Statement stmt = conn.createStatement()) {

            // Crear tabla departamento
            stmt.execute("""
                    CREATE TABLE IF NOT EXISTS departamento (
                        id INT PRIMARY KEY AUTO_INCREMENT,
                        nombre VARCHAR(50) NOT NULL,
                        ubicacion VARCHAR(50) NOT NULL
                    );
                    """);

            // Crear tabla empleado
            stmt.execute("""
                    CREATE TABLE IF NOT EXISTS empleado (
                        id INT PRIMARY KEY AUTO_INCREMENT,
                        nombre VARCHAR(50) NOT NULL,
                        fecha_nacimiento DATE NOT NULL,
                        activo BOOLEAN NOT NULL,
                        id_departamento INT,
                        FOREIGN KEY (id_departamento) REFERENCES departamento(id)
                    );
                    """);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}