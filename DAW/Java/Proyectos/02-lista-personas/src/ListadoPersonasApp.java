import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListadoPersonasApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Persona> personas = new ArrayList<>();
        boolean continuar = false;

        // Menu
        while (!continuar) {
            mostrarMenu();
            try {
                continuar = ejecutarOperacion(sc, personas);
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
            System.out.println();
        }
    }

    private static void mostrarMenu() {
        System.out.print("""
                1. Listar personas
                2. Agregar persona
                3. Salir
                """);
        System.out.print("Introduce una opción: ");
    }

    private static boolean ejecutarOperacion(Scanner sc, List<Persona> personas) {
        var opcion = Integer.parseInt(sc.nextLine());
        var continuar = false;
        switch (opcion) {
            case 1 -> {
                System.out.println("Lista de Personas (" + personas.size() + ")");
                //personas.forEach(persona -> System.out.println(persona));
                personas.forEach(System.out::println);
            }
            case 2 -> {
                System.out.print("Introduce el nombre: ");
                var nombre = sc.nextLine();
                System.out.print("Introduce el teléfono: ");
                var tel = sc.nextLine();
                System.out.print("Introduce el email: ");
                var email = sc.nextLine();

                Persona persona = new Persona(nombre, tel, email);
                personas.add(persona);
            }
            case 3 -> {
                System.out.println("Fin");
                continuar = true;
            }
            default -> System.out.println("Opción no valida: " + opcion);
        }
        return continuar;
    }
}
