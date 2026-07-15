package metodos;

public class Sobrecarga {
    public static void main(String[] args) {
        /*
        Es cuando una clase tiene varios métodos con el mismo nombre pero con diferentes parámetros (tipo, número o ambos).
         */
        System.out.println(sumar(4, 4));
        System.out.println(sumar(3, 5, 9));
        System.out.println(sumar(4.99, 3.45));
    }

    public static int sumar(int a, int b) {
        return a + b;
    }

    public static int sumar(int a, int b, int c) {
        return a + b + c;
    }

    public static double sumar(double a, double b) {
        return a + b;
    }
}
