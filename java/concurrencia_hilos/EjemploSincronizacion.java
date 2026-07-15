package concurrencia_hilos;

class ContadorCompartido {
    private int contador = 0;

    // Método sincronizado
    public synchronized void incrementar() {
        contador++;
    }

    public int getContador() {
        return contador;
    }
}

public class EjemploSincronizacion {
    public static void main(String[] args) throws InterruptedException {
        ContadorCompartido contador = new ContadorCompartido();

        Runnable tarea = () -> {
            for (int i = 0; i < 1000; i++) {
                contador.incrementar();
            }
        };

        Thread hilo1 = new Thread(tarea);
        Thread hilo2 = new Thread(tarea);

        hilo1.start();
        hilo2.start();

        hilo1.join(); // Espera a que hilo1 termine
        hilo2.join(); // Espera a que hilo2 termine

        System.out.println("Contador final: " + contador.getContador());
    }
}
