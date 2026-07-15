package concurrencia_hilos;

// Implementando la interfaz Runnable
class MiTarea implements Runnable {
    @Override
    public void run() {
        System.out.println("Tarea ejecutándose en el hilo: " + Thread.currentThread().getName());
    }
}

// Extendiendo la clase Thread
class MiHilo extends Thread {
    @Override
    public void run() {
        System.out.println("Hilo ejecutándose: " + getName());
    }
}

public class EjemploHilos {
    public static void main(String[] args) {
        Thread hilo1 = new Thread(new MiTarea());
        MiHilo hilo2 = new MiHilo();

        hilo1.start(); // Inicia la ejecución del hilo
        hilo2.start(); // Inicia la ejecución del hilo
        System.out.println("Hilo principal: " + Thread.currentThread().getName());
    }
}
