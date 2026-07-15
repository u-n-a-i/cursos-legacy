package metodos;

public class Metodos {
    // Java empieza el programa ejecutando este método sin crear ningún objeto, por eso debe ser static.
    public static void main(String[] args) {
        System.out.println(sumar(14, 10));
        System.out.println(saludo("Unai"));
        frase();
    }

    // Un método static pertenece a la clase, no a un objeto.
    public static int sumar(int a, int b) {
        return a + b;
    }

    public static String saludo(String nombre) {
        return "Hola 👋 " + nombre;
    }

    public static void frase() {
        System.out.println("Frase de prueba para void.");
    }
}
