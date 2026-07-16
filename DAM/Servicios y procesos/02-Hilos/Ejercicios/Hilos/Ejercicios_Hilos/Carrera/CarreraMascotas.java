import java.util.Scanner;

public class CarreraMascotas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce el nombre de la primera mascota:");
        String nombre1 = sc.nextLine();

        System.out.println("Introduce el nombre de la segunda mascota:");
        String nombre2 = sc.nextLine();

        System.out.println("Introduce el nombre de la tercera mascota:");
        String nombre3 = sc.nextLine();

        Mascota mascota1 = new Mascota(nombre1);
        Mascota mascota2 = new Mascota(nombre2);
        Mascota mascota3 = new Mascota(nombre3);

        mascota1.start();
        mascota2.start();
        mascota3.start();

        try {
            mascota1.join();
            mascota2.join();
            mascota3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Fin");
    }
}