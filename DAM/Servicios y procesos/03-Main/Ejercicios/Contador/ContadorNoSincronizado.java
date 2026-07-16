public class ContadorNoSincronizado {
    private static int contador = 0;

    public static void main(String[] args) {
        // Array con 5 hilos
        Thread[] hilos = new Thread[5];

        // bucle para lanzar los 5 hilos
        for (int i = 0; i < hilos.length; i++) {
            hilos[i] = new Thread(() -> {
                // incrementar contador por cada hilo
                for (int j = 0; j < 1000; j++) {
                    contador++;
                }
            });

            hilos[i].start();
        }

        // recorrer hilos
        for (int i = 0; i < hilos.length; i++) {
            try {
                hilos[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Ejecutar un par de veces, no siempre sobrescribe y muestra 5000
        System.out.println("Contador: " + contador);

    }
}
