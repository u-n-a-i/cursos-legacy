package com.example.ddl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DDL {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/dam";
        String user = "root";
        String password = "root";

        try (Connection conn = DriverManager.getConnection(url, user, password);
                Statement stmt = conn.createStatement()) {

            // Crear empleado y departamento
            String crearEmpleado = """
                        CREATE TABLE IF NOT EXISTS empleado (
                            id INT PRIMARY KEY AUTO_INCREMENT,
                            nombre VARCHAR(20),
                            fecha_nacimiento DATE,
                            genero TINYINT(1),
                            departamento_id INT,
                            FOREIGN KEY (departamento_id) REFERENCES departamento(id)
                        );
                    """;

            String crearDepartamento = """
                        CREATE TABLE IF NOT EXISTS departamento (
                            id INT PRIMARY KEY AUTO_INCREMENT,
                            nombre VARCHAR(20),
                            ubicacion VARCHAR(100)
                        );
                    """;

            stmt.executeUpdate(crearDepartamento);
            stmt.executeUpdate(crearEmpleado);

            System.out.println("Tablas creadas.");

            // Agregar columna
            // String agregarColumna = "ALTER TABLE empleado ADD COLUMN departamento_id
            // INT";
            // stmt.executeUpdate(agregarColumna);
            // System.out.println("Columna agregada");

            // Clave foránea
            String addForeignKeySQL = """
                    ALTER TABLE empleado
                    ADD CONSTRAINT fk_departamento
                    FOREIGN KEY (departamento_id) REFERENCES departamento(id);
                    """;

            stmt.executeUpdate(addForeignKeySQL);
            System.out.println("Clave foránea creada con éxito.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
