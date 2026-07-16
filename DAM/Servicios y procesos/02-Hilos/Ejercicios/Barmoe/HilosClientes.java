package barmoe;

public class HilosClientes extends Thread {
    private Camarero camarero;
    private double litrosConsumidos = 0.0;

    public HilosClientes(String nombre, Camarero camarero) {
        super(nombre);
        this.camarero = camarero;
    }

    @Override
    public void run() {
        System.out.println(getName() + " ha comenzado a beber.");
        while (true) {
            try {
                VasoCerveza vaso = camarero.servirCerveza();
                if (vaso != null) {
                    double cantidad = vaso.getTipo() == 0 ? 0.25 : 0.5;
                    litrosConsumidos += cantidad;
                    System.out.println(getName() + " está bebiendo " + cantidad + "L de cerveza. Total: "
                            + litrosConsumidos + "L");
                    Thread.sleep(500); // Simula el tiempo de beber
                    camarero.devolverCerveza(vaso);
                }
                Thread.sleep((int) (Math.random() * 750 + 250)); // Espera entre 250 y 1000 ms
            } catch (InterruptedException e) {
                System.out.println(getName() + " fue interrumpido.");
                break;
            } catch (Exception e) {
                System.out.println("Error en " + getName() + ": " + e.getMessage());
            }
        }
    }
}
