package ampliando_conceptos.interfaces_funcionales;

import java.util.function.Supplier;
import java.util.Random;

public class EjemploSupplier {
    /*
    Representa una función que no acepta ningún argumento y devuelve un resultado de tipo T.
    Se utiliza típicamente para generar o proporcionar valores.
     */

    public static void main(String[] args) {
        Supplier<Integer> generarNumeroAleatorio = () -> new Random().nextInt(100);

        System.out.println("Número aleatorio: " + generarNumeroAleatorio.get());
        System.out.println("Otro número aleatorio: " + generarNumeroAleatorio.get());

        Supplier<String> obtenerSaludo = () -> "¡Saludos desde el Supplier!";
        System.out.println(obtenerSaludo.get()); // Salida: ¡Saludos desde el Supplier!
    }
}
