package entrada_salida;

import java.util.Arrays;
import java.util.Formatter;
import java.util.logging.Logger;

public class FormatearSalida {
    public static void main(String[] args) {
        // Es mostrar los datos por consola de forma organizada y legible

        /* System.out.printf()
         %d -> entero 404
         %f -> decimales 3.14 (.2f == 2 decimales)
         %s -> cadena de texto
         %c -> carácter 'A'
         %n -> salto de línea como \n
         %b	Booleano
         * */
        int cantidad = 10;
        double precio = 9.99;
        String nombre = "Detergente";
        System.out.printf("Producto: %s, quedan: %d, y tiene un valor de %.2f€ %n", nombre, cantidad, precio);

        // String.format()
        // Funciona igual que printf, pero devuelve una cadena.
        String mensaje = String.format("Producto: %s, quedan: %d, y tiene un valor de %.2f€", nombre, cantidad, precio);
        System.out.println(mensaje);

        // Formater: La clase Formatter proporciona más control sobre la salida formateada.
        Formatter formatter = new Formatter();
        formatter.format("Producto: %s, quedan: %d, y tiene un valor de %.2f€ %n",
                nombre + " plus", cantidad - 5, precio + 10);
        System.out.println(formatter);
        formatter.close();

    }
}
