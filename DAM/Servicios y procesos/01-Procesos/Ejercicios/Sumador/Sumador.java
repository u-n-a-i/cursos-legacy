// 
public class Sumador {
    public static long sumar(int n1, int n2) {
        long suma = 0;
        for (int i = n1; i <= n2; i++) {
            suma += i;
        }
        return suma;
    }

    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Sumador");
            return;
        }

        try {
            int n1 = Integer.parseInt(args[0]);
            int n2 = Integer.parseInt(args[1]);
            long resultado = sumar(n1, n2);
            System.out.println(resultado);
        } catch (NumberFormatException e) {
            System.out.println("Error: tienen que ser números enteros.");
        }
    }
}
