public class NumerosConRetardo {
    public static void main(String[] args) {
        for (int i = 20; i <= 40; i++) {
            System.out.println("Número: " + i);
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                System.out.println("Hilo interrumpido");
            }
        }
        System.out.println("Fin");
    }
}
