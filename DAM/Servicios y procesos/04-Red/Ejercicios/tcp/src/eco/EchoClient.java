package eco;

import java.io.*;
import java.net.*;

public class EchoClient {
    public static void main(String[] args) {
        String host = "localhost"; // Servidor en la misma máquina
        int puerto = 5000;

        try (Socket socket = new Socket(host, puerto)) {
            BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);

            String mensaje;
            System.out.println("Conectado al servidor de eco. Escribe mensajes (\"Adios\" para salir):");

            // Bucle de envío y recepción
            while ((mensaje = teclado.readLine()) != null) {
                salida.println(mensaje); // Enviar al servidor
                String respuesta = entrada.readLine(); // Recibir eco
                System.out.println(respuesta);

                if (mensaje.equalsIgnoreCase("Adios")) {
                    System.out.println("Finalizando cliente...");
                    break;
                }
            }

            // Cerrar recursos
            teclado.close();
            entrada.close();
            salida.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
