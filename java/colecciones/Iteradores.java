package colecciones;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Iteradores {
    public static void main(String[] args) {
        /*
         Los iteradores son una herramienta fundamental en Java para recorrer los elementos de una colección
         (como Listas, Conjuntos, Mapas, etc.) de una manera uniforme y controlada.
         */

        List<String> nombres = new ArrayList<>();
        nombres.add("Ana");
        nombres.add("Juan");
        nombres.add("Maria");

        // Crear Iterador
        Iterator<String> iterador = nombres.iterator();

        // Iterar sobre los elementos
        while (iterador.hasNext()) {
            String nombre = iterador.next();
            System.out.println(nombre);
            if (nombre.equalsIgnoreCase("Juan")) {
                iterador.remove(); // Eliminar Juan
            }
        }
        System.out.println(nombres);
    }
}
