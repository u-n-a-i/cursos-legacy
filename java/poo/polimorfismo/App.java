package poo.polimorfismo;

public class App {
    public static void main(String[] args) {
        // Polimorfismo por sobrecarga
        Calculadora calc = new Calculadora();
        System.out.println("Suma 2 enteros: " + calc.sumar(2, 3));
        System.out.println("Suma 2 decimales: " + calc.sumar(2.5, 3.1));
        System.out.println("Suma 3 enteros: " + calc.sumar(1, 2, 3));

        // Polimorfismo por sobrescritura
        Calculadora cientifica = new CalculadoraCientifica();
        cientifica.mostrarTipo(); // Se llama al método sobrescrito

        // Acceder a método exclusivo de CalculadoraCientifica
        CalculadoraCientifica calcCient = new CalculadoraCientifica();
        System.out.println("Potencia: " + calcCient.potencia(2, 3));
    }
}
