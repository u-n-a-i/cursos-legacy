package com.example;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ChatClient extends Application {

    private static final String DEFAULT_SERVER_IP = "127.0.0.1";
    private static final int DEFAULT_PORT = 10101;

    private Socket socket;
    private PrintWriter out;
    private BufferedReader in;
    private TextArea chatArea;
    private TextField messageField;
    private ComboBox<String> recipientCombo;
    private String username;
    private List<String> connectedUsers = new ArrayList<>();

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Ventana de configuración inicial
        Stage configStage = new Stage();
        configStage.setTitle("Configuraciones de la comunicación");

        Label ipLabel = new Label("IP del Servidor:");
        TextField ipField = new TextField(DEFAULT_SERVER_IP);
        Label portLabel = new Label("Puerto de la conexión:");
        TextField portField = new TextField(String.valueOf(DEFAULT_PORT));
        Label nameLabel = new Label("Escriba su nombre:");
        TextField nameField = new TextField();

        Button okButton = new Button("OK");
        okButton.setOnAction(e -> {
            String ip = ipField.getText().trim();
            int port;
            try {
                port = Integer.parseInt(portField.getText().trim());
            } catch (NumberFormatException ex) {
                showAlert("Error", "Puerto inválido.");
                return;
            }
            username = nameField.getText().trim();

            if (username.isEmpty()) {
                showAlert("Nombre requerido", "Por favor ingrese su nombre.");
                return;
            }

            try {
                connectToServer(ip, port);
                configStage.close();
                createChatWindow(primaryStage);
            } catch (Exception ex) {
                showAlert("Error de Conexión", "No se pudo conectar al servidor:\n" + ex.getMessage());
            }
        });

        Button cancelButton = new Button("Cancelar");
        cancelButton.setOnAction(e -> Platform.exit());

        VBox configLayout = new VBox(10);
        configLayout.setPadding(new Insets(20));
        configLayout.getChildren().addAll(
                ipLabel, ipField,
                portLabel, portField,
                nameLabel, nameField,
                new HBox(10, okButton, cancelButton));

        Scene configScene = new Scene(configLayout, 300, 250);
        configStage.setScene(configScene);
        configStage.setOnCloseRequest(event -> Platform.exit());
        configStage.show();
    }

    private void connectToServer(String ip, int port) throws IOException {
        socket = new Socket(ip, port);
        out = new PrintWriter(socket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        // Enviar nombre al servidor
        out.println(username);
    }

    private void createChatWindow(Stage stage) {
        chatArea = new TextArea();
        chatArea.setEditable(false);
        chatArea.setWrapText(true);

        recipientCombo = new ComboBox<>();
        recipientCombo.getItems().add("Todos");
        recipientCombo.setValue("Todos");

        messageField = new TextField();
        messageField.setPromptText("Escribe tu mensaje...");
        messageField.setOnAction(e -> sendMessage()); // Enter también envía

        Button sendButton = new Button("Enviar");
        sendButton.setOnAction(e -> sendMessage());

        HBox inputBar = new HBox(10);
        inputBar.setPadding(new Insets(5));
        inputBar.getChildren().addAll(
                new Label("Para:"),
                recipientCombo,
                messageField,
                sendButton);

        VBox root = new VBox(10);
        root.setPadding(new Insets(10));
        root.getChildren().addAll(chatArea, inputBar);

        Scene scene = new Scene(root, 550, 450);
        stage.setTitle("--- " + username + " ---");
        stage.setScene(scene);

        // ✅ Cierre limpio al cerrar la ventana
        stage.setOnCloseRequest(event -> {
            event.consume(); // cancela cierre automático

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Salir del chat");
            alert.setHeaderText(null);
            alert.setContentText("¿Deseas desconectarte del chat?");

            // Personalizar botones
            ButtonType btnSalir = new ButtonType("Salir");
            ButtonType btnCancelar = new ButtonType("Cancelar", ButtonBar.ButtonData.CANCEL_CLOSE);
            alert.getButtonTypes().setAll(btnSalir, btnCancelar);

            alert.showAndWait().ifPresent(response -> {
                if (response == btnSalir) {
                    closeConnection();
                    Platform.exit();
                    System.exit(0);
                }
            });
        });

        stage.show();

        // Iniciar hilo de recepción de mensajes
        new Thread(this::receiveMessages).start();
    }

    private void receiveMessages() {
        try {
            String line;
            while ((line = in.readLine()) != null) {
                if (line.startsWith("USER_LIST|")) {
                    String userListStr = line.substring("USER_LIST|".length());
                    updateRecipientList(userListStr);
                } else {
                    final String msg = line;
                    Platform.runLater(() -> chatArea.appendText(msg + "\n"));
                }
            }
        } catch (IOException e) {
            Platform.runLater(() -> {
                if (!"Socket closed".equals(e.getMessage())) {
                    showAlert("Conexión perdida", "Se ha perdido la conexión con el servidor.");
                }
                // Aún así, limpiar recursos
                closeConnection();
            });
        } finally {
            closeConnection();
        }
    }

    private void updateRecipientList(String userListStr) {
        Platform.runLater(() -> {
            connectedUsers.clear();
            recipientCombo.getItems().clear();
            recipientCombo.getItems().add("Todos");

            if (!userListStr.trim().isEmpty()) {
                String[] users = userListStr.split(",");
                for (String user : users) {
                    if (!user.equals(username)) {
                        connectedUsers.add(user);
                        recipientCombo.getItems().add(user);
                    }
                }
            }

            // Si no hay otros usuarios, "Todos" sigue estando (pero no hará nada útil)
            if (recipientCombo.getItems().size() == 1) {
                recipientCombo.setDisable(true);
            } else {
                recipientCombo.setDisable(false);
            }
        });
    }

    private void sendMessage() {
        String recipient = recipientCombo.getValue();
        String message = messageField.getText().trim();

        if (message.isEmpty()) {
            return;
        }

        // Enviar mensaje al servidor
        out.println(recipient + "|" + message);
        messageField.clear();
    }

    private void closeConnection() {
        try {
            if (socket != null && !socket.isClosed()) {
                socket.close();
            }
        } catch (IOException e) {
            // ignorar
        } finally {
            // Cerrar streams (incluso si socket ya está cerrado)
            try {
                if (out != null)
                    out.close();
            } catch (Exception ignored) {
            }
            try {
                if (in != null)
                    in.close();
            } catch (Exception ignored) {
            }
            socket = null;
            out = null;
            in = null;
        }
    }

    private void showAlert(String title, String content) {
        Platform.runLater(() -> {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle(title);
            alert.setHeaderText(null);
            alert.setContentText(content);
            alert.showAndWait();
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}