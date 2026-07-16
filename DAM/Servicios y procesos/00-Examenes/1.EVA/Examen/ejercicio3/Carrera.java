package ejercicio3;

public class Carrera {
    private Corredor[] corredores;

    public Carrera(int cantidadCorredores) {
        corredores = new Corredor[cantidadCorredores];
        for (int i = 0; i < cantidadCorredores; i++) {
            corredores[i] = new Corredor("Corredor_" + (i + 1));
        }
    }

    public void iniciar() {
        for (Corredor c : corredores) {
            c.start();
        }
        for (Corredor c : corredores) {
            try {
                c.join();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
