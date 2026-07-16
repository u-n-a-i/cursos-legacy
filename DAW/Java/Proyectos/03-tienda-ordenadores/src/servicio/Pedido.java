package servicio;

import modelo.Ordenador;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private final int idPedido;
    private final List<Ordenador> ordenadores;
    private static int contadorOrdenes;

    public Pedido() {
        ordenadores = new ArrayList<>();
        idPedido = ++contadorOrdenes;
    }

    public void agregarOrdenador(Ordenador ordenador) {
        ordenadores.add(ordenador);
    }

    public void mostrarPedido() {
        System.out.println("Pedido: " + idPedido);
        System.out.println("Total ordenadores: " + ordenadores.size());
        System.out.println();
        ordenadores.forEach(System.out::println);
    }
}
