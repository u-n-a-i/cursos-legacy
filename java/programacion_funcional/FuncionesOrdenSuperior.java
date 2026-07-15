package programacion_funcional;

import java.util.function.BiFunction;
import java.util.function.Function;

public class FuncionesOrdenSuperior {
    /*
    Las funciones de orden superior:
    Acepta una o más funciones como argumentos.
    Devuelve una función como resultado.
     */

    // Función de orden superior que toma una función y dos enteros, y aplica la función
    public static int aplicarOperacion(int a, int b, BiFunction<Integer, Integer, Integer> operacion) {
        return operacion.apply(a, b);
    }

    // Función que devuelve otra función (una Function)
    public static Function<Integer, Integer> crearMultiplicador(int factor) {
        return numero -> numero * factor;
    }

    public static void main(String[] args) {
        // Usando aplicarOperacion con una lambda
        int suma = aplicarOperacion(5, 3, (x, y) -> x + y);
        System.out.println("Suma: " + suma); // Salida: 8

        int producto = aplicarOperacion(5, 3, (x, y) -> x * y);
        System.out.println("Producto: " + producto); // Salida: 15

        // Usando crearMultiplicador para obtener una función
        Function<Integer, Integer> multiplicarPorCinco = crearMultiplicador(5);
        int resultado = multiplicarPorCinco.apply(10);
        System.out.println("10 multiplicado por 5: " + resultado); // Salida: 50
    }
}
