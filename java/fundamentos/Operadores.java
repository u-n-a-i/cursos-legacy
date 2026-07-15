package fundamentos;

public class Operadores {
    public static void main(String[] args) {
        /*
        Operadores:
         */

        // Operadores Aritméticos: Se usan para operaciones matemáticas.
        int suma = 4 + 4;
        int resta = 10 - 7;
        int multiplicacion = 8 * 9;
        int division = 20 / 3;
        int modulo = 20 % 3;

        // Operadores de Asignación: Asignan valores a variables.
        int x = 5;
        x += 3;  // x = 5 + 3 → x = 8
        x *= 2;  // x = 8 * 2 → x = 16

        // Operadores de Comparación/Relacionales: Usados para comparar valores. Devuelven true o false.
        boolean op = 4 == 4; // true
        boolean op2 = 5 == 4; // false
        boolean op3 = 1 != 0; // true
        boolean op4 = 10 >= 3; // true
        boolean op5 = 20 < 100; // true
        boolean op6 = "Hola" == "hola"; // true pero USAR EQUALS para cadenas
        boolean op7 = "Hola".equals("hola"); // false
        boolean op8 = "Hola".equalsIgnoreCase("hola"); // hola
        boolean op9 = 5 == 5.5f; // false
        boolean op10 = 4 == 4f; // true
        // Cuidado con la perdida de precision al operar con floats y doubles
        boolean pre = (1 / 10f) == 0.1; // false


        // Operadores Lógicos: Usados con expresiones booleanas.
        int edad = 18;
        boolean acceso = false;
        boolean log1 = (edad >= 18) && (acceso); // false
        boolean log2 = (edad >= 18) || (acceso); // true

        // Operadores Unarios: Operan sobre un solo operando.
        int q = 1;
        q++; // q vale 1, se incrementa en la siguiente llamada.
        q--; // q vale 2, en la siguiente llamada vale 1.
        ++q; // q vale 2

        // Operadores Ternarios: Forma compacta de un if-else.
        int cantidad = 0;
        String tarta = cantidad > 0 ? "Quedan tartas" : "No quedan tartas";

        // Operadores Bit a Bit: Manipulan bits directamente.
        int bit = 3 & 4; // 0
        int bit2 = 3 | 4; // 7
        int bit3 = 3 ^ 4; // 12
        int bit4 = ~4; // -4
    }
}
