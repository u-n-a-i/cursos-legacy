package ejercicio2;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ServidorCuadrado {

    public static void main(String[] args) {
        final int PUERTO = 5000;

        try (DatagramSocket socket = new DatagramSocket(PUERTO)) {
            System.out.println("Servidor UDP esperando datos...");

            // Buffer para recibir datos
            byte[] bufferEntrada = new byte[1024];
            DatagramPacket paqueteEntrada = new DatagramPacket(bufferEntrada, bufferEntrada.length);

            // Recibir paquete del cliente
            socket.receive(paqueteEntrada);

            // Obtener datos
            String mensaje = new String(paqueteEntrada.getData(), 0, paqueteEntrada.getLength());
            int numero = Integer.parseInt(mensaje);

            // Calcular el cuadrado
            int cuadrado = numero * numero;
            System.out.println("Número recibido: " + numero);
            System.out.println("Cuadrado calculado: " + cuadrado);

            // Preparar respuesta
            String respuesta = "El cuadrado de " + numero + " es " + cuadrado;
            byte[] bufferSalida = respuesta.getBytes();

            InetAddress direccionCliente = paqueteEntrada.getAddress();
            int puertoCliente = paqueteEntrada.getPort();

            DatagramPacket paqueteSalida = new DatagramPacket(bufferSalida, bufferSalida.length,
                    direccionCliente, puertoCliente);

            // Enviar respuesta al cliente
            socket.send(paqueteSalida);
            System.out.println("Resultado enviado al cliente.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
