package ejercicio3;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ServidorHora {

    public static void main(String[] args) {
        final int PUERTO = 6000;

        try (DatagramSocket socket = new DatagramSocket(PUERTO)) {
            System.out.println("Servidor de hora en funcionamiento...");

            while (true) {
                // Recibir petición del cliente
                byte[] bufferEntrada = new byte[1024];
                DatagramPacket paqueteEntrada = new DatagramPacket(bufferEntrada, bufferEntrada.length);

                socket.receive(paqueteEntrada);

                // Obtener fecha y hora actual
                LocalDateTime ahora = LocalDateTime.now();
                DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

                String respuesta = "Fecha y hora: " + ahora.format(formato);

                // Enviar respuesta al cliente
                byte[] bufferSalida = respuesta.getBytes();
                InetAddress direccionCliente = paqueteEntrada.getAddress();
                int puertoCliente = paqueteEntrada.getPort();

                DatagramPacket paqueteSalida = new DatagramPacket(bufferSalida, bufferSalida.length,
                        direccionCliente, puertoCliente);

                socket.send(paqueteSalida);
                System.out.println("Respuesta enviada al cliente.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
