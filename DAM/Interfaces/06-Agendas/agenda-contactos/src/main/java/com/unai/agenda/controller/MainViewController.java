package com.unai.agenda.controller;

import com.unai.agenda.model.Contacto;
import com.unai.agenda.dao.ContactoDAO;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MainViewController {

    @FXML
    private TableView<Contacto> tablaContactos;
    @FXML
    private TableColumn<Contacto, String> columnaNombre;
    @FXML
    private TableColumn<Contacto, String> columnaTelefono;
    @FXML
    private TableColumn<Contacto, String> columnaCorreo;
    @FXML
    private Label labelNombre;
    @FXML
    private Label labelTelefono;
    @FXML
    private Label labelCorreo;
    @FXML
    private Label labelWebPersonal;
    @FXML
    private ImageView imagenPerfil;
    @FXML
    private Button botonTema;

    private ObservableList<Contacto> listaContactos;
    private boolean esTemaOscuro = true;

    @FXML
    public void initialize() {

        // Establecer texto inicial del botón
        botonTema.setText("Claro");

        // crear borde para el ImageView
        DropShadow borde = new DropShadow();
        borde.setRadius(10.0);
        borde.setOffsetX(0);
        borde.setOffsetY(0);
        borde.setColor(Color.BLACK);
        imagenPerfil.setEffect(borde);

        listaContactos = ContactoDAO.obtenerTodos();

        // almacenamos los contactos de la lista en la tabla
        tablaContactos.setItems(listaContactos);

        // configuramos las columnas nombre, telefóno y correo
        columnaNombre.setCellValueFactory(cellData -> cellData.getValue().getNombre());
        columnaTelefono.setCellValueFactory(cellData -> cellData.getValue().getTelefono());
        columnaCorreo.setCellValueFactory(cellData -> cellData.getValue().getCorreo());

        // evento para actualizar la información del contacto seleccionado en la tabla
        tablaContactos.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> mostrarDetallesContacto(newValue));

    }

    // mostramos los detalles de un contacto en la parte derecha de la ventana
    public void mostrarDetallesContacto(Contacto contacto) {

        // comrpobamos si tenemos un Contacto
        if (contacto != null) {
            labelNombre.setText("Nombre: " + contacto.getNombre().getValue());
            labelTelefono.setText("Teléfono: " + contacto.getTelefono().getValue());
            labelCorreo.setText("Correo: " + contacto.getCorreo().getValue());
            labelWebPersonal.setText("Web personal: " + contacto.getWebPersonal().getValue());

            // si tenemos imagen de perfil
            if (contacto.getImagenPerfil().getValue() != null && !contacto.getImagenPerfil().getValue().isEmpty()) {
                imagenPerfil.setImage(new Image(getClass().getResourceAsStream(contacto.getRutaImagenPerfil())));
            } else {
                imagenPerfil.setImage(null);
            }
        } else {
            labelNombre.setText("Elige un contacto para visualizar sus datos");
            imagenPerfil.setImage(null);
        }
    }

    @FXML
    private NewContactController crearVentanaContacto() throws Exception {

        // cargamos el archivo FXML del formulario
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/unai/agenda/view/newContact.fxml"));
        Parent root = loader.load();

        // enlazamos el controlador del formulario con el controlador principal
        NewContactController controladorSecundario = loader.getController();
        controladorSecundario.setControladorPrincipal(this);

        // crear un nuevo Stage (ventana)
        Stage ventanaFormulario = new Stage();
        ventanaFormulario.setTitle("Añadir nuevo contacto");
        ventanaFormulario.initModality(Modality.WINDOW_MODAL);
        ventanaFormulario.initOwner(tablaContactos.getScene().getWindow());

        // establecer la escena y mostrar la ventana
        Scene escena = new Scene(root);

        // establecemos CSS
        escena.getStylesheets()
                .add(getClass().getResource("/com/unai/agenda/css/styles.css").toExternalForm());

        // mostramos ventana
        ventanaFormulario.setScene(escena);
        ventanaFormulario.setWidth(500);
        ventanaFormulario.setHeight(500);
        ventanaFormulario.show();

        // devolvemos el controlador de la ventana
        return controladorSecundario;
    }

    @FXML
    private void mostrarFormulario() throws Exception {
        crearVentanaContacto();
    }

    public void agregarContacto(Contacto c) {
        listaContactos.add(c);
        ContactoDAO.guardar(c);
    }

    @FXML
    private void editarContacto() throws Exception {

        Contacto contactoSeleccionado = tablaContactos.getSelectionModel().getSelectedItem();

        if (contactoSeleccionado != null) {
            NewContactController controladorSecundario = crearVentanaContacto();
            controladorSecundario.setContactoActual(contactoSeleccionado);

        } else {

            // informa al usuario que debe seleccionar un contacto para editarlo
            Alert alerta = new Alert(AlertType.ERROR);
            alerta.setTitle("ERROR");
            alerta.setHeaderText(null);
            alerta.setContentText(
                    "ERROR al editar contacto. Debes seleccionar un contacto de la tabla para poder editarlo.");
            alerta.showAndWait();
        }
    }

    @FXML
    private void eliminarContacto() {

        int indiceSeleccionado = tablaContactos.getSelectionModel().getSelectedIndex();

        if (indiceSeleccionado >= 0) {
            Contacto contacto = tablaContactos.getItems().get(indiceSeleccionado);
            tablaContactos.getItems().remove(indiceSeleccionado);
            ContactoDAO.eliminar(contacto); // Eliminar de BD

            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Contacto Borrado");
            alerta.setHeaderText(null);
            alerta.setContentText("El contacto ha sido borrado de forma correcta.");
            alerta.showAndWait();

        } else {

            // Informa al usuario que debe seleccionar un contacto para borrarlo
            Alert alerta = new Alert(AlertType.ERROR);
            alerta.setTitle("ERROR");
            alerta.setHeaderText(null);
            alerta.setContentText(
                    "ERROR al borrar contacto. Debes seleccionar un contacto de la tabla para poder borrarlo.");
            alerta.showAndWait();

        }
    }

    public void mostrarMensajeEdicion(Contacto c) {

        tablaContactos.getSelectionModel().clearSelection();

        Alert alerta = new Alert(AlertType.INFORMATION);
        alerta.setTitle("Contacto modificado");
        alerta.setHeaderText(null);
        alerta.setContentText(
                "El contacto " + c.getNombre().getValue() + " ha sido modificado de forma correcta.");
        alerta.showAndWait();
    }

    @FXML
    private void cambiarTema() {
        Scene scene = tablaContactos.getScene();

        if (esTemaOscuro) {
            // Cambiar a tema claro
            scene.getStylesheets().clear();
            scene.getStylesheets().add(getClass().getResource("/com/unai/agenda/css/light-theme.css").toExternalForm());
            botonTema.setText("Oscuro");
            esTemaOscuro = false;
        } else {
            // Cambiar a tema oscuro
            scene.getStylesheets().clear();
            scene.getStylesheets().add(getClass().getResource("/com/unai/agenda/css/dark-theme.css").toExternalForm());
            botonTema.setText("Claro");
            esTemaOscuro = true;
        }
    }
}
