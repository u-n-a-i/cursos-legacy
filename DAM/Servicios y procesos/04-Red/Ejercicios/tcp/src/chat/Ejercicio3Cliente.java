package chat;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Ejercicio3Cliente {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("IP del servidor (ej. 127.0.0.1): ");
            String ip = sc.nextLine();
            System.out.print("Puerto (ej. 4444): ");
            int puerto = Integer.parseInt(sc.nextLine());
            System.out.print("Tu nombre: ");
            String nombre = sc.nextLine();

            try (
                    Socket socket = new Socket(ip, puerto);
                    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                    BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    BufferedReader consola = new BufferedReader(new InputStreamReader(System.in))) {

                // Enviar nombre al conectar
                out.println(nombre);

                // Leer mensajes del servidor (en hilo separado)
                Thread hiloLectura = new Thread(() -> {
                    try {
                        String msg;
                        while ((msg = in.readLine()) != null) {
                            System.out.println("\nMensaje recibido: " + msg);
                        }
                    } catch (IOException e) {
                        System.out.println("Servidor desconectado.");
                    }
                });
                hiloLectura.setDaemon(true);
                hiloLectura.start();

                System.out.println("Conectado al chat. Usa:\n" +
                        "  [TODOS] Hola a todos\n" +
                        "  [Unai] Hola\n" +
                        "  /usuarios → ver conectados\n" +
                        "  Ctrl+C o vacío para salir");

                // Enviar mensajes
                String linea;
                while ((linea = consola.readLine()) != null && !linea.trim().isEmpty()) {
                    out.println(linea);
                }

                // cerrar socket al salir
                socket.close();
            } catch (IOException e) {
                System.err.println("Error: " + e.getMessage());
            }
        } finally {
            sc.close();
        }
    }
}
