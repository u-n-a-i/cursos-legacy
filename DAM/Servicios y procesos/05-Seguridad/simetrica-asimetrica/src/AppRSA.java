import javax.crypto.Cipher;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;
import java.util.Scanner;

public class AppRSA {

    public static void main(String[] args) throws Exception {

        // 1. Generar par de claves RSA
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(2048);
        KeyPair parClaves = keyGen.generateKeyPair();

        PublicKey clavePublica = parClaves.getPublic();
        PrivateKey clavePrivada = parClaves.getPrivate();

        System.out.println("Clave pública (Base64): " +
                Base64.getEncoder().encodeToString(clavePublica.getEncoded()));
        System.out.println("Clave privada (Base64): " +
                Base64.getEncoder().encodeToString(clavePrivada.getEncoded()));

        // 2. Leer mensaje
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce el mensaje a cifrar: ");
        String mensaje = sc.nextLine();

        // 3. Cifrar con la clave pública
        Cipher cifrador = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cifrador.init(Cipher.ENCRYPT_MODE, clavePublica);
        byte[] cifrado = cifrador.doFinal(mensaje.getBytes());

        String cifradoBase64 = Base64.getEncoder().encodeToString(cifrado);
        System.out.println("Mensaje cifrado (Base64): " + cifradoBase64);

        // 4. Descifrar con la clave privada
        cifrador.init(Cipher.DECRYPT_MODE, clavePrivada);
        byte[] descifrado = cifrador.doFinal(Base64.getDecoder().decode(cifradoBase64));

        System.out.println("Mensaje descifrado: " + new String(descifrado));
    }
}
