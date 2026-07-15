package poo.abstraccion;

abstract class Animal {
    /* Clase Abstracta
    Permite ocultar los detalles internos y mostrar solo lo necesario para el uso de un objeto.
    Ocultar la implementación interna de una clase o comportamiento.
    Exponer solo la funcionalidad esencial al usuario.
    Se logra en Java usando:
        - Clases abstractas
        - Interfaces

    Una clase abstracta:
        No se puede instanciar directamente.
        Puede tener métodos con o sin cuerpo.
        Puede tener atributos y métodos normales.
        Se usa como base para otras clases.
     */
    // Atributos
    String nombre;

    // Constructor
    public Animal(String Animal) {
        this.nombre = nombre;
    }

    // Métodos
    public void dormir() {
        System.out.println("Esta durmiendo");
    }

    public abstract void hacerSonido();  // método abstracto
}
