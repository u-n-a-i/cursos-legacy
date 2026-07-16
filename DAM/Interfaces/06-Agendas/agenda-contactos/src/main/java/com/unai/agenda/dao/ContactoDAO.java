package com.unai.agenda.dao;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.unai.agenda.db.ConexionBD;
import com.unai.agenda.model.Contacto;

public class ContactoDAO {

    public static void guardar(Contacto contacto) {
        String sql = "INSERT INTO contactos (nombre, telefono, correo, web_personal, imagen_perfil) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement pstmt = ConexionBD.getConexion().prepareStatement(sql)) {
            pstmt.setString(1, contacto.getNombre().get());
            pstmt.setString(2, contacto.getTelefono().get());
            pstmt.setString(3, contacto.getCorreo().get());
            pstmt.setString(4, contacto.getWebPersonal().get());
            pstmt.setString(5, contacto.getImagenPerfil().get());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void actualizar(Contacto contacto) {
        String sql = "UPDATE contactos SET nombre=?, telefono=?, correo=?, web_personal=?, imagen_perfil=? WHERE nombre=?";

        try (PreparedStatement pstmt = ConexionBD.getConexion().prepareStatement(sql)) {
            pstmt.setString(1, contacto.getNombre().get());
            pstmt.setString(2, contacto.getTelefono().get());
            pstmt.setString(3, contacto.getCorreo().get());
            pstmt.setString(4, contacto.getWebPersonal().get());
            pstmt.setString(5, contacto.getImagenPerfil().get());
            pstmt.setString(6, contacto.getNombre().get());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void eliminar(Contacto contacto) {
        String sql = "DELETE FROM contactos WHERE nombre=?";

        try (PreparedStatement pstmt = ConexionBD.getConexion().prepareStatement(sql)) {
            pstmt.setString(1, contacto.getNombre().get());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ObservableList<Contacto> obtenerTodos() {
        ObservableList<Contacto> contactos = FXCollections.observableArrayList();
        String sql = "SELECT * FROM contactos";

        try (PreparedStatement pstmt = ConexionBD.getConexion().prepareStatement(sql);
                ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Contacto contacto = new Contacto(
                        rs.getString("nombre"),
                        rs.getString("correo"),
                        rs.getString("imagen_perfil"),
                        rs.getString("web_personal"),
                        rs.getString("telefono"));
                contactos.add(contacto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contactos;
    }
}
