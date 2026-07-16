package ejercicio3;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketTimeoutException;
import java.util.Scanner;

public class ClienteHora {

    public static void main(String[] args) {
        final int PUERTO_SERVIDOR = 6000;
        final int TIMEOUT = 5000; // 5000 ms

        try (DatagramSocket socket = new DatagramSocket();
                Scanner scanner = new Scanner(System.in)) {

            System.out.print("Introduce la IP del servidor: ");
            String ipServidor = scanner.nextLine();

            // Mensaje de petición
            byte[] bufferSalida = "HORA".getBytes();
            InetAddress direccionServidor = InetAddress.getByName(ipServidor);

            DatagramPacket paqueteSalida = new DatagramPacket(bufferSalida, bufferSalida.length,
                    direccionServidor, PUERTO_SERVIDOR);

            socket.send(paqueteSalida);

            // Configurar tiempo de espera
            socket.setSoTimeout(TIMEOUT);

            // Esperar respuesta
            byte[] bufferEntrada = new byte[1024];
            DatagramPacket paqueteEntrada = new DatagramPacket(bufferEntrada, bufferEntrada.length);

            socket.receive(paqueteEntrada);

            String respuesta = new String(
                    paqueteEntrada.getData(), 0, paqueteEntrada.getLength());

            System.out.println(respuesta);

        } catch (SocketTimeoutException e) {
            System.out.println("Error: el servidor no respondió en 5000 ms.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
