package metodos;

public class PilaDeLLamadas {
    public static void main(String[] args) {
        /*
        La pila de llamadas es una estructura de datos interna que Java (y otros lenguajes)
         usa para llevar el control de los métodos que se están ejecutando.
        Cada vez que se llama a un método, se apila (push) un nuevo "marco de llamada" (stack frame) en la pila.
        Cuando el método termina, ese marco se desapila (pop).
         */
        metodoA();
    }

    public static void metodoA() {
        System.out.println("En A");
        metodoB();
    }

    public static void metodoB() {
        System.out.println("En B");
        metodoC();
    }

    public static void metodoC() {
        System.out.println("En C");
    }

    /*
    Pila durante la ejecución:
    main() se llama → entra en la pila
    main() llama a metodoA() → se apila
    metodoA() llama a metodoB() → se apila
    metodoB() llama a metodoC() → se apila
    metodoC() termina → se desapila
    metodoB() termina → se desapila
    metodoA() termina → se desapila
    main() termina → se desapila
     */

    // Si un método se llama a sí mismo muchas veces sin condición de parada, la pila se llena y se lanza:
    // Exception in thread "main" java.lang.StackOverflowError
}
