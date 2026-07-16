package zona_fit.presentacion;

import zona_fit.datos.ClienteDAO;
import zona_fit.datos.IClienteDAO;
import zona_fit.dominio.Cliente;

import java.util.Scanner;

public class ZonaFitApp {
    public static void main(String[] args) {
        zonaFitApp();
    }

    private static void zonaFitApp() {
        Scanner sc = new Scanner(System.in);
        IClienteDAO clienteDAO = new ClienteDAO();
        boolean salir = false;

        while (!salir) {
            try {
                var opcion = mostrarMenu(sc);
                salir = ejecutarOpciones(sc, opcion, clienteDAO);
            } catch (Exception e) {
                System.out.println("Error al ejecutar opciones " + e.getMessage());
            }
            System.out.println(); // salto de linea visual
        }

    }

    private static int mostrarMenu(Scanner sc) {
        System.out.println("""
                *** Zona Fit (GYM) ***
                1. Listar Clientes
                2. Buscar Clientes
                3. Agregar Clientes
                4. Modificar Clientes
                5. Eliminar Clientes
                6. Salir
                Elije una opción:\s""");

        return Integer.parseInt(sc.nextLine());
    }

    private static boolean ejecutarOpciones(Scanner sc, int opcion, IClienteDAO clienteDAO) {
        var salir = false;

        switch (opcion) {
            case 1 -> { // Listar Clientes
                System.out.println("--- Lista de Clientes ---");
                var clientes = clienteDAO.listarClientes();
                clientes.forEach(System.out::println);
            }
            case 2 -> { // Buscar Cliente por Id
                System.out.println("--- Introduce el Id del cliente para buscar: ---");
                var idCliente = Integer.parseInt(sc.nextLine());
                var cliente = new Cliente(idCliente);
                var encontrado = clienteDAO.buscarClientePorId(cliente);

                if (encontrado) {
                    System.out.println("Cliente encontrado: " + cliente);
                } else {
                    System.out.println("Cliente NO encontrado: " + cliente);
                }
            }
            case 3 -> { // Agregar Cliente
                System.out.println("--- Agregar Cliente ---");
                System.out.print("Nombre: ");
                String nombre = sc.nextLine();
                System.out.print("Apellido: ");
                String apellido = sc.nextLine();
                System.out.print("Membresia: ");
                int membresia = Integer.parseInt(sc.nextLine());

                // Crear OBJ
                var cliente = new Cliente(nombre, apellido, membresia);
                var agregado = clienteDAO.agregarCliente(cliente);

                if (agregado) {
                    System.out.println("Cliente encontrado: " + cliente);
                } else {
                    System.out.println("Cliente NO encontrado: " + cliente);
                }
            }
            case 4 -> { // Modificar Cliente
                System.out.println("--- Modificar Cliente ---");
                System.out.print("Id Cliente: ");
                var idCliente = Integer.parseInt(sc.nextLine());
                System.out.print("Nombre: ");
                String nombre = sc.nextLine();
                System.out.print("Apellido: ");
                String apellido = sc.nextLine();
                System.out.print("Membresia: ");
                int membresia = Integer.parseInt(sc.nextLine());

                // Crear OBJ
                var cliente = new Cliente(idCliente, nombre, apellido, membresia);
                var modificado = clienteDAO.modificarCliente(cliente);

                if (modificado) {
                    System.out.println("Cliente modificado: " + cliente);
                } else {
                    System.out.println("Cliente NO actualizado: " + cliente);
                }
            }
            case 5 -> { // Eliminar Cliente
                System.out.println("--- Eliminar Cliente ---");
                System.out.print("Id Cliente: ");
                var idCliente = Integer.parseInt(sc.nextLine());

                // Crear OBJ
                var cliente = new Cliente(idCliente);
                var eliminado = clienteDAO.eliminarCliente(cliente);

                if (eliminado) {
                    System.out.println("Cliente eliminado: " + cliente);
                } else {
                    System.out.println("Cliente NO eliminado: " + cliente);
                }
            }
            case 6 -> { // Salir
                salir = true;
            }
            default -> {
                System.out.println(opcion + " No es una opción valida");
            }
        }
        return salir;
    }
}
