package poo.encapsulacion;

public class Test {
    public static void main(String[] args) {
        Persona unai = new Persona("unai", 90);
        //System.out.println(unai.nombre); Es privado, no deja.

        System.out.println(unai.getNombre());
        unai.setNombre("");
        System.out.println(unai.getNombre());
        // unai.setEdad(10); es un método privado

    }
}
