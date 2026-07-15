package colecciones;

import java.util.HashMap;
import java.util.Map;

public class Mapas {
    public static void main(String[] args) {
        /*
        Un Map en Java es una interfaz que representa una colección de entradas,
        donde cada entrada consiste en una clave única y un valor asociado a esa clave.
         */

        /* HashMap
        Utiliza una tabla hash para almacenar las entradas.
        Ofrece un rendimiento excelente para las operaciones básicas (put, get, remove, containsKey) en promedio,
        pero no garantiza ningún orden en las entradas. Permite una clave nula y múltiples valores nulos.
         */

        Map<String, Integer> edades = new HashMap<>();

        // Añadir entradas al mapa (clave, valor)
        edades.put("Ana", 90);
        edades.put("Juan", 99);
        edades.put("Maria", 90);
        edades.put("Ana", 91); // Si la clave existe se actualiza el valor

        System.out.println(edades);

        // Obtener el valor asociado a una clave
        int edadDeJuan = edades.get("Juan");
        System.out.println("La edad de Juan es: " + edadDeJuan); // Salida: 25

        // Comprobar si una clave existe en el mapa
        boolean contieneAna = edades.containsKey("Ana");
        System.out.println("¿El mapa contiene la clave 'Ana'? " + contieneAna); // Salida: true

        // Comprobar si un valor existe en el mapa
        boolean contieneEdad30 = edades.containsValue(30);
        System.out.println("¿El mapa contiene el valor 30? " + contieneEdad30); // Salida: true

        // Obtener el número de entradas en el mapa
        System.out.println("El tamaño del mapa es: " + edades.size()); // Salida: 3

        // Eliminar una entrada por su clave
        edades.remove("Pedro");
        System.out.println("Mapa después de eliminar a Pedro: " + edades);

        // Iterar sobre las claves del mapa
        System.out.println("Claves en el mapa:");
        for (String clave : edades.keySet()) {
            System.out.println(clave);
        }

        // Iterar sobre los valores del mapa
        System.out.println("\nValores en el mapa:");
        for (Integer valor : edades.values()) {
            System.out.println(valor);
        }

        // Iterar sobre las entradas del mapa (clave-valor)
        System.out.println("\nEntradas en el mapa:");
        for (Map.Entry<String, Integer> entrada : edades.entrySet()) {
            System.out.println("Clave: " + entrada.getKey() + ", Valor: " + entrada.getValue());
        }

        // Limpiar el mapa
        // edades.clear();
        // System.out.println("Mapa después de limpiar: " + edades);
        // System.out.println("¿El mapa está vacío? " + edades.isEmpty()); // Salida: true
    }
}
