public class ConThread {
    public static void main(String[] args) {
        Thread ceros = new Thread() {
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    System.out.print("0 ");
                }
            }
        };

        Thread unos = new Thread() {
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    System.out.print("1 ");
                }
            }
        };

        ceros.start();
        unos.start();
    }
}
