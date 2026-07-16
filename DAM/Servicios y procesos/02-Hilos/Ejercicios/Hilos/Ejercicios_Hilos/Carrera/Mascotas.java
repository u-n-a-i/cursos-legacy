import java.util.Scanner;

class Mascota extends Thread {
    private String nombre;
    private int distanciaRecorrida = 0;
    private static final int META = 30;

    public Mascota(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void run() {
        while (distanciaRecorrida < META) {
            distanciaRecorrida++;
            System.out.println(nombre + " ha recorrido " + distanciaRecorrida + " metros.");
            try {
                Thread.sleep((int) (Math.random() * 200));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("#### META ####");
        System.out.println(nombre + " ha llegado a la meta!");
        System.out.println("###############");
    }
}
