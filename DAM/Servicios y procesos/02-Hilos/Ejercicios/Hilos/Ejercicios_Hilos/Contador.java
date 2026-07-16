public class Contador implements Runnable {
    private int contador, limite;
    private String nombreHilo;

    public Contador(int limite, String nombreHilo) {
        this.limite = limite;
        this.nombreHilo = nombreHilo;
        this.contador = 0;
    }

    // Ejecutar hilo
    @Override
    public void run() {
        while (contador < limite) {
            contador++;
            System.out.println(nombreHilo + "contador: " + contador);

            try {
                Thread.sleep(100);
            } catch (Exception e) {
                System.out.println(nombreHilo + " interrumpido");
            }
            System.out.println(nombreHilo + " terminado");
        }
    }

    public static void main(String[] args) {
        Contador c1 = new Contador(10, "Hilo 1");
        Contador c2 = new Contador(20, "Hilo 2");

        Thread t1 = new Thread(c1);
        Thread t2 = new Thread(c2);

        t1.start();
        t2.start();
    }

}
