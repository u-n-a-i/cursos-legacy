package ampliando_conceptos.anotaciones;

import java.lang.reflect.*;   // Para acceder a la anotación en tiempo de ejecución

// Clase principal para procesar la anotación
public class ControlAcceso {
    public static void main(String[] args) throws Exception {
        Sistema sistema = new Sistema();
        Method[] metodos = sistema.getClass().getDeclaredMethods();

        for (Method metodo : metodos) {
            if (metodo.isAnnotationPresent(Autorizado.class)) {
                Autorizado autorizado = metodo.getAnnotation(Autorizado.class);
                System.out.println("Método: " + metodo.getName() + " - Nivel requerido: " + autorizado.nivel());
            }
        }
    }
}