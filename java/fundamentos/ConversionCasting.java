package fundamentos;

public class ConversionCasting {
    public static void main(String[] args) {
        /*
        La conversión de tipos (casting) consiste en cambiar el tipo de una variable a otro tipo compatible,
        como pasar de int a double, o de char a int.
         */

        // Conversión implícita (automática) / widening conversion.
        // Ocurre cuando Java convierte de un tipo más pequeño a uno más grande sin pérdida de datos.
        int x = 10;
        double y = x;

        char c = 'C';
        int ascii = c; // 67

        // Conversión explícita (casting) / narrowing conversion.
        // Necesaria cuando Java no puede garantizar que la conversión sea segura, como al pasar de double a int.
        double a = 9.9;
        int b = (int) a; // pierde la parte decimal

        // clases envolventes (wrappers)
        String cadena = "123";
        // int numero = cadena;  -> Error
        // int numero = (int) cadena;  -> Error
        int numero = Integer.parseInt(cadena);
        double decimal = Double.parseDouble(cadena);
    }
}
