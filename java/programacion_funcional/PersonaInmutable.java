package programacion_funcional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class PersonaInmutable {
    private final String nombre;
    private final int edad;
    private final List<String> aficiones; // Lista inmutable

    public PersonaInmutable(String nombre, int edad, List<String> aficiones) {
        this.nombre = nombre;
        this.edad = edad;
        this.aficiones = Collections.unmodifiableList(new ArrayList<>(aficiones)); // Copia defensiva e inmutable
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public List<String> getAficiones() {
        return aficiones; // Devuelve la lista inmutable
    }

    @Override
    public String toString() {
        return "PersonaInmutable{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", aficiones=" + aficiones +
                '}';
    }

    public static void main(String[] args) {
        List<String> aficionesJuan = new ArrayList<>();
        aficionesJuan.add("Leer");
        aficionesJuan.add("Caminar");
        PersonaInmutable juan = new PersonaInmutable("Juan", 30, aficionesJuan);
        System.out.println(juan);

        // Intentar modificar la lista original no afecta al objeto inmutable
        aficionesJuan.add("Nadar");
        System.out.println(juan);

        // Intentar modificar la lista obtenida a través del getter lanzará una excepción
        try {
            juan.getAficiones().add("Correr");
        } catch (UnsupportedOperationException e) {
            System.out.println("No se puede modificar la lista de aficiones.");
        }
    }
}
