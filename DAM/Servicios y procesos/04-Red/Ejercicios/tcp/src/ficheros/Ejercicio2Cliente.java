package ficheros;

import java.io.*;
import java.net.*;
import java.nio.file.Files;
import java.util.Scanner;

public class Ejercicio2Cliente {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ruta del archivo a enviar: ");
        String ruta = sc.nextLine().trim();

        File archivo = new File(ruta);
        if (!archivo.exists()) {
            System.err.println("Archivo no encontrado.");
            return;
        }

        System.out.print("IP del servidor (ej. 127.0.0.1): ");
        String ip = sc.nextLine();
        System.out.print("Puerto (ej. 4444): ");
        int puerto = Integer.parseInt(sc.nextLine());

        try (Socket socket = new Socket(ip, puerto);
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
                FileInputStream fis = new FileInputStream(archivo)) {

            long tamano = archivo.length();
            dos.writeLong(tamano); // envía tamaño primero

            byte[] buffer = new byte[8192];
            int leidos;
            while ((leidos = fis.read(buffer)) != -1) {
                dos.write(buffer, 0, leidos);
            }
            dos.flush();

            System.out.println("Archivo '" + archivo.getName() + "' enviado (" + tamano + " bytes).");

        } catch (IOException e) {
            System.err.println("Error al enviar archivo: " + e.getMessage());
        }
    }
}

/*
 * /home/dam/Documentos/DAM/Servicios y
 * procesos/04-Red/Ejercicios/tcp/src/ficheros/Ejercicio2Cliente.java
 */