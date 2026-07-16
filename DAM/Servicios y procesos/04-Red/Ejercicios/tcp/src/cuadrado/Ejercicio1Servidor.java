package cuadrado;

import java.io.*;
import java.net.*;

public class Ejercicio1Servidor {
    public static void main(String[] args) {
        final int PUERTO = 4444;

        try (ServerSocket serverSocket = new ServerSocket(PUERTO)) {
            System.out.println("Servidor esperando conexiones en puerto " + PUERTO + "...");

            while (true) {
                Socket clienteSocket = serverSocket.accept();
                System.out.println("Cliente conectado: " + clienteSocket.getInetAddress());

                new Thread(() -> {
                    try (
                            BufferedReader in = new BufferedReader(
                                    new InputStreamReader(clienteSocket.getInputStream()));
                            PrintWriter out = new PrintWriter(clienteSocket.getOutputStream(), true)) {
                        String inputLine = in.readLine();
                        if (inputLine != null) {
                            try {
                                double num = Double.parseDouble(inputLine);
                                double cuadrado = num * num;
                                System.out.println("Recibido: " + num + " => Cuadrado: " + cuadrado);
                                out.println(cuadrado);
                            } catch (NumberFormatException e) {
                                out.println("ERROR: Entrada no válida");
                            }
                        }
                    } catch (IOException e) {
                        System.err.println("Error con cliente: " + e.getMessage());
                    } finally {
                        try {
                            clienteSocket.close();
                        } catch (IOException ignored) {
                        }
                    }
                }).start();
            }

        } catch (IOException e) {
            System.err.println("Error del servidor: " + e.getMessage());
        }
    }
}
