package servicio;

import dominio.Pelicula;

import java.io.*;

public class ServicioPeliculasArchivo implements IServicioPeliculas {
    private final String NOMBRE_ARCHIVO = "peliculas.txt";

    public ServicioPeliculasArchivo() {
        File archivo = new File(NOMBRE_ARCHIVO);

        try {
            if (archivo.exists()) {
                System.out.println("El archivo ya existe");
            } else {
                PrintWriter salida = new PrintWriter(new FileWriter(archivo));
                salida.close();
                System.out.println("Archivo creado.");
            }
        } catch (Exception e) {
            System.out.println("Error al abrir el archivo: " + e.getMessage());
        }
    }

    @Override
    public void listarPeliculas() {
        File archivo = new File(NOMBRE_ARCHIVO);

        try {
            System.out.println("Lista de Películas");
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            String linea;
            linea = entrada.readLine();

            // Leer línea por línea
            while (linea != null) {
                Pelicula pelicula = new Pelicula();
                System.out.println(pelicula);
                linea = entrada.readLine();
            }
            entrada.close();
        } catch (Exception e) {
            System.out.println("Error al leer el archivo " + e.getMessage());
        }
    }

    @Override
    public void agregarPelicula(Pelicula pelicula) {
        boolean anexar = false;
        File archivo = new File(NOMBRE_ARCHIVO);
        try {
            // Revisar si exite
            anexar = archivo.exists();
            PrintWriter salida = new PrintWriter(new FileWriter(archivo, anexar));

            // Agregar película (toString)
            salida.println(pelicula);
            salida.close();
        } catch (Exception e) {
            System.out.println("Error al agregar la película en el archivo " + e.getMessage());
        }
    }

    @Override
    public void buscarPelicula(Pelicula pelicula) {
        File archivo = new File(NOMBRE_ARCHIVO);

        try {
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            String lineaTexto;

            lineaTexto = entrada.readLine();
            int indice = 1;
            String peliculaBuscar = pelicula.getNombre();
            boolean encontrada = false;

            // Buscar sin importar mayúsculas y minúsculas
            while (lineaTexto != null) {
                if (peliculaBuscar != null && peliculaBuscar.equalsIgnoreCase(lineaTexto)) {
                    encontrada = true;
                    break;
                }
                lineaTexto = entrada.readLine();
                indice++;
            }

            // Imprimir resultados
            if (encontrada) {
                System.out.println("Película: " + lineaTexto + " encontrada.");
            } else {
                System.out.println("Película no encontrada.");
                entrada.close();
            }
        } catch (Exception e) {
            System.out.println("Error al buscar la película en el archivo " + e.getMessage());
        }
    }
}
