package arrays;

public class ArrayFinal {
    public static void main(String[] args) {
        /*
        Cuando declaras un array como final, no significa que su contenido no se puede cambiar,
        sino que la referencia al array no se puede cambiar.
         */
        final int[] enteros = {1, 2, 3};

        enteros[0] = 0; // Permitido

        //enteros = new int[5]; Error: no se puede cambiar la referencia
    }
}
