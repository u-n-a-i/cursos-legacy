package gm.zona_fit;

import gm.zona_fit.modelo.Cliente;
import gm.zona_fit.servicio.IClienteServicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class ZonaFitApplication implements CommandLineRunner {
    @Autowired
    private IClienteServicio clienteServicio;
    private static final Logger logger = LoggerFactory.getLogger(ZonaFitApplication.class);
    String newLine = System.lineSeparator();

    public static void main(String[] args) {
        logger.info("Iniciando la aplicación");

        // Levantar la fabrica de Spring
        SpringApplication.run(ZonaFitApplication.class, args);
        logger.info("Aplicación finalizada");
    }

    // Método de la interface
    @Override
    public void run(String... args) throws Exception {
        boolean salir = false;
        Scanner sc = new Scanner(System.in);

        while (!salir) {
            var opcion = mostrarMenu(sc);
            salir = ejecutarOpciones(sc, opcion);
            logger.info(newLine);
        }
    }

    private int mostrarMenu(Scanner sc) {
        logger.info(""" 
                \n*** Aplicación Zona Fit (Gym) ***
                1. Listar Cliente
                2. Buscar Cliente
                3. Agregar Cliente
                4. Modificar Cliente
                5. Eliminar Cliente
                6. Salir
                Elige una opción:""");
        return Integer.parseInt(sc.nextLine());
    }

    private boolean ejecutarOpciones(Scanner sc, int opcion) {
        boolean salir = false;

        switch (opcion) {
            case 1 -> {
                logger.info(newLine + "--- Lista de Clientes ---" + newLine);
                List<Cliente> clientes = clienteServicio.listarClientes();
                clientes.forEach(cliente -> logger.info(cliente.toString() + newLine));
            }
            case 2 -> {
                logger.info(newLine + "--- Buscar por ID ---" + newLine);
                logger.info(newLine + "Introduce el id:" + newLine);
                var idCliente = Integer.parseInt(sc.nextLine());
                Cliente cliente = clienteServicio.buscarClientePorId(idCliente);

                if (cliente != null) {
                    logger.info("Cliente encontrado: " + cliente + newLine);
                } else {
                    logger.info("Cliente NO encontrado: " + cliente + newLine);
                }
            }
            case 3 -> {
                logger.info(newLine + "--- Agregar Cliente ---" + newLine);
                logger.info("Nombre:");
                var nombre = sc.nextLine();
                logger.info("Apellido:");
                var apellido = sc.nextLine();
                logger.info("Membresia:");
                var membresia = Integer.parseInt(sc.nextLine());

                Cliente cliente = new Cliente();
                cliente.setNombre(nombre);
                cliente.setApellido(apellido);
                cliente.setMembresia(membresia);

                clienteServicio.guardarCliente(cliente);
                if (cliente != null) {
                    logger.info("Cliente agregado: " + cliente + newLine);
                } else {
                    logger.info("Cliente NO agregado: " + cliente + newLine);
                }
            }
            case 4 -> {
                logger.info(newLine + "--- Modificar cliente por ID ---" + newLine);
                logger.info(newLine + "Introduce el id:" + newLine);
                var idCliente = Integer.parseInt(sc.nextLine());
                Cliente cliente = clienteServicio.buscarClientePorId(idCliente);

                if (cliente != null) {
                    logger.info("Nombre:");
                    var nombre = sc.nextLine();
                    logger.info("Apellido:");
                    var apellido = sc.nextLine();
                    logger.info("Membresia:");
                    var membresia = Integer.parseInt(sc.nextLine());

                    cliente.setNombre(nombre);
                    cliente.setApellido(apellido);
                    cliente.setMembresia(membresia);

                    clienteServicio.guardarCliente(cliente);
                    if (cliente != null) {
                        logger.info("Cliente modificado: " + cliente + newLine);
                    } else {
                        logger.info("Cliente NO modificado: " + cliente + newLine);
                    }
                }
            }
            case 5 -> {
                logger.info(newLine + "--- Eliminar cliente por ID ---" + newLine);
                logger.info(newLine + "Introduce el id:" + newLine);
                var idCliente = Integer.parseInt(sc.nextLine());
                Cliente cliente = clienteServicio.buscarClientePorId(idCliente);

                if (cliente != null) {
                    clienteServicio.eliminarCliente(cliente);
                    logger.info("Cliente eliminado: " + cliente + newLine);
                } else {
                    logger.info("Cliente NO eliminado: " + cliente + newLine);
                }
            }
            case 6 -> {
                logger.info("Hasta Pronto!" + newLine);
                salir = true;
            }
            default -> {
                logger.info("Opción no valida");
            }
        }
        return salir;
    }
}
