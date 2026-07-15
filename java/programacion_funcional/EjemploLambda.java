package programacion_funcional;

@FunctionalInterface
interface Calculadora {
    int operar(int a, int b);
}

public class EjemploLambda {
    public static void main(String[] args) {
        Calculadora suma = (x, y) -> x + y;
        Calculadora resta = (x, y) -> x - y;
        Calculadora multiplicacion = (x, y) -> x * y;

        System.out.println("Suma: " + calcular(5, 3, suma));
        System.out.println("Resta: " + calcular(10, 4, resta));
        System.out.println("Multiplicación: " + calcular(2, 6, multiplicacion));
    }

    public static int calcular(int a, int b, Calculadora operacion) {
        return operacion.operar(a, b);
    }
}
