package control_de_flujo;

public class Bucles {
    public static void main(String[] args) {
        // While
        // El bucle `while` se utiliza para repetir un bloque de código mientras se cumpla una condición booleana.
        int contador = 1;

        while (contador <= 4) {
            System.out.println("contador = " + contador);
            contador++;
        }

        // Do While
        //El bucle `do-while` es una estructura de control que se utiliza para ejecutar un bloque de código
        // al menos una vez, y luego repetirlo mientras una condición específica sea verdadera.
        /*Scanner sc = new Scanner(System.in);
        boolean llave = true;
        int total = 0;

        do {
            System.out.println("¿Desea continuar(si/no)?");
            String respuesta = sc.nextLine();

            if (respuesta.equalsIgnoreCase("si")) {
                total++;
            } else {
                llave = false;
            }
        } while (llave);
        System.out.println("total = " + total);*/

        // For
        int tabla = 4;

        for (int i = 0; i <= 10; i++) {
            System.out.println(tabla + " x " + i + " = " + (tabla * i));
        }

        // For mejorado, enhanced for(for-each, for-in)
        // se utiliza para recorrer elementos de una colección o matriz
        // sin necesidad de utilizar un contador explícito ni acceder a los elementos utilizando índices.
        int[] numeros = {1, 2, 3, 4, 5};

        for (int numero : numeros) {
            System.out.println(numero);
        }

    }
}
