package control_de_flujo;

public class Excepciones {
    public static void main(String[] args) {
        /*
        Las excepciones son objetos que representan situaciones anómalas que ocurren durante la ejecución de un programa.
        Estas situaciones anómalas pueden ser errores de tiempo de ejecución
        (como divisiones por cero o acceso a un índice fuera del rango válido en un array) o condiciones excepcionales
        específicas del programa (como un archivo no encontrado o una conexión de red perdida).
         */

        // Try catch
        // System.out.println(10/0); Rompe el programa
        try {
            int resultado = 10 / 0;
            System.out.println(resultado);
        } catch (ArithmeticException e) {
            System.out.println("¡Error: no se puede dividir por cero!");
        }
        System.out.println("Sigue funcionando el resto.");

        // Throw palabra clave que se usa para lanzar una excepción manualmente.
        // Es útil cuando tú detectas una situación anormal
        // y decides interrumpir el flujo del programa lanzando una excepción.
        // Se usan con métodos, constructores, bloques estáticos.
        // No se usa en el cuerpo de la clase.
        verificarEdad(15);
        System.out.println("Esto no se ejecuta"); // Para no interrumpir el código usar try-catch.

    }

    public static void verificarEdad(int edad) {
        if (edad < 18) {
            throw new IllegalArgumentException("Debes ser mayor de edad.");
        }
        System.out.println("Acceso permitido.");
    }
}
