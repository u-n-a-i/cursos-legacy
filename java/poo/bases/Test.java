package poo.bases;

public class Test {
    public static void main(String[] args) {
        Persona unai = new Persona("Unai", 90);
        unai.saludar();

        System.out.println("Es publico-> " + unai.nombre);
    }
}
