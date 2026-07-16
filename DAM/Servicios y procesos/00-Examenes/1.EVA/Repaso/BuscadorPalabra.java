import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class BuscadorPalabra extends Thread {
    private final File directorio;
    private final String palabra;

    public BuscadorPalabra(String rutaDirectorio, String palabra) {
        this.directorio = new File(rutaDirectorio);
        this.palabra = palabra;
    }

    @Override
    public void run() {
        System.out.println("Buscando la palabra \"" + palabra + "\" en archivos de texto...");

        if (!directorio.exists() || !directorio.isDirectory()) {
            System.out.println("El directorio no existe o no es válido.");
            return;
        }

        File[] archivos = directorio.listFiles((dir, name) -> name.toLowerCase().endsWith(".txt"));
        if (archivos == null || archivos.length == 0) {
            System.out.println("No se encontraron archivos .txt en el directorio.");
            return;
        }

        int contador = 0;
        for (File archivo : archivos) {
            try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
                String linea;
                while ((linea = br.readLine()) != null) {
                    if (linea.contains(palabra)) {
                        contador++;
                        break;
                    }
                }
            } catch (IOException e) {
                System.out.println("Error leyendo archivo: " + archivo.getName());
            }
        }

        System.out.println("Archivos que contienen \"" + palabra + "\": " + contador);
    }

    public static void main(String[] args) {
        String ruta = "/home/dam/Documentos";
        String palabra1 = "texto";
        String palabra2 = "prueba2";

        BuscadorPalabra hilo1 = new BuscadorPalabra(ruta, palabra1);
        BuscadorPalabra hilo2 = new BuscadorPalabra(ruta, palabra2);

        hilo1.start();
        hilo2.start();
    }
}
