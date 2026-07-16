package com.unai.agenda.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.nio.file.Paths;

public class ConexionBD {
    // Guardar en la carpeta raíz del proyecto
    private static final String DB_PATH = Paths.get(System.getProperty("user.dir"), "agenda.db").toString();
    private static final String URL = "jdbc:sqlite:" + DB_PATH;
    private static Connection conexion;

    public static Connection conectar() {
        try {
            conexion = DriverManager.getConnection(URL);
            crearTablas();
            System.out.println("Conectado a: " + DB_PATH);
            return conexion;
        } catch (SQLException e) {
            System.err.println("Error de conexión: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    private static void crearTablas() {
        try (Statement stmt = conexion.createStatement()) {
            String sql = "CREATE TABLE IF NOT EXISTS contactos (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "nombre TEXT NOT NULL," +
                    "telefono TEXT," +
                    "correo TEXT," +
                    "web_personal TEXT," +
                    "imagen_perfil TEXT)";
            stmt.execute(sql);
            System.out.println("Tabla 'contactos' lista");
        } catch (SQLException e) {
            System.err.println("Error en tabla: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static Connection getConexion() {
        return conexion;
    }

    public static void desconectar() {
        try {
            if (conexion != null && !conexion.isClosed()) {
                conexion.close();
                System.out.println("Desconectado");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}