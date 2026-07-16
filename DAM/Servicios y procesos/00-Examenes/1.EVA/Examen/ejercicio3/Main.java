package ejercicio3;

public class Main {
    public static void main(String[] args) {
        for (int ronda = 1; ronda <= 20; ronda++) {
            System.out.println("\n--- Carrera número " + ronda + " ---");
            Carrera carrera = new Carrera(8);
            carrera.iniciar();
        }
    }
}
