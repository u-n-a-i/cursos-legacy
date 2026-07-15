package ampliando_conceptos.genericos;

public class Ticket<T> {
    private T detalle;

    public Ticket(T detalle) {
        this.detalle = detalle;
    }

    public T getDetalle() {
        return detalle;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "detalle= " + detalle +
                '}';
    }
}
