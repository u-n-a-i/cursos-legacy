package ejercicio1;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ServidorUDP {
    public static void main(String[] args) {
        final int PUERTO = 5000; // Puerto donde escucha el servidor

        try (DatagramSocket socket = new DatagramSocket(PUERTO)) {
            System.out.println("Servidor UDP escuchando en el puerto " + PUERTO);

            // Buffer para recibir datos
            byte[] buffer = new byte[1024];

            // Esperar paquete del cliente
            DatagramPacket paqueteRecibido = new DatagramPacket(buffer, buffer.length);
            socket.receive(paqueteRecibido);

            String mensaje = new String(paqueteRecibido.getData(), 0, paqueteRecibido.getLength());
            System.out.println("Mensaje recibido: " + mensaje);

            // Responder al cliente
            String respuesta = "Hola mundo desde el servidor";
            byte[] datosRespuesta = respuesta.getBytes();

            InetAddress direccionCliente = paqueteRecibido.getAddress();
            int puertoCliente = paqueteRecibido.getPort();

            DatagramPacket paqueteRespuesta = new DatagramPacket(
                    datosRespuesta, datosRespuesta.length, direccionCliente, puertoCliente);

            socket.send(paqueteRespuesta);
            System.out.println("Respuesta enviada al cliente");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
