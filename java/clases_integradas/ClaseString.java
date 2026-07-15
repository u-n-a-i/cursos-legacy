package clases_integradas;

import java.util.Arrays;

public class ClaseString {
    public static void main(String[] args) {
        /*
        La clase `String` es una de las clases más utilizadas en Java.
        Representa una secuencia de caracteres y
        proporciona una amplia variedad de métodos para manipular cadenas de texto.
         */
        String texto = "Texto de prueba.";
        String texto2 = "Texto DE Prueba.";

        // Métodos
        System.out.println(texto.length()); // Longitud
        System.out.println(texto.charAt(0)); // Carácter
        System.out.println(texto.substring(0, 5)); // Subcadena
        System.out.println(texto.equals(texto2)); // Comparar
        System.out.println(texto.equalsIgnoreCase(texto2)); // Comparar ignorando mayúsculas
        System.out.println(texto.toUpperCase()); // Mayúsculas
        System.out.println(texto.toLowerCase()); // Minúsculas
        System.out.println(texto.trim()); // Espacios en blanco al principio y final
        System.out.println(texto.replace("e", "3")); // Reemplazar
        System.out.println(Arrays.toString(texto.split(" "))); // Divide la cadena en un arreglo de subcadenas
        System.out.println("Posición: " + texto.indexOf("de")); // Primera ocurrencia de una subcadena

        /* StringBuffer
        Para manejar cadenas de manera mutable, es decir, donde se pueden realizar modificaciones en su contenido,
        se puede utilizar la clase `StringBuffer`.
        A diferencia de la clase `String`, los objetos `StringBuffer` son mutables,
        lo que significa que su contenido puede ser modificado sin necesidad de crear un nuevo objeto en cada operación.
         */

        StringBuffer buffer = new StringBuffer(texto);
        buffer.append(" agregando más texto."); // Insertar texto al final
        buffer.insert(6, "-"); // Insertar una - en la posición 5
        buffer.replace(6, 6, "!"); // Reemplazar - por un signo de exclamación
        buffer.deleteCharAt(4); // Eliminar el espacio en la posición 4
        System.out.println(buffer);
    }
}
