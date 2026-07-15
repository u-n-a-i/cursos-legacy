package poo.abstraccion;

public class Perro extends Animal {
    // Constructor que llama al constructor padre
    public Perro(String nombre) {
        super(nombre);
    }

    // Método abstracto de Animal
    @Override
    public void hacerSonido() {
        System.out.println("Gua Gua");
    }
}
