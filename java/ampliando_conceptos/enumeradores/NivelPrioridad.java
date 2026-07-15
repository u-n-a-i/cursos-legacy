package ampliando_conceptos.enumeradores;

public enum NivelPrioridad {
    // Enum con métodos y constructor
    BAJA(1),
    MEDIA(5),
    ALTA(10);

    private final int valor;

    NivelPrioridad(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }

    public String toString() {
        return name() + " (Valor: " + valor + ")";
    }
}
