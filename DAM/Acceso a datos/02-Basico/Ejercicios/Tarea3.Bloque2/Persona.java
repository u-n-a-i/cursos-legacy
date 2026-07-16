import java.io.Serializable;

public class Persona implements Serializable {
    private int id;
    private String nombre;
    private int edad;
    private String dni;

    public Persona(int id, String nombre, int edad, String dni) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getDni() {
        return dni;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    // toString
    @Override
    public String toString() {
        return "Persona{id=" + id + ", nombre='" + nombre + "', edad=" + edad + ", dni='" + dni + "'}";
    }
}
