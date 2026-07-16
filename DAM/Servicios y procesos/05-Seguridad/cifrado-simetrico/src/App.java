import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.io.Console;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {
        // Validación de parámetros
        if (args.length != 3) {
            System.err.println("Uso: java DESCifrador <-cif|-des> <fichero_entrada> <fichero_salida>");
            System.exit(1);
        }

        String modo = args[0];
        String ficheroEntrada = args[1];
        String ficheroSalida = args[2];

        boolean cifrar = false;
        if (modo.equals("-cif")) {
            cifrar = true;
        } else if (modo.equals("-des")) {
            cifrar = false;
        } else {
            System.err.println("Error: Modo no válido. Use -cif para cifrar o -des para descifrar.");
            System.exit(1);
        }

        // Lectura segura de la contraseña
        Console consola = System.console();
        char[] passwordChars;
        if (consola != null) {
            passwordChars = consola.readPassword("Introduzca la contraseña: ");
            if (passwordChars == null || passwordChars.length == 0) {
                System.err.println("Error: Contraseña no proporcionada.");
                System.exit(1);
            }
        } else {
            // Fallback para entornos sin consola (ej: IDEs) - MENOS SEGURO
            System.err.println("ADVERTENCIA: Entorno sin consola segura. La contraseña será visible al escribirla.");
            java.util.Scanner scanner = new java.util.Scanner(System.in);
            System.out.print("Introduzca la contraseña: ");
            String passStr = scanner.nextLine();
            passwordChars = passStr.toCharArray();
            scanner.close();
        }

        try {
            // Conversión segura de contraseña a clave DES (8 bytes)
            byte[] claveBytes = derivarClaveDES(passwordChars);

            // Limpiar inmediatamente el array de caracteres de la contraseña
            Arrays.fill(passwordChars, ' ');

            // Generar clave DES
            SecretKey claveDES = generarClaveDES(claveBytes);

            // Limpiar el array de bytes de la clave derivada
            Arrays.fill(claveBytes, (byte) 0);

            // Leer contenido del fichero de entrada
            byte[] datosEntrada;
            try {
                datosEntrada = Files.readAllBytes(Paths.get(ficheroEntrada));
            } catch (IOException e) {
                System.err.println("Error al leer el fichero de entrada: " + e.getMessage());
                System.exit(1);
                return; // Para evitar advertencias de compilación
            }

            // Procesar cifrado/descifrado
            byte[] datosSalida;
            try {
                datosSalida = procesarDatos(datosEntrada, claveDES, cifrar);
            } catch (Exception e) {
                System.err.println("Error en el procesamiento: " + e.getMessage());
                if (e.getMessage().contains("InvalidKeyException")) {
                    System.err.println("Posible causa: Clave DES débil o no válida. Intente con otra contraseña.");
                }
                System.exit(1);
                return;
            }

            // Escribir resultado en fichero de salida
            try {
                Files.write(Paths.get(ficheroSalida), datosSalida);
            } catch (IOException e) {
                System.err.println("Error al escribir el fichero de salida: " + e.getMessage());
                System.exit(1);
            }

            System.out.println("Operación completada exitosamente.");
            System.out.println("Modo: " + (cifrar ? "CIFRADO" : "DESCIFRADO"));
            System.out.println("Entrada: " + ficheroEntrada);
            System.out.println("Salida: " + ficheroSalida);

        } finally {
            // Garantizar limpieza de memoria sensible incluso en caso de error
            if (passwordChars != null) {
                Arrays.fill(passwordChars, ' ');
            }
        }
    }

    /**
     * Convierte la contraseña en una clave de 8 bytes para DES
     * usando truncamiento o relleno con ceros (método simple para fines educativos)
     */
    private static byte[] derivarClaveDES(char[] passwordChars) {
        byte[] passwordBytes = new String(passwordChars).getBytes(StandardCharsets.UTF_8);
        byte[] clave8Bytes = new byte[8];

        // Copiar bytes de la contraseña (truncar si es más larga, rellenar con ceros si
        // es más corta)
        int longitud = Math.min(passwordBytes.length, 8);
        System.arraycopy(passwordBytes, 0, clave8Bytes, 0, longitud);

        // Limpiar inmediatamente el array temporal
        Arrays.fill(passwordBytes, (byte) 0);

        return clave8Bytes;
    }

    /**
     * Genera una clave SecretKey para DES a partir de 8 bytes
     */
    private static SecretKey generarClaveDES(byte[] claveBytes) throws Exception {
        DESKeySpec keySpec = new DESKeySpec(claveBytes);
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
        return keyFactory.generateSecret(keySpec);
    }

    /**
     * Realiza el cifrado o descifrado usando DES/ECB/PKCS5Padding
     */
    private static byte[] procesarDatos(byte[] datos, SecretKey clave, boolean cifrar) throws Exception {
        Cipher cifrador = Cipher.getInstance("DES/ECB/PKCS5Padding");
        cifrador.init(cifrar ? Cipher.ENCRYPT_MODE : Cipher.DECRYPT_MODE, clave);
        return cifrador.doFinal(datos);
    }
}