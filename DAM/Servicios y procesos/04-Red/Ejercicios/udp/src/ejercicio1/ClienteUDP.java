package ejercicio1;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class ClienteUDP {
    public static void main(String[] args) {
        final int PUERTO = 5000; // Puerto del servidor
        Scanner sc = new Scanner(System.in);

        try (DatagramSocket socket = new DatagramSocket()) {
            System.out.print("Introduce la dirección IP del servidor: ");
            String ipServidor = sc.nextLine();

            InetAddress direccionServidor = InetAddress.getByName(ipServidor);

            // Enviar mensaje al servidor
            String mensaje = "Hola mundo desde el cliente";
            byte[] datos = mensaje.getBytes();

            DatagramPacket paquete = new DatagramPacket(
                    datos, datos.length, direccionServidor, PUERTO);

            socket.send(paquete);
            System.out.println("Mensaje enviado al servidor");

            // Esperar respuesta
            byte[] buffer = new byte[1024];
            DatagramPacket respuesta = new DatagramPacket(buffer, buffer.length);
            socket.receive(respuesta);

            String mensajeServidor = new String(respuesta.getData(), 0, respuesta.getLength());
            System.out.println("Respuesta del servidor: " + mensajeServidor);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sc.close();
        }
    }
}
