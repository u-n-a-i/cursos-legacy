package ampliando_conceptos.anotaciones;

import java.lang.annotation.*; // Necesario para crear una anotación
import java.lang.reflect.*;   // Para acceder a la anotación en tiempo de ejecución

// Definimos nuestra anotación personalizada
@Retention(RetentionPolicy.RUNTIME) // Disponible en tiempo de ejecución
@Target(ElementType.METHOD) // Se aplica solo a métodos
@interface Autorizado {
    String nivel() default "usuario"; // Define un atributo con valor por defecto
}

// Clase de ejemplo con métodos anotados
class Sistema {
    @Autorizado(nivel = "admin")
    public void accesoAdmin() {
        System.out.println("Accediendo a funciones de administrador...");
    }

    @Autorizado // Usa el valor por defecto "usuario"
    public void accesoUsuario() {
        System.out.println("Accediendo a funciones de usuario...");
    }
}