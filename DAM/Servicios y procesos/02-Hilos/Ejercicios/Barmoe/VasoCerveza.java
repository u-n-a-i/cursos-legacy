package barmoe;

public class VasoCerveza {
    private int id;
    private int tipo; // 0: media pinta, 1: pinta

    public VasoCerveza(int id, int tipo) {
        this.id = id;
        this.tipo = tipo;
        System.out.println("Vaso creado: " + this);
    }

    public int getId() {
        return id;
    }

    public int getTipo() {
        return tipo;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "VasoCerveza{id=" + id + ", tipo=" + (tipo == 0 ? "Media Pinta" : "Pinta") + "}";
    }
}
