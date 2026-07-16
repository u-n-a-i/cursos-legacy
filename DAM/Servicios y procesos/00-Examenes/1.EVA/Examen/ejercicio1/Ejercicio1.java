package ejercicio1;

public class Ejercicio1 {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.err.println(
                    "Error: Se requiere al menos un argumento de operación ('sum' o 'max') y una lista de números.");
            return;
        }

        String operacion = args[0];
        double[] numeros = new double[args.length - 1];

        try {
            for (int i = 1; i < args.length; i++) {
                numeros[i - 1] = Double.parseDouble(args[i]);
            }
        } catch (NumberFormatException e) {
            System.err.println("Error: Todos los argumentos después del primero deben ser números válidos.");
            return;
        }

        switch (operacion) {
            case "sum":
                double suma = 0;
                for (double num : numeros) {
                    suma += num;
                }
                System.out.println("Suma: " + suma);
                break;

            case "max":
                double maximo = numeros[0];
                for (double num : numeros) {
                    if (num > maximo) {
                        maximo = num;
                    }
                }
                System.out.println("Máximo: " + maximo);
                break;

            default:
                System.err.println("Error: Operación no válida. Use 'sum' o 'max'.");
        }
    }
}
