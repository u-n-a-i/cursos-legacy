public class Impares extends ClaseBase {

    public Impares(String nombre) {
        super(nombre);
    }

    @Override
    public void run() {
        System.out.println("Impares");

        for (int i = 1; i <= 9; i += 2) {
            System.out.println(nombre + " : " + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}
