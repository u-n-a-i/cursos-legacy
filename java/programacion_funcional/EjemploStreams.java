package programacion_funcional;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EjemploStreams {
    public static void main(String[] args) {
        List<String> nombres = Arrays.asList("Ana", "Carlos", "Bea", "David", "Eva");

        // Fuente: la lista 'nombres'
        // Operaciones intermedias:
        //   1. filter(): Conserva solo los nombres que empiezan con 'A' o 'E'
        //   2. map(): Convierte los nombres a mayúsculas
        //   3. sorted(): Ordena los nombres alfabéticamente
        // Operación terminal:
        //   4. collect(): Recoge los resultados en una nueva lista

        List<String> nombresFiltradosOrdenados = nombres.stream()
                .filter(nombre -> nombre.startsWith("A") || nombre.startsWith("E"))
                .map(String::toUpperCase)
                .sorted()
                .collect(Collectors.toList());

        System.out.println(nombresFiltradosOrdenados);

        // Otro ejemplo con operación terminal diferente
        long cantidadNombresConB = nombres.stream()
                .filter(nombre -> nombre.startsWith("B"))
                .count(); // Operación terminal: cuenta el número de elementos
        System.out.println("Cantidad de nombres que empiezan con 'B': " + cantidadNombresConB);

        // Ejemplo con forEach (operación terminal con efecto secundario)
        System.out.println("Nombres originales:");
        nombres.stream()
                .forEach(System.out::println);
    }
}
