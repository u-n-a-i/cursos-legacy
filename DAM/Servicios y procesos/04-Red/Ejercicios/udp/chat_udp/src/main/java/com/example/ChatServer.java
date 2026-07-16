package com.example;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ChatServer extends Application {

    private static final int PORT = 10101;
    private DatagramSocket socket;
    private TextArea logArea;

    // Mapeo: dirección del cliente → nombre
    private final Map<SocketAddress, String> clientNames = new ConcurrentHashMap<>();
    // Mapeo inverso: nombre → dirección (para envío privado)
    private final Map<String, SocketAddress> nameToAddress = new ConcurrentHashMap<>();

    @Override
    public void start(Stage primaryStage) {
        logArea = new TextArea();
        logArea.setEditable(false);
        logArea.setWrapText(true);

        VBox root = new VBox(logArea);
        Scene scene = new Scene(root, 400, 300);

        primaryStage.setTitle("Servidor (UDP)");
        primaryStage.setScene(scene);
        primaryStage.setOnCloseRequest(e -> {
            if (socket != null && !socket.isClosed()) {
                socket.close();
            }
        });
        primaryStage.show();

        try {
            socket = new DatagramSocket(PORT);
            appendLog("Servidor UDP iniciado en puerto " + PORT);

            // Hilo para recibir datagramas
            new Thread(this::receivePackets).start();
        } catch (SocketException e) {
            appendLog("Error al iniciar servidor: " + e.getMessage());
        }
    }

    private void receivePackets() {
        byte[] buffer = new byte[2048];
        while (socket != null && !socket.isClosed()) {
            try {
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                socket.receive(packet);

                String msg = new String(packet.getData(), 0, packet.getLength(), StandardCharsets.UTF_8).trim();
                SocketAddress clientAddr = packet.getSocketAddress();

                appendLog("Recibido de " + clientAddr + ": " + msg);

                String[] parts = msg.split("\\|", 3);
                if (parts.length < 2)
                    continue;

                String type = parts[0];
                String username = parts[1];

                switch (type) {
                    case "JOIN":
                        handleJoin(clientAddr, username);
                        break;
                    case "MSG":
                        if (parts.length == 3) {
                            String recipient = username; // parts[1] = destinatario
                            String message = parts[2];
                            String sender = clientNames.get(clientAddr);
                            handleMessage(sender, recipient, message);
                        }
                        break;
                    case "LEAVE":
                        handleLeave(clientAddr, username);
                        break;
                }

            } catch (IOException e) {
                if (!socket.isClosed()) {
                    appendLog("Error recibiendo paquete: " + e.getMessage());
                }
            }
        }
    }

    private void handleJoin(SocketAddress addr, String username) {
        String oldName = clientNames.put(addr, username);
        nameToAddress.put(username, addr);

        if (oldName != null && !oldName.equals(username)) {
            nameToAddress.remove(oldName);
        }

        appendLog(username + " se ha unido desde " + addr);
        broadcastUserList();
        // Notificación a todos
        broadcastMessage("*** " + username + " se ha unido al chat ***", username);
    }

    private void handleLeave(SocketAddress addr, String username) {
        clientNames.remove(addr);
        nameToAddress.remove(username);
        appendLog(username + " ha salido");
        broadcastUserList();
        broadcastMessage("*** " + username + " ha salido del chat ***", username);
    }

    private void handleMessage(String sender, String recipient, String message) {
        if (sender == null) {
            appendLog("Mensaje sin remitente conocido");
            return;
        }

        String formattedMsg;
        if ("Todos".equals(recipient)) {
            formattedMsg = sender + " (a todos): " + message;
            broadcastMessage(formattedMsg, sender);
        } else {
            formattedMsg = sender + " -> " + recipient + ": " + message;
            sendMessageTo(recipient, formattedMsg);
        }
    }

    private void sendMessageTo(String username, String message) {
        SocketAddress target = nameToAddress.get(username);
        if (target != null) {
            sendPacket(message, target);
        } else {
            appendLog("Destinatario no encontrado: " + username);
        }
    }

    private void broadcastMessage(String message, String sender) {
        for (Map.Entry<SocketAddress, String> entry : clientNames.entrySet()) {
            String name = entry.getValue();
            SocketAddress addr = entry.getKey();
            if (!name.equals(sender)) {
                sendPacket(message, addr);
            }
        }
    }

    private void broadcastUserList() {
        StringBuilder sb = new StringBuilder("USER_LIST|");
        boolean first = true;
        for (String name : nameToAddress.keySet()) {
            if (!first)
                sb.append(",");
            sb.append(name);
            first = false;
        }

        String userList = sb.toString();
        for (SocketAddress addr : clientNames.keySet()) {
            sendPacket(userList, addr);
        }
    }

    private void sendPacket(String message, SocketAddress target) {
        try {
            byte[] data = message.getBytes(StandardCharsets.UTF_8);
            DatagramPacket packet = new DatagramPacket(data, data.length, target);
            socket.send(packet);
            appendLog("Enviado a " + target + ": " + message);
        } catch (IOException e) {
            appendLog("Error enviando a " + target + ": " + e.getMessage());
        }
    }

    private void appendLog(String message) {
        Platform.runLater(() -> logArea.appendText(message + "\n"));
    }

    public static void main(String[] args) {
        launch(args);
    }
}