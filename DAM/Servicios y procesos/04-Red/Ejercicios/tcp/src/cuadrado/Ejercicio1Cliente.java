package cuadrado;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Ejercicio1Cliente {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Introduce la IP del servidor (ej. 127.0.0.1): ");
            String ip = sc.nextLine();

            System.out.print("Introduce el puerto (ej. 4444): ");
            int puerto = Integer.parseInt(sc.nextLine());

            System.out.print("Introduce un número para calcular su cuadrado: ");
            String numero = sc.nextLine();

            // Validación de número
            try {
                Integer.parseInt(numero);
            } catch (NumberFormatException e) {
                System.err.println("Debes introducir un número válido.");
                return;
            }

            try (Socket socket = new Socket(ip, puerto);
                    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                    BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

                out.println(numero); // enviar número
                String respuesta = in.readLine(); // recibir cuadrado
                System.out.println("Resultado del servidor: " + respuesta);

            } catch (IOException e) {
                System.err.println("Error de conexión: " + e.getMessage());
            }
        } finally {
            sc.close();
        }
    }
}
