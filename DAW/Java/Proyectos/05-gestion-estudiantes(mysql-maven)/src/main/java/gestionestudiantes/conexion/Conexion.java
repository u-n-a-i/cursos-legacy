package gestionestudiantes.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    public static Connection getConexion() {
        Connection conexion = null;
        String baseDatos = "estudiantes_db";
        String url = "jdbc:mysql://localhost:3306/" + baseDatos;
        String usuario = "root";
        String password = "Gr00t";

        // Cargar la clase del driver de mysql en memoria
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(url, usuario, password);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error en la conexión " + e.getMessage());
        }
        return conexion;
    }

    // Prueba
    public static void main(String[] args) {
        Connection conexion = Conexion.getConexion();

        if (conexion != null) {
            System.out.println("Conexión éxitos: " + conexion);
        } else {
            System.out.println("Error al conectarse");
        }
    }
}
