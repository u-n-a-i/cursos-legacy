package ejercicio2;

public class Ejercicio2 {
    private int contador = 0;

    // Método sincronizado para incrementar el contador
    public synchronized void incrementar() {
        for (int i = 0; i < 500; i++) {
            contador++;
        }
    }

    public int getContador() {
        return contador;
    }

    public static void main(String[] args) {
        Ejercicio2 contadorCompartido = new Ejercicio2();

        // Crear 4 hilos
        Thread[] hilos = new Thread[4];
        for (int i = 0; i < hilos.length; i++) {
            hilos[i] = new Thread(() -> {
                contadorCompartido.incrementar();
            });
        }

        for (Thread hilo : hilos) {
            hilo.start();
        }

        // Esperar a que todos los hilos terminen
        for (Thread hilo : hilos) {
            try {
                hilo.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Valor final del contador: " + contadorCompartido.getContador());
    }
}
