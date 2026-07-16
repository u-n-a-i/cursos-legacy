package ejercicio2;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class ClienteCuadrado {

    public static void main(String[] args) {
        final int PUERTO_SERVIDOR = 5000;

        try (DatagramSocket socket = new DatagramSocket();
                Scanner scanner = new Scanner(System.in)) {

            System.out.print("Introduce la IP del servidor: ");
            String ipServidor = scanner.nextLine();

            System.out.print("Introduce un número: ");
            int numero = scanner.nextInt();

            // Enviar número al servidor
            byte[] bufferSalida = String.valueOf(numero).getBytes();
            InetAddress direccionServidor = InetAddress.getByName(ipServidor);

            DatagramPacket paqueteSalida = new DatagramPacket(bufferSalida, bufferSalida.length,
                    direccionServidor, PUERTO_SERVIDOR);

            socket.send(paqueteSalida);

            // Recibir respuesta del servidor
            byte[] bufferEntrada = new byte[1024];
            DatagramPacket paqueteEntrada = new DatagramPacket(bufferEntrada, bufferEntrada.length);

            socket.receive(paqueteEntrada);

            String respuesta = new String(paqueteEntrada.getData(), 0, paqueteEntrada.getLength());
            System.out.println("Respuesta del servidor: " + respuesta);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
