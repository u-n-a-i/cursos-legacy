package arrays;

public class ArrayEjemplo {
    public static void main(String[] args) {
        /*
        Un array es una estructura de datos que guarda una colección de elementos del mismo tipo,
        en posiciones llamadas índices.
         */
        int[] enteros = {1, 2, 3, 4};
        System.out.println(enteros[0]); // Primero
        System.out.println(enteros[enteros.length - 1]); // Ultimo

        double[] decimal = {3.3, 4.4, 0.9};
        System.out.println(decimal[2]);

        String[] compra = {"Leche", "Galletas", "Manzanas"};
        for (String c : compra) {
            System.out.println(c);
        }
    }
}
