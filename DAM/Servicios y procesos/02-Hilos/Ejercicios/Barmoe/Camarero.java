package barmoe;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Camarero {
    private String nombre;
    private List<VasoCerveza> listaVasos;
    private Random random = new Random();

    public Camarero(String nombre) {
        this.nombre = nombre;
        this.listaVasos = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            int tipo = random.nextInt(2); // 0 o 1
            listaVasos.add(new VasoCerveza(i, tipo));
        }
        System.out.println("Camarero " + nombre + " listo con vasos iniciales.");
    }

    public synchronized VasoCerveza servirCerveza() {
        if (listaVasos.isEmpty()) {
            System.out.println("[" + nombre + "] No hay vasos disponibles.");
            return null;
        }
        int index = random.nextInt(listaVasos.size());
        VasoCerveza vaso = listaVasos.remove(index);
        System.out.println("[" + nombre + "] Sirviendo " + vaso);
        return vaso;
    }

    public synchronized void devolverCerveza(VasoCerveza vaso) {
        listaVasos.add(vaso);
        System.out.println("[" + nombre + "] Vaso devuelto: " + vaso);
    }

    public synchronized void contarVasos() {
        System.out.println("[" + nombre + "] Vasos disponibles: " + listaVasos);
    }
}
