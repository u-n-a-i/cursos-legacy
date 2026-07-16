package chat;

import java.io.*;
import java.net.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;

public class Ejercicio3Servidor {
    private static final int PUERTO = 4444;
    private static final Map<String, ClienteHandler> clientes = new ConcurrentHashMap<>();

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PUERTO)) {
            System.out.println("Servidor de chat iniciado en puerto " + PUERTO);

            while (true) {
                Socket clienteSocket = serverSocket.accept();
                new Thread(new ClienteHandler(clienteSocket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class ClienteHandler implements Runnable {
        private final Socket socket;
        private String nombre;
        private BufferedReader in;
        private PrintWriter out;

        public ClienteHandler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);

                // Paso 1: recibir nombre
                nombre = in.readLine();
                if (nombre == null || nombre.trim().isEmpty()) {
                    out.println("Nombre inválido. Desconectando.");
                    cerrarRecursos();
                    return;
                }

                if (clientes.containsKey(nombre)) {
                    out.println("Nombre ya en uso. Intenta otro.");
                    cerrarRecursos();
                    return;
                }

                clientes.put(nombre, this);

                broadcast("[" + nombre + "] se ha unido al chat.", null);
                System.out.println("Cliente '" + nombre + "' conectado.");

                // Leer mensajes
                String mensaje;
                while ((mensaje = in.readLine()) != null) {
                    procesarMensaje(mensaje);
                }

            } catch (IOException e) {
                System.err.println(
                        "Cliente '" + (nombre != null ? nombre : "desconocido") + "' desconectado abruptamente.");
            } finally {
                desconectar();
            }
        }

        private void procesarMensaje(String mensaje) {
            if (mensaje.startsWith("[") && mensaje.contains("]")) {
                int endIdx = mensaje.indexOf(']');
                String destino = mensaje.substring(1, endIdx);
                String contenido = mensaje.substring(endIdx + 1).trim(); // más robusto

                if ("TODOS".equalsIgnoreCase(destino)) {
                    broadcast("[" + nombre + " => TODOS]: " + contenido, nombre);
                } else {
                    // mensaje privado
                    ClienteHandler dest = clientes.get(destino);
                    if (dest != null) {
                        dest.enviarMensaje("[" + nombre + " → TÚ]: " + contenido);
                        enviarMensaje("[TÚ → " + destino + "]: " + contenido); // eco para remitente
                    } else {
                        enviarMensaje("Usuario '" + destino + "' no encontrado.");
                    }
                }
            } else if ("/usuarios".equals(mensaje)) {
                String lista = String.join(", ", clientes.keySet());
                enviarMensaje("Usuarios conectados: " + (lista.isEmpty() ? "ninguno" : lista));
            } else {
                enviarMensaje("Formato: [TODOS] mensaje  o  [Nombre] mensaje");
            }
        }

        private void enviarMensaje(String msg) {
            out.println(msg);
        }

        private void broadcast(String msg, String excluido) {
            for (ClienteHandler ch : clientes.values()) {
                if (excluido == null || !ch.nombre.equals(excluido)) {
                    ch.enviarMensaje(msg);
                }
            }
        }

        private void desconectar() {
            if (nombre != null) {
                clientes.remove(nombre);
                broadcast("[" + nombre + "] ha salido del chat.", null);
                System.out.println("Cliente '" + nombre + "' desconectado.");
            }
            cerrarRecursos();
        }

        private void cerrarRecursos() {
            try {
                if (in != null)
                    in.close();
                if (out != null)
                    out.close();
                if (socket != null && !socket.isClosed())
                    socket.close();
            } catch (IOException ignored) {
            }
        }
    }
}
