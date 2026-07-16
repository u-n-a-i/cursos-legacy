public class ContadorSincronizado {
    private static int contador = 0;

    // Incrementar pero solo UN HILO a la vez
    public static synchronized void incrementar() {
        contador++;
    }

    public static void main(String[] args) {
        Thread[] hilos = new Thread[5];

        for (int i = 0; i < hilos.length; i++) {
            hilos[i] = new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    incrementar();
                }
            });
            hilos[i].start();
        }

        for (int i = 0; i < hilos.length; i++) {
            try {
                hilos[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Contador: " + contador);
    }
}
