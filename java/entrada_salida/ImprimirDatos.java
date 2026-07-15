package entrada_salida;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.logging.Logger;

public class ImprimirDatos {
    public static void main(String[] args) throws FileNotFoundException {
        /*
        Mostrar datos por pantalla.
        La clase System en Java es una clase final de la biblioteca estándar (java.lang.System)
        que proporciona acceso a recursos del sistema, como:
        Entrada/salida estándar (System.in, System.out, System.err)
        Propiedades del sistema
        Variables de entorno
        Gestión de memoria
        Tiempos de ejecución, etc.
        ## De momento solo salída de datos (En clases integradas está la clase System)
        */

        // System . out – Salida estándar
        System.out.println("Hola mundo"); // Imprime texto con salto de línea
        System.out.print("Sin salto");    // Imprime en la misma línea

        // System.err – Salida de errores
        System.err.println("¡Ocurrió un error!"); // Aparece en rojo en muchas consolas

        /* PrintWriter
        La clase PrintWriter se utiliza para imprimir datos en archivos u otros tipos de salidas.
        Puedes crear un objeto PrintWriter para un archivo específico y luego utilizar métodos
        como print() o println() para escribir datos en el archivo.
         */

        PrintWriter writer = new PrintWriter("src\\entrada_salida\\archivo.txt");
        writer.println("Este es un ejemplo de texto en un archivo.");
        writer.close();

        // Logger
        Logger logger = Logger.getLogger("Mi logger");
        logger.info("Mensaje de prueba, Iniciando los Logs");

    }
}
