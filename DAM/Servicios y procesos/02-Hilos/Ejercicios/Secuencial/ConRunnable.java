public class ConRunnable {
    public static void main(String[] args) {
        Runnable imprimirCeros = () -> {
            for (int i = 0; i < 1000; i++) {
                System.out.print("0 ");
            }
        };

        Runnable imprimirUnos = () -> {
            for (int i = 0; i < 1000; i++) {
                System.out.print("1 ");
            }
        };

        Thread hiloCeros = new Thread(imprimirCeros);
        Thread hiloUnos = new Thread(imprimirUnos);

        hiloCeros.start();
        hiloUnos.start();
    }
}
