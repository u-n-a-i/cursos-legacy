import java.util.InputMismatchException;
import java.util.Scanner;

public class Prueba {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String nombreFactura;
        double precio1;
        double precio2;

        try{
            System.out.println("Nombre de la factura");
            nombreFactura = scanner.nextLine();

            System.out.println("Precio del producto 1");
            precio1 = scanner.nextDouble();

            System.out.println("Precio del producto 2");
            precio2 = scanner.nextDouble();
        }catch (InputMismatchException e){
            System.out.println(e);
            return;
        }

        String factura = nombreFactura;
        factura += "\n" + precio1 + "€";
        factura += "\n" + precio2 + "€";
        factura += "\n" + "total = " + (precio1+precio2) + "€";

        System.out.println(factura);
    }
}