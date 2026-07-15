package poo.abstraccion;

public class Pajaro extends Animal implements Volador {

    public Pajaro(String nombre) {
        super(nombre);
    }

    @Override
    public void volar() {
        System.out.println("El pajaro vuela");
    }

    @Override
    public void hacerSonido() {
        System.out.println("Pio Pio");
    }
}
