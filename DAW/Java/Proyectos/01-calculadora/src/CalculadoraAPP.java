import java.util.Scanner;

public class CalculadoraAPP {

    // Métodos para operaciones
    public static int sumar(int a, int b) {
        return a + b;
    }

    public static int restar(int a, int b) {
        return a - b;
    }

    public static int multiplicar(int a, int b) {
        return a * b;
    }

    public static double dividir(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("No se puede dividir por 0.");
        }
        return (double) a / b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean continuar = true;

        System.out.println("**** Calculadora ****");

        while (continuar) {
            // Mostrar menú
            System.out.println("""
                    1. Suma
                    2. Resta
                    3. Multiplicación
                    4. División
                    5. Salir
                    """);
            System.out.print("¿Operación a realizar? ");

            try {
                int operacion = Integer.parseInt(sc.nextLine());

                if (operacion == 5) {
                    System.out.println("Fin");
                    continuar = false;
                    continue;
                }

                System.out.print("Valor operando 1: ");
                int operando1 = Integer.parseInt(sc.nextLine());

                System.out.print("Valor operando 2: ");
                int operando2 = Integer.parseInt(sc.nextLine());

                switch (operacion) {
                    case 1 -> System.out.println("Resultado Suma = " + sumar(operando1, operando2));
                    case 2 -> System.out.println("Resultado Resta = " + restar(operando1, operando2));
                    case 3 -> System.out.println("Resultado Multiplicación = " + multiplicar(operando1, operando2));
                    case 4 -> System.out.println("Resultado División = " + dividir(operando1, operando2));
                    default -> System.out.println("Opción no válida");
                }

            } catch (NumberFormatException e) {
                System.out.println("Entrada no válida. Introduce números enteros.");
            } catch (ArithmeticException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        sc.close();
    }
}
