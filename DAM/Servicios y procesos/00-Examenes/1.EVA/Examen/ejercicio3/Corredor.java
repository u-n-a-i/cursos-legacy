package ejercicio3;

import java.util.Random;

public class Corredor extends Thread {
    private String nombre;
    private int tiempo;

    public Corredor(String nombre) {
        this.nombre = nombre;
        this.tiempo = new Random().nextInt(30) + 30;
    }

    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            try {
                Thread.sleep(tiempo);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("Ha finalizado el corredor: " + nombre);
    }
}
