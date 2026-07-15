package poo.polimorfismo;

public class Calculadora {

    // Sobrecarga: sumar con diferentes tipos o cantidad de parámetros
    int sumar(int a, int b) {
        return a + b;
    }

    int sumar(int a, int b, int c) {
        return a + b + c;
    }

    double sumar(double a, double b) {
        return a + b;
    }


    // Método que se va a sobrescribir
    void mostrarTipo() {
        System.out.println("Calculadora básica");
    }
}
