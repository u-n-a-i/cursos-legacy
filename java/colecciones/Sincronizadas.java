package colecciones;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Sincronizadas {
    public static void main(String[] args) {
        Map<String, String> mapaNoSincronizado = new HashMap<>();
        Map<String, String> mapaSincronizado = Collections.synchronizedMap(mapaNoSincronizado);

        mapaSincronizado.put("Clave1", "Valor1");
        mapaSincronizado.put("Clave2", "Valor2");

        /*
        synchronized es un modificador que se usa para garantizar que solo un hilo pueda acceder a un bloque de código
        o método a la vez, evitando problemas de concurrencia.
         */
        synchronized (mapaSincronizado) {
            for (Map.Entry<String, String> entrada : mapaSincronizado.entrySet()) {
                System.out.println("Clave: " + entrada.getKey() + ", Valor: " + entrada.getValue());
            }
        }
    }
}
