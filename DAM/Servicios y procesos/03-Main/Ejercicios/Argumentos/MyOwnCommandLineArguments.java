// Ejecutar el class: java MyOwnCommandLineArguments Monica 12 Daniel 34 Shelley 23

public class MyOwnCommandLineArguments {
    public static void main(String[] args) {
        // Comprobar los arg
        // 2 * persona min 3=6; max 6=12;
        if (args.length < 6 || args.length > 12) {
            System.out.println("Error: Rango entre 3 y 6 personas. Formato nombre edad");
            return;
        }

        // Promedio
        int sumaEdades = 0;
        int cantidadPersonas = args.length / 2;

        // Recorre los impares, donde deberían estar las edades
        for (int i = 1; i < args.length; i += 2) {
            try {
                int edad = Integer.parseInt(args[i]);
                sumaEdades += edad;
            } catch (NumberFormatException e) {
                System.out.println("Error: La edad de " + args[i - 1] + " no es un número válido.");
                return;
            }
        }

        double promedio = (double) sumaEdades / cantidadPersonas;
        System.out.println("Promedio de edades: " + promedio);
    }
}
