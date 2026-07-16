class Ring {
    private int golpesTotales = 0;
    private final int LIMITE = 50;

    public synchronized boolean golpear(String nombre) {
        if (golpesTotales < LIMITE) {
            golpesTotales++;
            System.out.println(nombre + " golpea. Total: " + golpesTotales);
            return true;
        }
        return false;
    }

    public int getGolpesTotales() {
        return golpesTotales;
    }

    public int getLimite() {
        return LIMITE;
    }
}
