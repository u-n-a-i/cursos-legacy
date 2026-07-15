package colecciones;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Colas {
    public static void main(String[] args) {
        /*
        La interfaz Queue en Java representa una colección de elementos que se mantienen en un orden específico
        enqueue (encolar): Añadir un elemento al final de la cola. En Java, esto se hace con el método add() o offer().
        add(E e): Lanza una excepción (IllegalStateException) si la cola no puede aceptar más elementos
        (por ejemplo, en una cola con capacidad limitada).
        offer(E e): Devuelve false si la cola está llena, en lugar de lanzar una excepción.

        dequeue (desencolar): Remover y devolver el elemento que está al frente de la cola (el primero que se añadió).
        En Java, esto se hace con los métodos remove() o poll().
        peek (mirar): Devolver el elemento que está al frente de la cola sin removerlo.
        En Java, esto se hace con el método peek().
         */

        /*
           Clase LinkedList implementando la interface de Queue
         */
        Queue<String> cola = new LinkedList<>();

        // Añadir al final
        cola.add("Elemento 1");
        cola.add("Elemento 2");
        cola.offer("Elemento 3"); // Ejemplo, pero no tiene sentido en un LinkedList
        /*
        Queue<String> colaLimitada = new ArrayBlockingQueue<>(2);
        colaLimitada.add("A");
        colaLimitada.add("B");
        // colaLimitada.add("C"); // Lanza una excepción
        System.out.println(colaLimitada.offer("C")); // Retorna false sin lanzar excepción
         */
        System.out.println(cola);

        // Ver el elemento al frente de la cola (sin removerlo)
        String primerElemento = cola.peek();
        System.out.println("Primer elemento en la cola (peek): " + primerElemento);

        // Desencolar elementos (remover del frente)
        String elementoRemovido1 = cola.remove(); // remove() lanza excepción si la cola está vacía
        System.out.println("Elemento desencolado (remove): " + elementoRemovido1);
        System.out.println("Cola después de remove(): " + cola);

        String elementoRemovido2 = cola.poll();   // poll() devuelve null si la cola está vacía
        System.out.println("Elemento desencolado (poll): " + elementoRemovido2);
        System.out.println("Cola después de poll(): " + cola);

        // Comprobar si la cola está vacía
        boolean estaVacia = cola.isEmpty();
        System.out.println("¿La cola está vacía? " + estaVacia);

        // Obtener el tamaño de la cola
        int longitud = cola.size();
        System.out.println("Tamaño de la cola: " + longitud);


    }
}
