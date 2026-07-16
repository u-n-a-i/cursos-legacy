package presentacion;

import dominio.Pelicula;
import servicio.IServicioPeliculas;
import servicio.ServicioPeliculasArchivo;
import servicio.ServicioPeliculasLista;

import java.util.Scanner;

public class CatalogoPeliculas {
    public static void main(String[] args) {
        /*Pelicula p1 = new Pelicula("Batman");
        Pelicula p2 = new Pelicula("Superman");
        IServicioPeliculas servicioPeliculas = new ServicioPeliculasLista();
        servicioPeliculas.agregarPelicula(p1);
        servicioPeliculas.agregarPelicula(p2);
        servicioPeliculas.listarPeliculas();
        servicioPeliculas.buscarPelicula(new Pelicula("Wonder Woman"));
        servicioPeliculas.buscarPelicula(p2);*/

        // Menu
        Scanner sc = new Scanner(System.in);
        boolean salir = false;
        //IServicioPeliculas servicioPeliculas = new ServicioPeliculasLista();
        IServicioPeliculas servicioPeliculas = new ServicioPeliculasArchivo();

        while (!salir) {
            try {
                mostrarMenu();
                salir = ejecutarOpciones(sc, servicioPeliculas);
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private static void mostrarMenu() {
        System.out.println("""
                **** Catalogo Películas ****
                1. Agregar película
                2. Listar películas
                3. Buscar película
                4. Salir
                """);
    }

    private static boolean ejecutarOpciones(Scanner sc, IServicioPeliculas servicioPeliculas) {
        int opcion = Integer.parseInt(sc.nextLine());
        boolean salir = false;

        switch (opcion) {
            case 1 -> {
                System.out.println("Nombre de la película: ");
                String nombre = sc.nextLine();
                servicioPeliculas.agregarPelicula(new Pelicula(nombre));
                System.out.println(nombre + " agregada.");
            }
            case 2 -> servicioPeliculas.listarPeliculas();

            case 3 -> {
                System.out.println("Introduce el nombre de la película: ");
                String buscar = sc.nextLine();
                servicioPeliculas.buscarPelicula(new Pelicula(buscar));
            }
            case 4 -> {
                System.out.println("Fin");
                salir = true;
            }

            default -> System.out.println("Opción no valida" + opcion);
        }

        return salir;
    }
}
