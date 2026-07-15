package poo.encapsulacion;

public class Persona {
    /* La encapsulación:
     Se usa para proteger los datos de un objeto evitando el acceso directo desde fuera de la clase.
     */
    // Atributos privados
    private String nombre;
    private int edad;

    // Constructor
    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        setEdad(edad);  //  set para validar
    }

    // Getter
    public String getNombre() {
        return nombre;
    }

    //Setter
    public void setNombre(String nombre) {
        if (!nombre.isEmpty()) {
            this.nombre = nombre;
        } else {
            System.out.println("Nombre no valido.");
        }
    }

    public int getEdad() {
        return edad;
    }

    private void setEdad(int edad) {
        if (edad > 0) {
            this.edad = edad;
        } else {
            System.out.println("Edad no valida");
        }
    }
}
