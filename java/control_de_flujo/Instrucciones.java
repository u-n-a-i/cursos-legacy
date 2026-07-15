package control_de_flujo;

public class Instrucciones {
    public static void main(String[] args) {
        /*
        Las instrucciones **continue**, **break** y **return** en Java se usan para controlar el flujo de ejecución
        dentro de bucles (for, while, do-while) y métodos. Son herramientas muy útiles para salir de bucles,
        omitir iteraciones o terminar métodos.
         */

        // Continue
        for (int i = 1; i <= 5; i++) {
            if (i == 3) {
                continue; // Se saltara el numero 3
            }
            System.out.println(i);
        }

        System.out.println("### Separador ###");
        // Break
        for (int i = 1; i < 5; i++) {
            if (i == 3) {
                break; // Se termina el bucle
            }
            System.out.println(i);
        }
    }
}
