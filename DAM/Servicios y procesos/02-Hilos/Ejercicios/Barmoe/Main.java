package barmoe;

public class Main {
    public static void main(String[] args) {
        Camarero mou = new Camarero("Mou");

        HilosClientes homer = new HilosClientes("Homer", mou);
        HilosClientes barney = new HilosClientes("Barney", mou);
        HilosClientes carl = new HilosClientes("Carl", mou);
        HilosClientes lenny = new HilosClientes("Lenny", mou);
        HilosClientes lurleen = new HilosClientes("Lurleen", mou);

        homer.start();
        barney.start();
        carl.start();
        lenny.start();
        lurleen.start();

        // monitor de vasos cada 5 segundos
        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(5000);
                    mou.contarVasos();
                } catch (InterruptedException e) {
                    break;
                }
            }
        }).start();
    }
}
