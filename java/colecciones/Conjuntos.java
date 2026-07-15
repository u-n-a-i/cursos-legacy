package colecciones;

import java.util.HashSet;
import java.util.Set;

public class Conjuntos {
    public static void main(String[] args) {
        /*
        ¡Excelente! Después de las listas, los conjuntos (Set) son otra colección fundamental en Java.
        A diferencia de las listas, los conjuntos se centran en almacenar elementos únicos y no mantienen un orden específico
        (aunque algunas implementaciones sí lo hacen).
        ¿Qué es un Conjunto en Java?
        Un Set en Java es una interfaz que representa una colección de elementos que no contiene duplicados.
        Esto significa que cada elemento en un Set debe ser único.
        La interfaz Set no garantiza ningún orden específico para los elementos
        (a menos que se utilice una implementación específica que sí lo haga).
         */

        /*
        HashSet: Esta es la implementación más utilizada.
        Utiliza una tabla hash para almacenar los elementos.
        Ofrece un rendimiento excelente para las operaciones básicas (add, remove, contains) en promedio,
        pero no garantiza ningún orden en los elementos.
         */

        Set<String> frutas = new HashSet<>();

        // Añadir elementos al conjunto
        frutas.add("Manzana");
        frutas.add("Banana");
        frutas.add("Naranja");
        frutas.add("Uva");
        frutas.add("Manzana"); // Intento de añadir un duplicado (no se añade)

        System.out.println("Conjunto HashSet: " + frutas); // El orden puede variar

        // Comprobar si el conjunto contiene un elemento
        boolean contieneBanana = frutas.contains("Banana");
        System.out.println("¿El conjunto contiene Banana? " + contieneBanana); // Salida: true

        // Obtener el tamaño del conjunto
        System.out.println("El tamaño del conjunto es: " + frutas.size()); // Salida: 4

        // Intentar añadir un duplicado
        boolean seAnadio = frutas.add("Naranja");
        System.out.println("¿Se añadió 'Naranja' de nuevo? " + seAnadio); // Salida: false
        System.out.println("Conjunto después de intentar añadir duplicado: " + frutas);

        // Eliminar un elemento del conjunto
        frutas.remove("Uva");
        System.out.println("Conjunto después de eliminar Uva: " + frutas);

        // Iterar sobre el conjunto (el orden no está garantizado)
        System.out.println("Frutas en el conjunto:");
        for (String fruta : frutas) {
            System.out.println(fruta);
        }

        // Limpiar el conjunto
        // frutas.clear();
        // System.out.println("Conjunto después de limpiar: " + frutas);
        // System.out.println("¿El conjunto está vacío? " + frutas.isEmpty()); // Salida: true

        /*
        Las operaciones fundamentales como añadir elementos,
        eliminar elementos, verificar si un elemento existe, obtener el tamaño del conjunto,
        e iterar sobre los elementos se realizan utilizando los mismos métodos de la interfaz Set.
         */

        /*
        LinkedHashSet: Esta implementación extiende HashSet y mantiene un orden de inserción de los elementos.
        Es decir, los elementos se iteran en el orden en que fueron añadidos al conjunto.
        También utiliza una tabla hash internamente para la eficiencia.
         */

        /*
        TreeSet: Esta implementación utiliza un árbol de búsqueda
        binario auto-balanceable (específicamente un TreeMap internamente) para almacenar los elementos.
        Los elementos en un TreeSet se almacenan en un orden ascendente (según su orden natural o un Comparator proporcionado).
         */
    }
}
