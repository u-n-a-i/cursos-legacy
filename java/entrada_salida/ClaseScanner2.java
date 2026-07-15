package entrada_salida;

import java.util.Locale;
import java.util.Scanner;

public class ClaseScanner2 {
    public static void main(String[] args) {
        /*
        Usar sc.useDelimiter("\n") junto con next()
        Esto le dice al Scanner que considere el salto de línea (\n) como el único delimitador. Es decir:
        Cada next() leerá hasta el Enter.
        Así, next() se comportará casi igual que nextLine(), pero sin los problemas de buffer.
         */
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.GERMANY); // Decimal con , y no .
        sc.useDelimiter("\n");

        System.out.println("Un entero");
        int entero = sc.nextInt();
        System.out.println("Tu numero es " + entero);

        System.out.println("Un decimal");
        double decimal = sc.nextDouble();
        System.out.println("Tu numero es " + decimal);

        System.out.println("Un string");
        String cadena = sc.next();
        System.out.println("Tu texto es " + cadena);
    }
}
