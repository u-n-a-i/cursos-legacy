package ampliando_conceptos.interfaces_funcionales;

import java.util.function.Consumer;
import java.util.Arrays;
import java.util.List;

public class EjemploConsumer {
    /*
    Representa una operación que acepta un argumento de tipo T
    y no devuelve ningún resultado. Se utiliza típicamente para realizar alguna acción sobre un elemento.
     */

    public static void main(String[] args) {
        List<String> nombres = Arrays.asList("Ana", "Juan", "María");

        Consumer<String> imprimirNombre = nombre -> System.out.println("Hola, " + nombre + "!");
        Consumer<String> imprimirLongitud = nombre -> System.out.println(nombre + " tiene " + nombre.length() + " letras.");

        nombres.forEach(imprimirNombre);
        // Salida:
        // Hola, Ana!
        // Hola, Juan!
        // Hola, María!

        nombres.forEach(imprimirNombre.andThen(imprimirLongitud)); // Combinando Consumers
        // Salida:
        // Hola, Ana!
        // Ana tiene 3 letras.
        // Hola, Juan!
        // Juan tiene 4 letras.
        // Hola, María!
        // María tiene 5 letras.
    }
}
