public class Pares extends ClaseBase {

    public Pares(String nombre) {
        super(nombre);
    }

    @Override
    public void run() {
        int suma = 0;
        System.out.println("Pares");
        /*
         * Otra forma de recorrer pares
         * for (int i = 2; i <= 10; i += 2)
         * Empezar en el primer par, en este caso 2
         * Incrementar de 2
         */
        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 0) {
                System.out.println(nombre + " : " + i);
                suma += i;
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(nombre + " suma de pares = " + suma);
    }
}
