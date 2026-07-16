package ficheros;

import java.io.*;
import java.net.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Ejercicio2Servidor {
    private static final int PUERTO = 4444;
    private static final AtomicInteger contador = new AtomicInteger(0);

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PUERTO)) {
            System.out.println("Servidor de archivos iniciado en puerto " + PUERTO);

            while (true) {
                Socket cliente = serverSocket.accept();
                System.out.println("Cliente conectado: " + cliente.getInetAddress());
                new Thread(new ManejadorCliente(cliente)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class ManejadorCliente implements Runnable {
        private final Socket socket;

        public ManejadorCliente(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            int id = contador.incrementAndGet();
            String nombreArchivo = "archivo_recibido_" + id + ".dat";

            try (
                    DataInputStream dis = new DataInputStream(socket.getInputStream());
                    FileOutputStream fos = new FileOutputStream(nombreArchivo)) {
                long tamano = dis.readLong(); // primero recibe el tamaño
                byte[] buffer = new byte[8192];
                long totalLeido = 0;

                while (totalLeido < tamano) {
                    int leidos = dis.read(buffer, 0, (int) Math.min(buffer.length, tamano - totalLeido));
                    if (leidos == -1)
                        break;
                    fos.write(buffer, 0, leidos);
                    totalLeido += leidos;
                }

                System.out
                        .println("Archivo recibido y guardado como: " + nombreArchivo + " (" + totalLeido + " bytes)");
            } catch (IOException e) {
                System.err.println("Error al recibir archivo: " + e.getMessage());
            } finally {
                try {
                    socket.close();
                } catch (IOException ignored) {
                }
            }
        }
    }
}
