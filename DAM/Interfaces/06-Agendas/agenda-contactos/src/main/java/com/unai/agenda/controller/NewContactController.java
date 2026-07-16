package com.unai.agenda.controller;

import com.unai.agenda.model.Contacto;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class NewContactController {

    private boolean modoEdicion = false;
    private Contacto contactoActual = null;

    @FXML
    private TextField campoNombre;
    @FXML
    private TextField campoTelefono;
    @FXML
    private TextField campoCorreo;
    @FXML
    private TextField campoWebPersonal;
    @FXML
    private Label nombreImagen;
    @FXML
    private ImageView previsualizacionImagen;

    private File archivoImagen;
    private MainViewController controladorPrincipal;

    // método para enlazar con el controlador principal
    public void setControladorPrincipal(MainViewController controladorPrincipal) {
        this.controladorPrincipal = controladorPrincipal;
    }

    // método para enlazar con el contacto actual
    public void setContactoActual(Contacto contactoActual) {

        // vinculamos el contacto
        this.contactoActual = contactoActual;

        // rellenamos los datos del contacto
        if (contactoActual != null) {
            campoNombre.setText(contactoActual.getNombre().get());
            campoTelefono.setText(contactoActual.getTelefono().get());
            campoCorreo.setText(contactoActual.getCorreo().get());
            campoWebPersonal.setText(contactoActual.getWebPersonal().get());
            nombreImagen.setText(contactoActual.getImagenPerfil().getValue().toString());
        }

        // estamos editando, fijamos modo edición
        modoEdicion = true;
    }

    @FXML
    public void initialize() {
        // código de inicialización si es necesario
    }

    @FXML
    private void cargarImagen() {

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Seleccionar Imagen de Perfil");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("PNG y JPG", "*.png", "*.jpg"));

        archivoImagen = fileChooser.showOpenDialog(null);

        if (archivoImagen != null) {

            // si queremos ver vista previa de la imagen
            Image imagen = new Image(archivoImagen.toURI().toString());
            previsualizacionImagen.setImage(imagen);

            // mostramos nombre de la imagen
            nombreImagen.setText(Paths.get(archivoImagen.getAbsolutePath()).getFileName().toString());
        }
    }

    @FXML
    private void guardarContacto() {

        String nombre = campoNombre.getText();
        String telefono = campoTelefono.getText();
        String correo = campoCorreo.getText();
        String webPersonal = campoWebPersonal.getText();
        String imagen = guardarImagen();

        // guardamos o editamos dependiendo del modo
        if (modoEdicion) {

            // editamos el contactoActual, que está vinculado a la lista del controlador
            // principal
            this.contactoActual.setCorreo(correo);
            this.contactoActual.setNombre(nombre);
            this.contactoActual.setTelefono(telefono);
            this.contactoActual.setWebPersonal(webPersonal);
            this.contactoActual.setImagenPerfil(imagen);
            modoEdicion = false;

            // mostramos mensaje
            controladorPrincipal.mostrarMensajeEdicion(contactoActual);

        } else {
            // agregamos el nuevo contacto a la lista del ControladorPrincipal
            Contacto nuevoContacto = new Contacto(nombre, correo, imagen, webPersonal, telefono);
            controladorPrincipal.agregarContacto(nuevoContacto);
        }

        // cerramos ventana
        cancelar();
    }

    @FXML
    private void cancelar() {

        // obtenemos la instancia de la ventana actual
        Stage ventanaActual = (Stage) campoNombre.getScene().getWindow();

        // cerramos la ventana
        ventanaActual.close();
    }

    private String guardarImagen() {

        // si no hay archivo ni texto → usar default
        if (archivoImagen == null && nombreImagen.getText().isEmpty()) {
            return "default.jpg";
        }

        // si no hay archivo pero hay texto → mantener el nombre existente
        if (archivoImagen == null) {
            return nombreImagen.getText();
        }

        // si hay archivo, lo guardamos
        try {
            Path carpetaDestino = Paths.get("src/main/resources/com/unai/agenda/img");

            Path imagenOrigen = Paths.get(archivoImagen.getAbsolutePath());
            Path imagenDestino = carpetaDestino.resolve(imagenOrigen.getFileName());

            Files.copy(imagenOrigen, imagenDestino, StandardCopyOption.REPLACE_EXISTING);

            // actualizar el nombre de la imagen
            nombreImagen.setText(imagenOrigen.getFileName().toString());

            return imagenOrigen.getFileName().toString();

        } catch (IOException e) {
            e.printStackTrace();
            return "default.jpg"; // fallback por si falla la copia
        }
    }

}
