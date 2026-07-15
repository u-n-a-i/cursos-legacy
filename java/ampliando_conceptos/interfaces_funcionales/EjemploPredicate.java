package ampliando_conceptos.interfaces_funcionales;

import java.util.function.Predicate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EjemploPredicate {
    /*
     Representa una función que acepta un argumento de tipo T y devuelve un valor booleano.
     Se utiliza típicamente para filtrar elementos.
     */

    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        Predicate<Integer> esPar = n -> n % 2 == 0;
        Predicate<Integer> esMayorQueCinco = n -> n > 5;

        List<Integer> pares = numeros.stream()
                .filter(esPar)
                .collect(Collectors.toList());
        System.out.println("Números pares: " + pares); // Salida: [2, 4, 6, 8, 10]

        List<Integer> mayoresQueCinco = numeros.stream()
                .filter(esMayorQueCinco)
                .collect(Collectors.toList());
        System.out.println("Números mayores que 5: " + mayoresQueCinco); // Salida: [6, 7, 8, 9, 10]

        List<Integer> paresYMayoresQueCinco = numeros.stream()
                .filter(esPar.and(esMayorQueCinco)) // Combinando Predicates
                .collect(Collectors.toList());
        System.out.println("Pares y mayores que 5: " + paresYMayoresQueCinco); // Salida: [6, 8, 10]
    }
}
