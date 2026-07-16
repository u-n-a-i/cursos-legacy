import modelo.Monitor;
import modelo.Ordenador;
import modelo.Raton;
import modelo.Teclado;
import servicio.Pedido;

public class TestTienda {
    public static void main(String[] args) {
        // Lenovo
        Raton ratonLenovo = new Raton("cable", "Lenovo");
        System.out.println("ratonLenovo = " + ratonLenovo);
        Teclado tecladoLenovo = new Teclado("Bluetooth", "Lenovo");
        System.out.println("tecladoLenovo = " + tecladoLenovo);
        Monitor monitorLenovo = new Monitor("Lenovo", 27);
        System.out.println("monitorLenovo = " + monitorLenovo);
        Ordenador pcLenovo = new Ordenador("Lenovo 579", monitorLenovo, tecladoLenovo, ratonLenovo);
        System.out.println("pcLenovo = " + pcLenovo);

        // Samsung
        Raton ratonSamsung = new Raton("USB", "Samsung");
        Teclado tecladoSamsung = new Teclado("Bluetooth", "Samsung");
        Monitor monitorSamsung = new Monitor("Samsung", 50);
        Ordenador pcSamsung = new Ordenador("Samsung New A", monitorSamsung, tecladoSamsung, ratonSamsung);


        System.out.println("****Pedidos ****");
        Pedido p1 = new Pedido();
        p1.agregarOrdenador(pcLenovo);
        p1.agregarOrdenador(pcSamsung);
        p1.mostrarPedido();

    }
}
