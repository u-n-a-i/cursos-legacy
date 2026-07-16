class Boxeador extends Thread {
    private String nombre;
    private Ring ring;
    private int golpesPropios = 0;

    public Boxeador(String nombre, Ring ring) {
        // asignar el nombre al hilo
        super(nombre);
        this.nombre = nombre;
        this.ring = ring;
    }

    public int getGolpesPropios() {
        return golpesPropios;
    }

    @Override
    public void run() {
        while (ring.getGolpesTotales() < ring.getLimite()) {
            if (ring.golpear(nombre)) {
                golpesPropios++;
                try {
                    Thread.sleep((int) (Math.random() * 50));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
