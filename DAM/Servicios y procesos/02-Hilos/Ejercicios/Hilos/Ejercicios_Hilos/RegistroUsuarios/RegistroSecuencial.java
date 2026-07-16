import java.util.Scanner;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class RegistroSecuencial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime horaEntradaOficial = LocalTime.of(8, 0); // 8:00 AM

        for (int i = 1; i <= 2; i++) {
            System.out.println("Ingrese el nombre del usuario " + i + ":");
            String nombre = scanner.nextLine();

            System.out.println("Ingrese el día de ingreso (ej. Lunes):");
            String dia = scanner.nextLine();

            System.out.println("Ingrese la hora de ingreso en formato HH:mm (ej. 07:45):");
            String horaTexto = scanner.nextLine();

            LocalTime horaIngreso = LocalTime.parse(horaTexto, formatoHora);

            System.out.println("Registro:");
            System.out.println("Usuario: " + nombre);
            System.out.println("Día: " + dia);
            System.out.println("Hora de ingreso: " + horaIngreso);

            if (horaIngreso.isBefore(horaEntradaOficial)) {
                System.out.println(nombre + " llegó temprano.");
            } else if (horaIngreso.equals(horaEntradaOficial)) {
                System.out.println(nombre + " llegó justo a tiempo.");
            } else {
                System.out.println(nombre + " llegó tarde.");
            }

            System.out.println("-----------------------------");
        }

        scanner.close();
    }
}
