package fundamentos;

public class TiposDeDatos {
    public static void main(String[] args) {
        /*
        Los tipos de datos en Java (y en otros lenguajes de programación) son clasificaciones que indican
        qué tipo de valor puede contener una variable y qué operaciones se pueden hacer con ella.
        En otras palabras, los tipos de datos le dicen al compilador:
        Cuánta memoria reservar.
        Qué tipo de valor puede almacenar (número, texto, carácter, etc.).
        Qué operaciones se pueden aplicar (sumar, concatenar, comparar, etc.).

         */

        // Tipos de datos primitivos

        // Enteros
        byte enteroPequenio = 10;
        short enteroCorto = 200;
        int enteroEstandar = 1000;
        long enteroLargo = 9000000000000L; // Es necesario poner una L o l al final cuando se pase del int.

        // Hexadecimal
        byte num2 = 0x02; // numero 2
        byte num11 = 0x0B; // numero 11

        // Binario
        byte binario = 0b01;

        // Decimal
        double decimal = 4.4;
        float flotante = 4.5F; // float y long necesitan una f o una d al final
        System.out.println(0.1); // por defecto son decimal tienes que poner una f para indicar float.

        // Precision de los decimales
        // Float utiliza 4 bytes (precisión simple)
        // Double 8 bytes (precisión doble)
        System.out.println(0.1 + 0.2);
        System.out.println(0.1f + 0.2f);
        double precision = 0.1f + 0.2f;
        System.out.println("precision = " + precision);

        // Booleanos (Valor lógico)
        boolean verdadero = true;
        boolean falso = false;

        // Carácter
        char caracter = 'a'; // Poner entre comillas simples
        char ascii = 65;
        char unicode = '\u03A9';
        char simboloChino = '你';

        // Tipos de Datos Referenciados (o No Primitivos)
        // Son objetos o referencias a objetos, y pueden ser mucho más complejos.
        String cadenasDeTexto = "Esto son cadenas de carácteres";
        int[] numeros = {1, 2, 3, 4}; // Conjunto de elementos del mismo tipo.

        /*
        Diferencias claves: primitivos y referenciados
        Primitivos se almacenan directamente y no usan métodos de forma directa.
        Referenciados se almacena su referencia(referencia única) y tienen métodos.
         */

        // Variables
        // Una variable es un espacio en memoria donde puedes almacenar un valor
        // que puede cambiar durante la ejecución del programa.
        // Convención minúsculas o camelCase
        int edad = 99;

        // Constantes
        // Una constante es un valor que no cambia una vez asignado.
        // Se declaran con final y se ponen en mayúsculas(convención)
        final double PI = 3.1416;
    }

}
