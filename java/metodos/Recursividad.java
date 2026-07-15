package metodos;

public class Recursividad {
    public static void main(String[] args) {
        /* Recursividad
        Un método es recursivo cuando se llama a sí mismo para resolver un problema.
        La clave de la recursividad es tener una condición de parada, para evitar que se llame infinitamente.
         */

        // Ejemplo cuenta atrás del 5 - 1
        cuentaAtras(5);
    }

    public static void cuentaAtras(int numero) {
        if (numero == 0) {
            System.out.println("Termina");
            return;
        }
        System.out.println(numero);
        cuentaAtras(numero - 1); // no poner numero --; -> ese valor reducido no se pasa a la llamada actual(StackOverflowError).
    }
}
