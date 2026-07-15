package poo.abstraccion;

public class Test {
    public static void main(String[] args) {
        Perro perro = new Perro("Goofy");
        perro.hacerSonido();

        Pajaro pajaro = new Pajaro("Rudolf");
        pajaro.volar();
        pajaro.hacerSonido();
    }
}
