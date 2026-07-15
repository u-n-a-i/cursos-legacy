package ampliando_conceptos.reflexion;

import java.lang.annotation.*;

/*
Es útil para frameworks, herramientas de pruebas, inyección de dependencias y más.
 */

// Definimos una anotación personalizada
@Retention(RetentionPolicy.RUNTIME) // Disponible en tiempo de ejecución
@Target(ElementType.FIELD) // Se aplica a atributos
@interface Metadata {
    String descripcion();
}

// Clase con anotaciones en los atributos
class Producto {
    @Metadata(descripcion = "Nombre del producto")
    private String nombre;

    @Metadata(descripcion = "Precio del producto en dólares")
    private double precio;

    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }
}
