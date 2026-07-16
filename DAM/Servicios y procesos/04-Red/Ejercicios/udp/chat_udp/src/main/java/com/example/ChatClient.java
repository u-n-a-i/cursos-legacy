package com.example;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * Cliente de chat por UDP.
 * Se conecta al servidor UDP en 127.0.0.1:10101.
 * Envía: JOIN|Nombre, MSG|Dest|Mensaje, LEAVE|Nombre
 */
public class ChatClient extends Application {

    private static final String SERVER_IP = "127.0.0.1";
    private static final int SERVER_PORT = 10101;

    private DatagramSocket socket;
    private InetAddress serverAddress;
    private String username;
    private TextArea chatArea;
    private TextField messageField;
    private ComboBox<String> recipientCombo;
    private List<String> connectedUsers = new ArrayList<>();

    @Override
    public void start(Stage primaryStage) throws Exception {
        Stage configStage = new Stage();
        configStage.setTitle("Configuraciones de la comunicación");

        Label ipLabel = new Label("IP del Servidor:");
        TextField ipField = new TextField(SERVER_IP);
        Label portLabel = new Label("Puerto:");
        TextField portField = new TextField(String.valueOf(SERVER_PORT));
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
                serverAddress = InetAddress.getByName(ip);
                socket = new DatagramSocket(); // Puerto efímero asignado por SO
                // Enviar JOIN al servidor
                sendToServer("JOIN|" + username);
                configStage.close();
                createChatWindow(primaryStage);
            } catch (Exception ex) {
                showAlert("Error", "No se pudo conectar: " + ex.getMessage());
            }
        });

        Button cancelButton = new Button("Cancelar");
        cancelButton.setOnAction(e -> Platform.exit());

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20));
        layout.getChildren().addAll(ipLabel, ipField, portLabel, portField, nameLabel, nameField,
                new HBox(10, okButton, cancelButton));

        Scene scene = new Scene(layout, 300, 250);
        configStage.setScene(scene);
        configStage.setOnCloseRequest(e -> Platform.exit());
        configStage.show();
    }

    private void createChatWindow(Stage stage) {
        chatArea = new TextArea();
        chatArea.setEditable(false);
        chatArea.setWrapText(true);

        recipientCombo = new ComboBox<>();
        recipientCombo.getItems().add("Todos");
        recipientCombo.setValue("Todos");

        messageField = new TextField();
        messageField.setOnAction(e -> sendMessage());
        Button sendButton = new Button("Enviar");
        sendButton.setOnAction(e -> sendMessage());

        HBox inputBar = new HBox(10);
        inputBar.getChildren().addAll(new Label("Destinatario:"), recipientCombo, messageField, sendButton);

        VBox root = new VBox(10);
        root.setPadding(new Insets(10));
        root.getChildren().addAll(chatArea, inputBar);

        Scene scene = new Scene(root, 550, 450);
        stage.setTitle("--- " + username + " ---");
        stage.setScene(scene);

        // Cierre
        stage.setOnCloseRequest(e -> {
            e.consume();
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Salir");
            alert.setHeaderText(null);
            alert.setContentText("¿Deseas desconectarte del chat?");
            alert.showAndWait().ifPresent(response -> {
                if (response.getButtonData() == ButtonBar.ButtonData.OK_DONE) {
                    sendToServer("LEAVE|" + username);
                    closeConnection();
                    Platform.exit();
                    System.exit(0);
                }
            });
        });

        stage.show();

        // Iniciar hilo de recepción
        new Thread(this::receivePackets).start();
    }

    private void receivePackets() {
        byte[] buffer = new byte[2048];
        while (socket != null && !socket.isClosed()) {
            try {
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                socket.receive(packet);

                String msg = new String(packet.getData(), 0, packet.getLength(), StandardCharsets.UTF_8).trim();
                Platform.runLater(() -> {
                    if (msg.startsWith("USER_LIST|")) {
                        updateRecipientList(msg.substring("USER_LIST|".length()));
                    } else {
                        chatArea.appendText(msg + "\n");
                    }
                });
            } catch (IOException e) {
                if (!socket.isClosed()) {
                    Platform.runLater(() -> showAlert("Error", "No se puede recibir mensajes."));
                }
            }
        }
    }

    private void updateRecipientList(String userListStr) {
        recipientCombo.getItems().clear();
        recipientCombo.getItems().add("Todos");

        connectedUsers.clear();
        if (!userListStr.trim().isEmpty()) {
            String[] users = userListStr.split(",");
            for (String user : users) {
                if (!user.equals(username)) {
                    connectedUsers.add(user);
                    recipientCombo.getItems().add(user);
                }
            }
        }
        recipientCombo.setDisable(recipientCombo.getItems().size() == 1);
    }

    private void sendMessage() {
        String recipient = recipientCombo.getValue();
        String message = messageField.getText().trim();
        if (message.isEmpty())
            return;

        // Formato: MSG|Destinatario|Mensaje
        sendToServer("MSG|" + recipient + "|" + message);
        messageField.clear();
    }

    private void sendToServer(String message) {
        if (socket == null || socket.isClosed())
            return;
        try {
            byte[] data = message.getBytes(StandardCharsets.UTF_8);
            DatagramPacket packet = new DatagramPacket(data, data.length, serverAddress, SERVER_PORT);
            socket.send(packet);
        } catch (IOException e) {
            Platform.runLater(() -> showAlert("Error", "No se pudo enviar: " + e.getMessage()));
        }
    }

    private void closeConnection() {
        if (socket != null && !socket.isClosed()) {
            socket.close();
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