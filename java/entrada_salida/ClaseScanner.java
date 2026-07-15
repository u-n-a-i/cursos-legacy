package entrada_salida;

import java.util.Locale;
import java.util.Scanner;

public class ClaseScanner {
    public static void main(String[] args) {
        /*
        La clase Scanner en Java se usa para leer datos de entrada (como texto o números)
        desde el teclado u otras fuentes (como archivos). Es parte del paquete java.util.
         */
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce tu nombre");
        String nombre = sc.nextLine();
        System.out.println("Hola " + nombre);

        /* ⚠️ Cuidado con nextLine() después de nextInt() o nextDouble()
        Cuando usas nextInt() y luego nextLine(), puede que el nextLine() lea un salto de línea pendiente.
        Para evitarlo, agrega un sc.nextLine();
        */
        System.out.print("Edad: ");
        int edad = sc.nextInt();
        sc.nextLine(); // limpia el salto de línea

        System.out.print("Nombre completo: ");
        String nombreCompleto = sc.nextLine();

        /* Alternativa
           Por defecto, Scanner usa como delimitador cualquier espacio en blanco,
           incluyendo espacios, tabs y saltos de línea (\n). Cuando usas nextInt() o nextDouble(),
           estos métodos no consumen el salto de línea que viene después del número, solo el número mismo.
         */

        sc.useDelimiter("\n"); // Saltos de línea
        sc.useLocale(new Locale("es", "ES")); // Usar , en lugar de decimal en los decimales.

        System.out.println("Introduce código postal");
        int numero = sc.nextInt();
        sc.nextLine();
        System.out.println("Introduce tu calle");
        String calle = sc.nextLine();

        System.out.printf("Calle: %s, código postal %d", calle, numero);

        // Cerrar Scanner al terminar
        sc.close();
    }
}
