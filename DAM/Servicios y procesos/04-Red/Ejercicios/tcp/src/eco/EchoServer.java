package eco;

import java.io.*;
import java.net.*;

public class EchoServer {
    public static void main(String[] args) {
        int puerto = 4444; // Puerto donde escucha el servidor

        try (ServerSocket serverSocket = new ServerSocket(puerto)) {
            System.out.println("Servidor de eco iniciado en el puerto " + puerto);

            // El servidor se queda esperando conexiones
            Socket socket = serverSocket.accept();
            System.out.println("Cliente conectado: " + socket.getInetAddress());

            // Streams de entrada y salida
            BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);

            String mensaje;
            // Bucle de comunicación
            while ((mensaje = entrada.readLine()) != null) {
                System.out.println("Cliente dice: " + mensaje);
                salida.println("Eco: " + mensaje);

                if (mensaje.equalsIgnoreCase("Adios")) {
                    System.out.println("Cliente ha finalizado la conexión.");
                    break;
                }
            }

            // Cerrar recursos
            entrada.close();
            salida.close();
            socket.close();
            System.out.println("Servidor cerrado.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
