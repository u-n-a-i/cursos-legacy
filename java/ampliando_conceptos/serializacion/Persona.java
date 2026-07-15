package ampliando_conceptos.serializacion;

import java.io.Serializable;

public class Persona implements Serializable {
    /*
    La serialización en Java es el proceso de convertir un objeto en un flujo de bytes
    que puede ser almacenado en un archivo, transmitido a través de una red o persistido de alguna otra manera.
    El proceso inverso, de convertir el flujo de bytes de nuevo en un objeto, se llama deserialización.
     */
    private static final long SERIAL_VERSION_UID = 1L;
    String nombre;
    int edad;
    transient String profesion; // transient indica que este campo no se serializará

    public Persona(String nombre, int edad, String profesion) {
        this.nombre = nombre;
        this.edad = edad;
        this.profesion = profesion;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", profesion='" + profesion + '\'' +
                '}';
    }
}
