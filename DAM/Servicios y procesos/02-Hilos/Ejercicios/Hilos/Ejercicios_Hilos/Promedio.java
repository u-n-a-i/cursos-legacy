import java.util.Scanner;

public class Promedio extends Thread {
    private String nombre;
    private double[] notas = new double[5];

    public Promedio(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void run() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingresar notas para " + nombre);

        for (int i = 0; i < 5; i++) {
            System.out.print("Nota " + (i + 1) + ": ");
            notas[i] = sc.nextDouble();
        }

        double suma = 0;
        for (double nota : notas) {
            suma += nota;
        }

        double promedio = suma / notas.length;
        System.out.println("Promedio de " + nombre + ": " + promedio);

        sc.close();
    }

    public static void main(String[] args) {
        Promedio alumno = new Promedio("Unai");
        alumno.start();
    }
}
