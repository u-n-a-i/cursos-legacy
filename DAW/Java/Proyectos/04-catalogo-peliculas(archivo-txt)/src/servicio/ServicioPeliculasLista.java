package servicio;

import dominio.Pelicula;

import java.util.ArrayList;
import java.util.List;

public class ServicioPeliculasLista implements IServicioPeliculas {
    private final List<Pelicula> peliculas;

    public ServicioPeliculasLista() {
        peliculas = new ArrayList<>();
    }

    @Override
    public void listarPeliculas() {
        System.out.println("**** Películas ****");
        peliculas.forEach(System.out::println);
    }

    @Override
    public void agregarPelicula(Pelicula pelicula) {
        peliculas.add(pelicula);
        System.out.println("Película " + pelicula.getNombre() + " agregada.");
    }

    @Override
    public void buscarPelicula(Pelicula pelicula) {
        int indice = peliculas.indexOf(pelicula);
        if (indice == -1){
            System.out.println("Película no encontrada");
        }else {
            System.out.println("Película encontrada en el indice: " + indice);
        }

    }
}
