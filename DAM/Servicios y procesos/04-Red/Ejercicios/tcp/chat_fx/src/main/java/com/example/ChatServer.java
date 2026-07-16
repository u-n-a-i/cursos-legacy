package com.example;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ChatServer extends Application {

    private static final int DEFAULT_PORT = 10101;
    private ServerSocket serverSocket;
    private Map<String, ClientHandler> clients = new ConcurrentHashMap<>();
    private TextArea logArea;

    @Override
    public void start(Stage primaryStage) {
        logArea = new TextArea();
        logArea.setEditable(false);
        logArea.setWrapText(true);

        VBox root = new VBox(logArea);
        Scene scene = new Scene(root, 400, 300);

        primaryStage.setTitle("Servidor");
        primaryStage.setScene(scene);
        primaryStage.show();

        new Thread(this::startServer).start();
    }

    private void startServer() {
        try {
            serverSocket = new ServerSocket(DEFAULT_PORT);
            appendLog("Inicializando el servidor... [OK]");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                ClientHandler clientHandler = new ClientHandler(clientSocket, this);
                new Thread(clientHandler).start();
            }
        } catch (IOException e) {
            appendLog("Error al iniciar el servidor: " + e.getMessage());
        }
    }

    // Envía un mensaje privado a un destinatario específico
    public synchronized void sendMessageTo(String recipient, String message) {
        ClientHandler target = clients.get(recipient);
        if (target != null) {
            target.sendMessage(message);
        } else {
            appendLog("Destinatario no encontrado: " + recipient);
        }
    }

    // Envía un mensaje a todos los clientes excepto al remitente
    public synchronized void broadcastMessage(String message, String sender) {
        for (Map.Entry<String, ClientHandler> entry : clients.entrySet()) {
            String username = entry.getKey();
            ClientHandler handler = entry.getValue();
            if (!username.equals(sender)) {
                handler.sendMessage(message);
            }
        }
    }

    // Agrega un cliente y notifica a los demás
    public synchronized void addClient(String username, ClientHandler handler) {
        clients.put(username, handler);
        appendLog("Cliente conectado: " + username + " (Total: " + clients.size() + ")");

        // Notificación de entrada
        String joinMsg = "*** " + username + " se ha unido al chat ***";
        for (ClientHandler c : clients.values()) {
            if (!c.username.equals(username)) {
                c.sendMessage(joinMsg);
            }
        }

        // Actualizar listas de usuarios en todos los clientes
        broadcastUserList();
    }

    // Elimina un cliente y notifica a los demás
    public synchronized void removeClient(String username) {
        clients.remove(username);
        appendLog("Cliente desconectado: " + username + " (Total: " + clients.size() + ")");

        // Notificación de salida
        String leaveMsg = "*** " + username + " ha salido del chat ***";
        for (ClientHandler c : clients.values()) {
            c.sendMessage(leaveMsg);
        }

        broadcastUserList();
    }

    // Envía la lista actual de usuarios a todos los clientes
    private void broadcastUserList() {
        String userList = String.join(",", clients.keySet());
        for (ClientHandler client : clients.values()) {
            client.sendUserList(userList);
        }
    }

    private void appendLog(String message) {
        Platform.runLater(() -> logArea.appendText(message + "\n"));
    }

    public static void main(String[] args) {
        launch(args);
    }

    // Clase interna: maneja la comunicación con un cliente
    private class ClientHandler implements Runnable {
        private Socket socket;
        private ChatServer server;
        public String username; // público para acceso rápido

        public ClientHandler(Socket socket, ChatServer server) {
            this.socket = socket;
            this.server = server;
        }

        @Override
        public void run() {
            try {
                var in = new java.io.BufferedReader(new java.io.InputStreamReader(socket.getInputStream()));
                var out = new java.io.PrintWriter(socket.getOutputStream(), true);

                // Recibir nombre único del cliente
                username = in.readLine();
                server.addClient(username, this);

                String line;
                while ((line = in.readLine()) != null) {
                    String[] parts = line.split("\\|", 2);
                    if (parts.length == 2) {
                        String recipient = parts[0];
                        String message = parts[1];

                        if ("Todos".equals(recipient)) {
                            // Mensaje público
                            String broadcastMsg = username + " (a todos): " + message;
                            server.broadcastMessage(broadcastMsg, username);
                        } else {
                            // Mensaje privado
                            String privateMsg = username + " -> " + recipient + ": " + message;
                            server.sendMessageTo(recipient, privateMsg);
                        }
                    }
                }
            } catch (IOException e) {
                server.appendLog("Error con cliente '" + username + "': " + e.getMessage());
            } finally {
                server.removeClient(username);
                try {
                    socket.close();
                } catch (IOException e) {
                    // ignorar
                }
            }
        }

        public void sendMessage(String message) {
            try {
                var out = new java.io.PrintWriter(socket.getOutputStream(), true);
                out.println(message);
            } catch (IOException e) {
                server.appendLog("Error al enviar mensaje a '" + username + "': " + e.getMessage());
            }
        }

        public void sendUserList(String userList) {
            try {
                var out = new java.io.PrintWriter(socket.getOutputStream(), true);
                out.println("USER_LIST|" + userList);
            } catch (IOException e) {
                server.appendLog("Error al enviar lista de usuarios a '" + username + "': " + e.getMessage());
            }
        }
    }
}