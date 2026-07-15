package colecciones;

import java.util.ArrayList;
import java.util.List;

public class Listas {
    public static void main(String[] args) {
        // Una List en Java es una interfaz que representa una colección ordenada de elementos.

        // ArrayList: array dinámico para almacenar los elementos
        List<String> nombres = new ArrayList<>();

        // Añadir elementos a la lista
        nombres.add("Ana");
        nombres.add("Juan");
        nombres.add("María");
        nombres.add("Pedro");
        nombres.add("Ana"); // Se permiten duplicados

        // Acceder a un elemento por su índice
        System.out.println("El primer nombre es: " + nombres.get(0)); // Salida: Ana
        System.out.println("El tercer nombre es: " + nombres.get(2)); // Salida: María

        // Obtener el tamaño de la lista
        System.out.println("El tamaño de la lista es: " + nombres.size()); // Salida: 5

        // Iterar sobre la lista (usando un bucle for tradicional)
        System.out.println("Nombres en la lista:");
        for (int i = 0; i < nombres.size(); i++) {
            System.out.println(nombres.get(i));
        }

        // Iterar sobre la lista (usando un bucle for-each)
        System.out.println("\nNombres en la lista (for-each):");
        for (String nombre : nombres) {
            System.out.println(nombre);
        }

        // Insertar un elemento en una posición específica
        nombres.add(1, "Sofía"); // Inserta "Sofía" en el índice 1
        System.out.println("\nLista después de la inserción: " + nombres);

        // Eliminar un elemento por su índice
        nombres.remove(3); // Elimina el elemento en el índice 3
        System.out.println("Lista después de la eliminación por índice: " + nombres);

        // Eliminar la primera ocurrencia de un elemento
        nombres.remove("Ana");
        System.out.println("Lista después de eliminar la primera 'Ana': " + nombres);

        // Comprobar si la lista contiene un elemento
        boolean contieneJuan = nombres.contains("Juan");
        System.out.println("¿La lista contiene a Juan? " + contieneJuan); // Salida: true

        // Obtener el índice de un elemento
        int indiceMaria = nombres.indexOf("María");
        System.out.println("El índice de María es: " + indiceMaria); // Salida: 2

        // Limpiar la lista (eliminar todos los elementos)
        // nombres.clear();
        // System.out.println("Lista después de limpiar: " + nombres);
        // System.out.println("¿La lista está vacía? " + nombres.isEmpty()); // Salida: true

        /* LinkedList
        Utiliza una estructura de datos de lista doblemente enlazada.
        Cada elemento (nodo) contiene el dato y referencias al nodo anterior y al siguiente.
        Esto hace que las inserciones y eliminaciones en cualquier posición sean eficientes,
        pero el acceso a un elemento por su índice puede ser más lento, ya que necesita recorrer la lista
        desde el principio o el final.
         */
        List<String> alumnos = new ArrayList<>();

        // Añadir elementos a la lista
        alumnos.add("Ana");
        alumnos.add("Juan");
        alumnos.add("María");
        alumnos.add("Pedro");
        alumnos.add("Ana"); // Se permiten duplicados

        // Acceder a un elemento por su índice
        System.out.println("El primer nombre es: " + alumnos.get(0)); // Salida: Ana
        System.out.println("El tercer nombre es: " + alumnos.get(2)); // Salida: María

        // Obtener el tamaño de la lista
        System.out.println("El tamaño de la lista es: " + alumnos.size()); // Salida: 5

        // Iterar sobre la lista (usando un bucle for tradicional)
        System.out.println("Nombres en la lista:");
        for (int i = 0; i < alumnos.size(); i++) {
            System.out.println(alumnos.get(i));
        }

        // Iterar sobre la lista (usando un bucle for-each)
        System.out.println("\nNombres en la lista (for-each):");
        for (String nombre : alumnos) {
            System.out.println(nombre);
        }

        // Insertar un elemento en una posición específica
        alumnos.add(1, "Sofía"); // Inserta "Sofía" en el índice 1
        System.out.println("\nLista después de la inserción: " + alumnos);

        // Eliminar un elemento por su índice
        alumnos.remove(3); // Elimina el elemento en el índice 3
        System.out.println("Lista después de la eliminación por índice: " + alumnos);

        // Eliminar la primera ocurrencia de un elemento
        alumnos.remove("Ana");
        System.out.println("Lista después de eliminar la primera 'Ana': " + alumnos);

        // Comprobar si la lista contiene un elemento
        boolean contieneJuan2 = alumnos.contains("Juan");
        System.out.println("¿La lista contiene a Juan? " + contieneJuan2); // Salida: true

        // Obtener el índice de un elemento
        int indiceMaria2 = alumnos.indexOf("María");
        System.out.println("El índice de María es: " + indiceMaria2); // Salida: 2

        // Limpiar la lista (eliminar todos los elementos)
        // nombres.clear();
        // System.out.println("Lista después de limpiar: " + nombres);
        // System.out.println("¿La lista está vacía? " + nombres.isEmpty()); // Salida: true
    }
}
