package control_de_flujo;

public class Condicionales {
    public static void main(String[] args) {

        // If-else
        // Permite ejecutar un bloque de código si la condición es verdadera y otro si es falsa.
        int edad = 17;

        if (edad >= 18) {
            System.out.println("Eres mayor de edad.");
        } else {
            System.out.println("No eres mayor de edad.");
        }

        // if-else if-else
        int vida = 15;
        if (vida >= 90) {
            System.out.println("No te preocupes.");
        } else if (vida >= 50) {
            System.out.println("Vas bien.");
        } else {
            System.out.println("Empieza ha buscar un botiquín");
        }


        // Switch La sentencia `switch` evalúa una variable y ejecuta el bloque correspondiente al caso que coincida.
        int dia = 3;

        switch (dia) {
            case 1:
                System.out.println("Lunes");
                break;
            case 2:
                System.out.println("Martes");
                break;
            case 3:
                System.out.println("Miércoles");
                break;
            case 4:
                System.out.println("Jueves");
                break;
            default:
                System.out.println("Solo abrimos de lunes a jueves");
        }

        // Switch "mejorado"
        // A partir de Java 14, `switch` permite eliminar la necesidad de `break`
        // y permitiendo múltiples valores en un solo caso
        int mes = 5;

        switch (mes) {
            case 1 -> System.out.println("Enero");
            case 2 -> System.out.println("Febrero");
            case 3 -> System.out.println("Marzo");
            case 4 -> System.out.println("Abril");
            case 5 -> System.out.println("Mayo");
            default -> System.out.println("Cerrado");
        }
    }

}
