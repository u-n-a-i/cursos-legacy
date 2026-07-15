package arrays;

public class Matriz {
    public static void main(String[] args) {
        /*
        Una matriz es un array de arrays. Es decir, una estructura bidimensional.
         */
        int[][] enteros = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        // System.out.println(enteros[0][1]);

        // Recorrer con for
        for (int i = 0; i < enteros.length; i++) {
            for (int j = 0; j < enteros[i].length; j++) {
                System.out.println(enteros[i][j]);
            }
            System.out.println("-----------");
        }

        // Irregular
        int[][] irregular = {
                {1, 2, 3},
                {4, 5},
                {7, 8, 9, 10}
        };

        for (int i = 0; i < irregular.length; i++) {
            for (int j = 0; j < irregular[i].length; j++) {
                irregular[i][j] = i + j;  // ejemplo de asignación
                System.out.print(irregular[i][j] + " ");
            }
            System.out.println();
        }

    }
}
