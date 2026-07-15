package ampliando_conceptos.estaticos;

public class ContadorTest {
    public static void main(String[] args) {
        Contador c1 = new Contador("Objeto 1");
        Contador c2 = new Contador("Objeto 2");
        Contador c3 = new Contador("Objeto 3");

        // Acceso a través de la clase
        System.out.println("Cuenta total de objetos creados: " + Contador.cuenta);

        // Acceso a través de un objeto (no recomendado)
        System.out.println("Cuenta total (a través de objeto): " + c1.cuenta);

        // Acceso a través de método estático
        System.out.println("Cuenta total (método estático): " + Contador.obtenerCuenta());
    }
}
