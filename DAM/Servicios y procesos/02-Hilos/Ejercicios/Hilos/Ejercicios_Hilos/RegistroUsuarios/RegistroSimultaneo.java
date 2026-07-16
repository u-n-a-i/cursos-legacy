public class RegistroSimultaneo {
    public static void main(String[] args) {
        Usuario u1 = new Usuario("Laura", "Martes", "07:45");
        Usuario u2 = new Usuario("Carlos", "Martes", "08:15");

        u1.start();
        u2.start();
    }
}