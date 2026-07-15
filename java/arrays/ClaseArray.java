package arrays;

import java.util.Arrays;

public class ClaseArray {
    public static void main(String[] args) {
        /*
        Es una clase de utilidades que no crea arrays, sino que proporciona funciones estáticas para
        ordenarlos, imprimirlos, buscar elementos, copiar, llenar, etc.
         */
        int[] enteros = {404, 99, 73, 21, 17, 0};

        // Imprimir el array
        System.out.println(Arrays.toString(enteros));

        // Ordenar
        Arrays.sort(enteros);
        System.out.println(Arrays.toString(enteros));

        // Rellenar con 9
        Arrays.fill(enteros, 9);
        System.out.println(Arrays.toString(enteros));

        // Comparar 
        double[] decimalDouble = {1.1, 2.2, 3.3};
        float[] decimalFloat = {1.1f, 2.2f, 3.3f};
        // System.out.println(Arrays.equals(decimalDouble, decimalFloat)); Arrays.equals(double[], float[]) no existe en Java.
        // Si quieres comparar los valores de decimalDouble y decimalFloat, tendrás que hacerlo manualmente, elemento por elemento.
        double[] decimalDouble2 = {1.1, 2.2, 3.3};
        System.out.println(Arrays.equals(decimalDouble, decimalDouble2)); // true
        System.out.println(decimalDouble == decimalDouble2); // false (compara referencias)

        // Copiar
        int[] copia = Arrays.copyOf(enteros, enteros.length); // Longitud para copiar todos, puedes copiar n posiciones.
        System.out.println(Arrays.toString(copia));

    }
}
