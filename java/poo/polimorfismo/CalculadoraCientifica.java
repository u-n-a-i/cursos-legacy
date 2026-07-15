package poo.polimorfismo;

public class CalculadoraCientifica extends Calculadora {
    // Sobrescritura del método
    @Override
    void mostrarTipo() {
        System.out.println("Calculadora científica");
    }

    double potencia(double base, double exponente) {
        return Math.pow(base, exponente);
    }
}
