package gestionestudiantes.datos;

import gestionestudiantes.dominio.Estudiante;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static gestionestudiantes.conexion.Conexion.getConexion;

public class EstudianteDAO {
    public List<Estudiante> listarEstudiantes() {
        List<Estudiante> estudiantes = new ArrayList<>();

        PreparedStatement ps;
        ResultSet rs;
        Connection con = getConexion();
        String sql = "SELECT * FROM estudiante ORDER BY id_estudiante";

        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Estudiante estudiante = new Estudiante();
                estudiante.setIdEstudiante(rs.getInt("id_estudiante"));
                estudiante.setNombre(rs.getString("nombre"));
                estudiante.setApellido(rs.getString("apellido"));
                estudiante.setTelefono(rs.getString("telefono"));
                estudiante.setEmail(rs.getString("email"));

                estudiantes.add(estudiante);
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
        return estudiantes;
    }

    public boolean buscarEstudiantePorId(Estudiante estudiante) {
        Connection con = getConexion();
        PreparedStatement ps;
        ResultSet rs;
        String sql = "SELECT * FROM estudiante WHERE id_estudiante = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, estudiante.getIdEstudiante());
            rs = ps.executeQuery();
            if (rs.next()) {
                estudiante.setNombre(rs.getString("nombre"));
                estudiante.setApellido(rs.getString("apellido"));
                estudiante.setTelefono(rs.getString("telefono"));
                estudiante.setEmail(rs.getString("email"));
                return true;
            }
        } catch (Exception e) {
            System.out.println("Error al buscar el estudiante: " + e.getMessage());
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println("No se ha podido cerrar la conexión " + e.getMessage());
            }
        }

        return false;
    }

    public boolean agregarEstudiante(Estudiante estudiante) {
        PreparedStatement ps;
        Connection con = getConexion();
        String sql = "INSERT INTO estudiante(nombre, apellido, telefono, email)"
                + " VALUES(?,?,?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, estudiante.getNombre());
            ps.setString(2, estudiante.getApellido());
            ps.setString(3, estudiante.getTelefono());
            ps.setString(4, estudiante.getEmail());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al agregar el usuario." + e.getMessage());
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión");
            }
        }
        return false;
    }

    public boolean modificarEstudiante(Estudiante estudiante) {
        PreparedStatement ps;
        Connection con = getConexion();
        String sql = "UPDATE estudiante SET nombre =?, apellido=?, telefono=?, email=?"
                + " WHERE id_estudiante= ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, estudiante.getNombre());
            ps.setString(2, estudiante.getApellido());
            ps.setString(3, estudiante.getTelefono());
            ps.setString(4, estudiante.getEmail());
            ps.setInt(5, estudiante.getIdEstudiante());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al modificar el usuario." + e.getMessage());
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión");
            }
        }
        return false;
    }

    public boolean eliminarEstudiante(Estudiante estudiante) {
        PreparedStatement ps;
        Connection con = getConexion();
        String sql = "DELETE FROM estudiante WHERE id_estudiante=?";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, estudiante.getIdEstudiante());
            ps.execute();

            return true;
        } catch (Exception e) {
            System.out.println("Error al eliminar el estudiante");
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión");
            }
        }
        return false;
    }

    //Pruebas - Borrar
    public static void main(String[] args) {
        System.out.println("**** Eliminar Estudiante ****");
        EstudianteDAO estudianteDAO = new EstudianteDAO();
        Estudiante estudiante = new Estudiante(3);
        boolean eliminado = estudianteDAO.modificarEstudiante(estudiante);

        if (eliminado) {
            System.out.println("Estudiante eliminado.");
        } else {
            System.out.println("No se pudo eliminar el estudiante.");
        }

//        System.out.println("**** Modificar Estudiante ****");
//        EstudianteDAO estudianteDAO = new EstudianteDAO();
//        Estudiante estudiante =
//                new Estudiante(3, "Juan Carlos", "Lara", "555444333", "juancarlos@mail.com");
//        boolean modificado = estudianteDAO.modificarEstudiante(estudiante);
//
//        if (modificado) {
//            System.out.println("Estudiante modificado.");
//        } else {
//            System.out.println("No se pudo agregar el estudiante.");
//        }

//        System.out.println("**** Agregar Estudiante ****");
//        EstudianteDAO estudianteDAO = new EstudianteDAO();
//        Estudiante estudiante =
//                new Estudiante("Carlos", "Lara", "555444333", "carlos@mail.com");
//        boolean agregado = estudianteDAO.agregarEstudiante(estudiante);
//
//        if (agregado) {
//            System.out.println("Estudiante agregado.");
//        } else {
//            System.out.println("No se pudo agregar el estudiante.");
//        }

//        System.out.println("**** Listar estudiantes ****");
//        EstudianteDAO estudianteDAO = new EstudianteDAO();
//        List<Estudiante> estudiantes = estudianteDAO.listarEstudiantes();
//        estudiantes.forEach(System.out::println);

//        System.out.println("**** Buscar por ID ****");
//        Estudiante estudiante = new Estudiante(1);
//        System.out.println("Estudiante");
//        boolean encontrado = estudianteDAO.buscarEstudiantePorId(estudiante);
//        if (encontrado) {
//            System.out.println(estudiante);
//        } else {
//            System.out.println("No se ha encontrado el estudiante." + estudiante.getNombre());
//        }
    }
}
