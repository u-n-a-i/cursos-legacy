import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.util.Base64;
import java.util.Scanner;

public class AppAES {

    public static void main(String[] args) throws Exception {

        // 1. Generar clave AES de 128 bits
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(128);
        SecretKey claveAES = keyGen.generateKey();

        System.out.println("Clave AES generada (Base64): " +
                Base64.getEncoder().encodeToString(claveAES.getEncoded()));

        // 2. Leer mensaje del usuario
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce el mensaje a cifrar: ");
        String mensaje = sc.nextLine();

        // 3. Cifrar
        Cipher cifrador = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cifrador.init(Cipher.ENCRYPT_MODE, claveAES);
        byte[] cifrado = cifrador.doFinal(mensaje.getBytes());

        String cifradoBase64 = Base64.getEncoder().encodeToString(cifrado);
        System.out.println("Mensaje cifrado (Base64): " + cifradoBase64);

        // 4. Descifrar
        cifrador.init(Cipher.DECRYPT_MODE, claveAES);
        byte[] descifrado = cifrador.doFinal(Base64.getDecoder().decode(cifradoBase64));

        System.out.println("Mensaje descifrado: " + new String(descifrado));
    }
}
