package ampliando_conceptos.estaticos;

import java.util.HashMap;
import java.util.Map;

class Configuracion {
    public static Map<String, String> propiedades;

    /*
    Definición: Un bloque de código declarado con la palabra clave static (sin nombre de método)
    se llama bloque de inicialización estático. Se ejecuta solo una vez cuando la clase se carga en memoria.

    Uso: Se utiliza para realizar tareas de inicialización complejas para variables estáticas
    que no se pueden inicializar fácilmente en su declaración.

    Orden de ejecución: Los bloques de inicialización estáticos se ejecutan en el orden en que aparecen
    en el código de la clase. Pueden haber múltiples bloques de inicialización estáticos en una clase.
     */

    static { // Bloque de inicialización estático
        System.out.println("Bloque de inicialización estático ejecutándose...");
        propiedades = new HashMap<>();
        propiedades.put("servidor", "localhost");
        propiedades.put("puerto", "8080");
        propiedades.put("timeout", "5000");
        System.out.println("Propiedades inicializadas: " + propiedades);
    }

    public static String obtenerPropiedad(String clave) {
        return propiedades.get(clave);
    }

    public static void main(String[] args) {
        System.out.println("Accediendo a las propiedades...");
        String servidor = Configuracion.obtenerPropiedad("servidor");
        String puerto = Configuracion.obtenerPropiedad("puerto");
        System.out.println("Servidor: " + servidor);
        System.out.println("Puerto: " + puerto);

        Configuracion otraConfig = new Configuracion();
        System.out.println("Accediendo de nuevo...");
        System.out.println("Timeout: " + Configuracion.obtenerPropiedad("timeout"));
    }
}




