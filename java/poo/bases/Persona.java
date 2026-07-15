package poo.bases;

/*
Una clase es un modelo o plantilla para crear objetos.
Define qué datos tiene un objeto (atributos) y qué puede hacer (métodos).
 */
public class Persona {
    // Atributos(propiedades)
    String nombre;
    int edad;

    // Constructor (método especial para crear objetos)
    public Persona(String nombre, int edad) {
        // This se refiere al atributo del objeto actual
        this.nombre = nombre; // this.nombre == atributo de la clase && nombre es el parámetro que se pasa.
        this.edad = edad;
    }

    // Métodos
    public void saludar() {
        System.out.println("Hola, soy " + nombre + " y tengo " + edad + " años.");
    }
}
